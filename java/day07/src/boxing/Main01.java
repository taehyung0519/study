package boxing;

public class Main01 {

	public static void main(String[] args) {
		AirForce af = new AirForce("해군");
		Navy nv = new Navy("공군");
		Army am = new Army("육군");
		
		// 각각의 객체는 자신들의 고유 기능을 사용할 수 있음
		af.attack();
		af.bombing();
		nv.attack();
		nv.nucleus();
		am.attack();
		am.tank();
		
		System.out.println("----------------------");
		
		// 암묵적 형변환
		Unit temp1 = af;
		Unit temp2 = nv;
		Unit temp3 = am;
		
		// 형변환이 되더라도 상속받거나 재정의한(Override)
		// 자신들의 기본 특성을 그대로 유지함
		temp1.attack();
		temp2.attack();
		temp3.attack();
		
		// 자체적인 기능 사용 불가
//		temp1.bombing();
//		temp2.nucleus();
//		temp3.tank();
		
		System.out.println("------------------");
		
		// 다시 원래의 기능을 되돌리기 위해서는 하위 클래스
		// 형태로 명시적 형변환이 필요하다.
		
		AirForce re1 = (AirForce)temp1;
		Navy re2 = (Navy)temp2;
		Army re3 = (Army)temp3;
		
		re1.bombing();
		re2.nucleus();
		re3.tank();
	}

}













