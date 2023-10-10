package exception;

public class Main03 {

	public static void main(String[] args) {
		
		try {
			String year2 = "자바학생";
			int age2 = 2023 - Integer.parseInt(year2);
			System.out.println(age2);
		} catch (NumberFormatException e) {
			System.out.println("에러가 발생했습니다.");
			System.out.println("원인 : " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("--------프로그램 종료------------");
		
	}

}













