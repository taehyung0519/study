package override;

public class Army extends Unit {

	public Army(String name) {
		super(name);
	}
	
	public void tank() {
		System.out.println(super.getName() + " >> 탱크공격");
	}
	
	// Override된 메서드
	@Override
	public void attack() {
		super.attack();
		System.out.println(super.getName() + " >> 지상공격 실행함");
	}
	
}








