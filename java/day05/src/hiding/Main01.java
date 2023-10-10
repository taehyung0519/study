package hiding;

class User{
	public String name = "자바학생";
	private int weight = 100;
}

public class Main01 {

	public static void main(String[] args) {
		User user = new User();
		
		// public 이므로 접근 가능
		System.out.println(user.name);
		// private 이므로 접근 불가능
		//System.out.println(user.weight);
	}

}









