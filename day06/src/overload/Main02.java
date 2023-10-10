package overload;

public class Main02 {

	public static void main(String[] args) {
		Character c = new Character();
		
		c.setProperty(19);
		System.out.println(c.toString());
		
		c.setProperty("회사원");
		System.out.println(c.toString());
		
		c.setProperty(20, "자영업");
		System.out.println(c.toString());
		
		c.setProperty("교수", 30);
		System.out.println(c.toString());
	}

}












