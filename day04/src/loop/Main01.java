package loop;

public class Main01 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		// 1~100까지의 홀수들의 합
		while(true) {
			i++;
			if( i%2 == 0 ) {
				continue;
			}
			if( i>100 ) {
				break;
			}
			sum += i;
			System.out.println(i);
		}
		System.out.println(sum);	
	}

}










