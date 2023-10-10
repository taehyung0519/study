package Abstract;

public class Main01 {

	public static void main(String[] args) {
		Army army = new Army("육군");
		Navy navy = new Navy("해군");
		AirForce af = new AirForce("공군");
		
		army.attack();
		army.move();
		
		navy.move();
		navy.attack();
		
		af.move();
		af.attack();
		
	}

}










