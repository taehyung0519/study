package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Main02 {

	public static void main(String[] args) {
		// 저장할 파일의 경로
		final String PATH = "./test.txt";
//		final String PATH = "F:/gb_kjh_0630/java/workspace/day11/src/file/test.txt";
		
		// 파일에 저장할 내용
		String write_string = "user,admin,홍길동";
		// 객체나 배열이 선언과 할당에 대한 블록이 서로 분리되어 있을 경우
		// 명시적으로 빈 영역임을 알리기 위하여 null로 초기화
		byte[] buffer = null;
		OutputStream out = null;
		
		// 특정 인코딩 방식 적용
		try {
			buffer = write_string.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 파일 저장 절차 시작
		try {
			out = new FileOutputStream(PATH);
			// 파일쓰기
			// 변수의 유효성 범위가 서로 달라 인식하지 못한다. 
			out.write(buffer);
			System.out.println("[INFO]파일 저장 성공 >> " + PATH);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 지정된 경로를 찾을 수 없음 >> " + PATH);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + PATH);
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] 알 수 없는 에러 >> " + PATH);
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}










