package Interface;

/*
 * 인터페이스 상속을 위한 implements
 *  - 인터페이스 상속은 implements 키워드를 사용한다
 *  - 인터페이스도 추상화를 구현하고 있기 때문에,
 *  인터페이스를 상속받는 클래스는 인터페이스내의 
 *  모든 메서드들을 반드시 재정의 해야 한다. 
 *  - 인터페이스는 콤마(,)로 연결하여 여러 개를 동시에 상속 받을 수 있다.
 *  - 필요한 경우 다른 클래스와 동시에 상속받을 수 있다.(implements, extends)
 */
public class User implements Unit {

	@Override
	public void attack() {
		
	}

	@Override
	public void shield() {
		
	}

}







