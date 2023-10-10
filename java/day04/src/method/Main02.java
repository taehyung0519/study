package method;

public class Main02 {

	public static void main(String[] args) {
		plus(10);
		plus(100);
		plus(1000);
		minus(10, 5);
		minus(20, 5);
		minus(30, 15);
	}
	
	public static void minus(int x, int y) {
		System.out.println(x - y);
	}
	
	public static void plus(int x) {
		System.out.println(x);
	}

}










