package hiding;

public class Member {
	// 은닉된 멤버변수 -> 현재 블록 안에서만 접근 가능함
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 은닉된 멤버변수에 값을 넣는 방법 -> public 메서드 사용,  setter
	public void setName( String name ) {
		this.name = name;
	}
	
	// setAge
	public void setAge(int age) {
		if( age >= 0 ) {
			this.age = age;
		} else {
			this.age = 0;
		}
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





