package loop;

public class Main10 {

	public static void main(String[] args) {
		/*
		 * 1. 1~10까지의 합
		 */
		int sum = 0;
		for( int i = 1; i<=10; i++ ) {
			sum += i;
		}
		System.out.println("1~10까지의 합 : " + sum);
		System.out.println("------------");
		
		/*
		 * 2. 1~10까지의 홀수의 합
		 */
		int sum2 = 0;
		for( int i = 1; i<=10; i++ ) {
			if( i%2 == 1 ) {
				sum2 += i;
			}			
		}
		System.out.println("1~10까지의 홀수의 합 : " + sum2);
		System.out.println("------------");
		
		/*
		 * 3. 1~10까지의 짝수의 합
		 */
		int sum3 = 0;
		for( int i = 1; i<=10; i++ ) {
			if( i%2 == 0 ) {
				sum3 += i;
			}			
		}
		System.out.println("1~10까지의 짝수의 합 : " + sum3);
		System.out.println("------------");
		
	}

}












