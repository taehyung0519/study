package math;

public class Helper {
	// 싱글톤 객체로 생성
	private static Helper current;
	
	public static Helper getInstance() {
		if( current == null ) {
			current = new Helper();
		}
		return current;
	}
	private Helper() {}
	
	// 범위를 갖는 랜덤 값을 생성하여 리턴하는 메서드
	public int random(int min, int max) {
		int num = (int)((Math.random() * (max - min + 1)) + min);
		return num;
	}
}






