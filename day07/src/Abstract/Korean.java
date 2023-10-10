package Abstract;

// 추상 클래스를 상속받는 과정은 일반 클래스의 상속과 동일하게
// extends 키워드를 사용한다. 
public class Korean extends Hello {
	/*
	 * 만약, 상속받은 클래스에 생성자가 존재한다면 부모 생성자의 강제 호출에
	 * 대한 처리를 요구하는 의미로 에러가 표시된다.
	 */
	public Korean(String msg) {
		super(msg);
	}

	/*
	 * 추상 메서드를 상속 받고 에러를 해결하는 과정에서
	 * 부모가 정의하고 있는 메서드들을 재정의하게 된다.
	 * 추상 클래스는 이와 같이 자식 클래스가 정의해야 하는 
	 * 규격을 강제하기 위하여 사용한다. 
	 */
	@Override
	public void sayHello() {
		
	}

}












