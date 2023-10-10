package condition;

public class Main05 {

	public static void main(String[] args) {
		int a = 0;
		if( 1 > 3 ) {
			a = 10;
		} else {
			a = 30;
		}
		System.out.println("a : " + a);
		
		// 삼항연산자를 사용
		a = ( 1 > 3 ) ? 10 : 30; 
		System.out.println("a : " + a);
		
	}

}









