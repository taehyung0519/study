package hiding;

public class Main01 {

	public static void main(String[] args) {
		Article a1 = new Article(1, "테스트 게시물", 
			"javaBeans를 활용", "자바학생", 123, "2023-07-10");
		
		System.out.println(a1.getSeq());
		System.out.println(a1.getSubject());
		System.out.println(a1.getContent());
		System.out.println(a1.getWriter());
		System.out.println(a1.getHit());
		System.out.println(a1.getRegDate());
		
	}

}


