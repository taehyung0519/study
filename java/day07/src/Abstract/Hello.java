package Abstract;

public abstract class Hello {
	private String msg;

	public Hello(String msg) { this.msg = msg;}
	public String getMsg() { return msg; }
	public void setMsg(String msg) { this.msg = msg; }
	
	// 선언만 되고, 구현부를 위한 블록이 존재하지 않는다. 
	public abstract void sayHello();
	
}







