package method;

/*
 * 사칙연산 메서드 생성
 *  -> +,-,*,/ 각각의 메서드 생성(4건), return, param int 2개, 
 *  -> main()에서 각각 메서드 호출 return 결과 출력
 */

public class Main05 {

	public static void main(String[] args) {
		System.out.println(plus(10, 5));
		System.out.println(minus(10, 5));
		System.out.println(times(10, 5));
		System.out.println(divide(10, 5));
	}
	
	public static int plus(int x, int y) {
		return x + y;
	}
	
	public static int minus(int x, int y) {
		return x - y;
	}
	
	public static int times(int x, int y) {
		return x * y;
	}
	
	public static int divide(int x, int y) {
		int result = 0;
		if( y != 0 ) {
			result = x / y;
		}
		return result;
	}

}








