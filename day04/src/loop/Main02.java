package loop;

public class Main02 {

	public static void main(String[] args) {
		/*
		 * 1. 구구단 2단~9단까지의 결과를 출력
		 * (단, 2중 for문 사용)
		 * 출력 : 2 * 1 = 2
		 * 		2 * 2 = 4
		 * 		...
		 * 		2 * 9 = 18
		 * 		----------------------------
		 * 		...
		 * 		9 * 8 = 72
		 * 		9 * 9 = 81
		 * */
		
		for( int i=2; i<=9; i++ ) {	
			for( int j=1; j<10; j++ ) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
			
			System.out.println("----------------------");
		}
		
		/*
		 * 2번. 8*8열 별찍기
		 	★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
			★★★★★★★★
		 * */
		
		for(int i=0; i<=7; i++) {
			for( int j=0; j<=7; j++ ) {
				System.out.print("★");
			}
			
			System.out.println("");
		}
		System.out.println("----------------");
		
		
		/*
		 * 3번.8*8
		 	★★★★★★★★
			★★★★★★★
			★★★★★★
			★★★★★
			★★★★
			★★★
			★★
			★
		 * */
		for(int i=0; i<=7; i++) {
			for( int j=i; j<=7; j++ ) {
				System.out.print("★");
			}
			System.out.println("");
		}
		System.out.println("---------------------");
		
		/*
		 * 4번.8*8
		 	★
			★★
			★★★
			★★★★
			★★★★★
			★★★★★★
			★★★★★★★
			★★★★★★★★
		 * */
		for( int i=7; i>=0; i-- ) {
			for( int j=i; j<=7; j++ ) {
				System.out.print("★");
			}
			
			System.out.println("");
		}
	}

}










