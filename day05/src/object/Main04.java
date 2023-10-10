package object;

class Calc{
	int plus( int x, int y ) { return x + y; }
	int minus( int x, int y ) { return x - y; }
	int times( int x, int y ) { return x * y; }
	int divide( int x, int y ) { 
		int result = 0;
		if( y != 0 ) {
			result = x/y;
		}
		return result;		
	}	
	int f(int x, int y) {
		int result = plus(x, y) + times(x, y);
		return result;
	}
}

public class Main04 {

	public static void main(String[] args) {
		Calc c = new Calc();
		System.out.println("100 + 50 = " + c.plus(100, 50));
		
		Calc c2 = new Calc();
		System.out.println("100 - 50 = " + c2.minus(100, 50));
		System.out.println("100 - 50 = " + c.minus(100, 50));
		
		System.out.println("100 - 50 = " + c.times(100, 50));
		System.out.println("100 - 50 = " + c.divide(100, 50));
		System.out.println("100 - 50 = " + c.f(100, 50));
		
	}

}









