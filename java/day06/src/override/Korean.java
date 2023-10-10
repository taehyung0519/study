package override;

public class Korean extends Hello {
	public void say() {
		System.out.println("안녕하세요");
	}
	
	public void sayHello() {
		super.say();
		this.say();
	}
}
