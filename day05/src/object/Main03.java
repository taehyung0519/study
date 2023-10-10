package object;

class HelloWorld{
	String message;
	
	void sayHello() { System.out.println(message); }
	void setEng() { message = "Hello java"; }
	void setKor() { message = "안녕하세요. 자바"; }
}

public class Main03 {

	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		
		// 메서드를 호출
		hello.setEng();
		hello.sayHello();
		
		hello.setKor();
		hello.sayHello();
		
		
		
	}

}







