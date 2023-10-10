package casting;

public class Main03 {

	public static void main(String[] args) {
		/*
		 * 큰 범위의 변수와 작은 범위의 변수가 연산을 수행하면,
		 * 작은 범위의 변수가 큰 범위의 데이터형으로 암묵적 형변환을 수행한다.
		 * 그러므로 아래의 a+b는 double형의 변수가 되므로,
		 * float 형의 값에 대입하는 것은 에러이다.
		 */
		double a = 10.5d;
		float b = 20.5f;
		
		float f = (float)a + b;
		double d = a + b;
		
		System.out.println("f :  " + f);
		System.out.println("d :  " + d);
		
	}

}




















