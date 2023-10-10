package singleton;

public class Main03 {

	public static void main(String[] args) {
		// 싱글톤 객체 사용하기
		// - getInstance() 메서드를 사용하여 객체를 리턴받는 형식으로 사용한다. 
		// - 여러 객체를 리턴 받더라도 모두 하나의 static 객체를 참조하게 되기 때문에
		//   전역 객체 하나만이 메모리에 할당되게 된다. 
		
		Calc loader1 = Calc.getInstance();
		int a = loader1.plus(100, 50);
		System.out.println(a);
		
		System.out.println(Calc.getInstance().minus(100, 50));
	}

}









