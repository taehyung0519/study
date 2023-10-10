package override;

public class Main02 {

	public static void main(String[] args) {
		Army am = new Army("육군");
		
		am.attack();
		am.tank();
		
		// Navy
		Navy nv = new Navy("해군");
		
		nv.attack();
		nv.nucleus();
		
		// AirForce
		AirForce af = new AirForce("공군");
		
		af.attack();
		af.bombing();
		
	}

}







