package object;

class Student{
	String name = "자바학생";
	int age = 19;
}

public class Main01 {

	public static void main(String[] args) {
		// 객체의 선언과 할당의 분리
		Student std;
		std = new Student();
		
		// 객체의 생성 일괄지정
		Student std2 = new Student();
		
		System.out.println(std.name);
		System.out.println(std.age);
		
		System.out.println(std2.name);
		System.out.println(std2.age);
		
		std.name = "홍길동";
		std2.name = "이순신";
		
		System.out.println("-------------");
		System.out.println(std.name);
		System.out.println(std.age);
		
		System.out.println(std2.name);
		System.out.println(std2.age);
	}

}





