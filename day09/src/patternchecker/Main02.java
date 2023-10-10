package patternchecker;

public class Main02 {

	public static void main(String[] args) {
		String name = "자바학생";
		String age = "20";
		
		// 정규표현식을 통한 형식 검사
		if( !RegexHelper.getInstance().isKor(name) ) {
			System.out.println("이름은 한글로 입력해주세요.");
			return;
		}
		
		if( !RegexHelper.getInstance().isNum(age) ) {
			System.out.println("나이는 숫자로 입력해주세요");
			return;
		}
		
		
		
		
	}

}







