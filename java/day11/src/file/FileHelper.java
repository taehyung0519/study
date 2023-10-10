package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class FileHelper {
	// 싱글톤
	private static FileHelper current;
	public static FileHelper getInstance() {
		if(current == null) {
			current = new FileHelper();
		}
		return current;
	}
	private FileHelper() {}
	
	// 주어진 경로에 data값을 기록하고 저장한다
	/*
	 * param 	filePath 	: 저장할 파일 경로
	 * param	data		: 저장할 내용을 담을 스트림
	 * return	boolean		: 성공시 true, 실패시 fasle
	 */
	public boolean write( String filePath, byte[] data) {
		boolean result = false;
		
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			// 파일쓰기
			// 변수의 유효성 범위가 서로 달라 인식하지 못한다. 
			out.write(data);
			System.out.println("[INFO]파일 저장 성공 >> " + filePath);
			// 저장에 성공했으므로, 결과값을 true로 변경
			result = true;
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 지정된 경로를 찾을 수 없음 >> " + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + filePath);
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] 알 수 없는 에러 >> " + filePath);
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	// 주어진 경로의 파일을 읽고, 내용을 스트림으로 리턴
	/*
	 * param 	filePath 	: 읽어야할 파일의 경로
	 * return	byte[]		: 읽혀진 내용
	 */ 
	public byte[] read(String filePath) {
		byte[] data = null;
		InputStream in = null;
		
		try {
			in = new FileInputStream(filePath);
			
			// 읽은 내용을 담기 위한 배열은 파일의 용량만큼 사이즈를 할당한다.
			// in.available() : 열고 있는 파일의 크기
			data = new byte[in.available()];
			
			// 파일 읽기 - 파라미터로 전달된 배열 안에, 파일의 내용을 담아준다.
			in.read(data);		
			System.out.println("[INFO] 파일 읽기 성공 >> " + filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[ERROR] 지정된 경로를 찾을 수 없음 >> " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[ERROR] 파일 읽기 실패 >> " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] 알 수 없는 에러 >> " + filePath);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	
	
	// 파일 저장한다
	/*
	 * param	filePath	: 저장할 파일 경로
	 * param	content		: 저장할 내용
	 * param	encType		: 인코딩 형식
	 * return	boolean		: 성공시 true, 실패시 false
	 */
	public boolean writeString(String filePath, 
			String content, String encType) {
		boolean result = false;
		byte[] buffer = null;
		
		try {
			buffer = content.getBytes(encType);
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR] 인코딩 지정 에러");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + filePath);
			e.printStackTrace();
		}
		
		result = this.write(filePath, buffer);
		return result;
	}
	
	// 파일의 내용을 문자열로 리턴한다
	/*
	 * param filePath 	: 읽어야 할 파일의 경로
	 * param encType	: 인코딩 형식
	 * return String 	: 읽은 내용에 대한 문자열
	 */
	public String readString(String filePath, 
			String encType) {
		String content = null;
		
		byte[] data = this.read(filePath);
		
		try {
			content = new String(data, encType);
//			System.out.println(content);
		} catch (UnsupportedEncodingException e) {
			System.out.println("[EROR] 인코딩 지정 에러");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + filePath);
			e.printStackTrace();
		}
		
		return content;
	}
	
	
	
}













