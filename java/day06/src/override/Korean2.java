package override;

// 자식 클래스
public class Korean2 extends Hello2 {
	/*
	 * 부모 생성자의 강제 호출
	 *  - 생성자가  정의된 클래스를 상속받은 경우
	 *  자식 클래스의 생성자를 통해서 부모 생성자를 강제로
	 *  호출해야 한다.
	 *  - 부모의 생성자를 호출하는 방법은 super 키워드를
	 *  메서드 이름으로 사용하는 것이다. 
	 *  - 부모와 동일한 파라미터를 받도록 생성자를 
	 *  정의하고, 전달받은 파라미터를 부모에게 재전달 한다.
	 */
	
	public Korean2( String msg ) {
		super(msg);
	}
	
}






