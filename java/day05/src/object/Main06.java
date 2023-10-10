package object;

class Book{
	String subject;
	String content;
	
	// 생성자 -> 객체가 생성될 때, 자동으로 실행되는 특수한 메서드
	// 특징 -> 리턴형을 명시하지 않는다. 클래스와 이름이 동일하다.
	Book() {
		System.out.println("--생성자 실행됨--");
		this.subject = "java 입문";
		this.content = "java는 객체지향 언어이다.";
	}
}

public class Main06 {

	public static void main(String[] args) {
		// Book클래스의 생성자에서 멤버변수에 대한 기본값을 설정하기 때문에,
		// 객체를 생성하는 것 만으로 멤버변수가 초기화 된다.
		Book book = new Book();
		System.out.println(book.content);
		System.out.println(book.subject);
	}

}








