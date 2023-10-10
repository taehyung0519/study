package hiding;

class Student{
	// 은닉된 멤버변수 -> 현재 블록 안에서만 접근 가능함
	private String name;
	private int age;
	
	// 은닉된 멤버변수에 값을 넣는 방법 -> public 메서드 사용,  setter
	public void setName( String name ) {
		this.name = name;
	}
	
	// setAge
	public void setAge(int age) {
		this.age = age;
	}
	
	// 은닉된 멤버변수의 값을 읽는 방법 -> getter
	public String getName() {
		return this.name;
	}
	
	// getAge
	public int getAge() {
		return this.age;
	}
}

public class Main02 {

	public static void main(String[] args) {
		Student std = new Student();
//		System.out.println(std.name);
//		System.out.println(std.age);
		
		std.setName("자바학생");
		String name = std.getName();
		System.out.println("이름 : " + name);
		
		// 나이 set, 나이를 get, 출력
		std.setAge(20);
		System.out.println("나이 : " + std.getAge());
		
	}

}




