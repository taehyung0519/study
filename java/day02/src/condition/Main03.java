package condition;

public class Main03 {

	public static void main(String[] args) {
		boolean is_korean = true;
		int age = 25;
		
		if( is_korean == true ) {
			System.out.println("한국사람 입니다.");
			
			if( age > 20 ) {
				System.out.println("성인인증 입니다. ");
			} else {
				System.out.println("미성년자 입니다. ");
			}
			
		}
		
		if( is_korean == false ) {
			System.out.println("한국사람 아닙니다.");
		}
		
		if( is_korean ) {	// 값 자체가 참이므로 성립된다.
			System.out.println("한국사람 입니다.");
		}
		
		if( !is_korean ) {	// "!"는 값을 부정한다. 참을 부정하므로 거짓이다.
			System.out.println("한국사람이 아닙니다.");
		}
		
		System.out.println("---------------------");
		
		if( is_korean ) {
			System.out.println("한국사람 입니다.");
		} else {
			System.out.println("한국사람이 아닙니다.");
		}
		
	}

}









