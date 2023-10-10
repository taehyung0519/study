package string;

public class Main03 {

	public static void main(String[] args) {
		/*
		 * 주민등록번호에서 생년월일 추출하기
		 *  ex) 8005011234567 -> 1980년 05월 01일 남자
		 *  태어난 년도 판별
		 *  	-> 성별 코드 1 or 2 : 19~
		 *  	-> 성별 코드 3 or 4 : 20~
		 *  	-> 성별 코드 1 or 3 : 남성
		 *  	-> 성별 코드 2 or 4 : 여성
		 */
		String jumin = "8005011234567";
		// 주민번호를 년,월,일 단위로 각 두 글자씩 자르기
		String yy = jumin.substring(0,2);
		String mm = jumin.substring(2,4);
		String dd = jumin.substring(4,6);
		
		// 성별코드
		String gender_code = jumin.substring(6,7);
		
		// 태어난 년도의 판별
		if( gender_code.equals("1") || gender_code.equals("2") ) {
			yy = "19" + yy;
		} else {
			yy = "20" + yy;
		}
				
		// 기본 성별
		String gender = "남자";
		// 2 or 4일때 여자
		if( gender_code.equals("2") || gender_code.equals("4") ) {
			gender = "여자";
		}
		
		// 내용출력(String.format + System.out.println)
		System.out.printf("%s년 %s월 %s일 %s", yy, mm, dd, gender);
		
	}

}









