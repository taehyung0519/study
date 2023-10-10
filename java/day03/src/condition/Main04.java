package condition;

public class Main04 {

	public static void main(String[] args) {
		// ---------------------if----------------------------
		/*
		 * 1. 만약 3000원 이상의 돈을 가지고 있으면 택시를 타고,
		 * 그렇지 않으면 걸어가라
		 */
		int money = 3000;
		if( money >= 3000 ) {
			System.out.println("택시를 타고 가라");
		} else {
			System.out.println("걸어가라");
		}
		System.out.println("----------------------");		
		
		/*
		 * 2. 만약 돈이 3000원 이상 있거나, 카드가 있으면 택시를 타고,
		 * 그렇지 않으면 걸어가라
		 */
		int money2 = 2000;
		boolean hasCard = true;
		
		if( money2 >= 3000 || hasCard ) {
			System.out.println("택시를 타고 가라");
		} else {
			System.out.println("걸어가라");
		}
		System.out.println("-------------------------");
		
		/*
		 * 3.어떤 특정 정수값 a가 짝수이면 "짝수", 홀수이면 "홀수"
		 */
		int a = 11;
		if( a%2 == 0 ) {	// 짝수
			System.out.println("짝수");
		} else {			// 홀수
			System.out.println("홀수");
		}
		System.out.println("------------------------------");
		
		/*
		 * 4. 서로다른 특정 정수값 a1,b1,c1 의 최대값을 구하여라
		 * a1 = 10, b1 = 20, c1 = 9
		 */
		int a1 = 30, b1 = 20, c1 = 90;
		int max = 0;
		
		if( a1 > b1 && a1 > c1 ) {
			max = a1;
		} else {
			if( b1 > c1 ) {
				max = b1;
			} else {
				max = c1;
			}
		}
		
		System.out.println("최대값은 : " + max);
		System.out.println("----------------------------");
		
		/*
		 * 5. 국어, 영어, 수학 점수의 평균이 95점 이상이면 장학생 출력.
		 * 국어 점수가 70점 이상이면 "합격", 그렇지 않으면 "불합격"처리 하라
		 */
		int kor = 100;
		int eng = 90;
		int mat = 100;
		
		int avg = (kor + eng + mat)/3;
		System.out.println("평균 : " + avg);
		
		if( avg >= 95 ) {
			System.out.println("장학생");
		}
		
		if( kor >= 70 ){
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		System.out.println("--------------------");
		
		/*
		 * 6. 수학점수가 90점 이상이면 "A학점", 80점 이상이면 "B학점",
		 * 70점 이상이면 "C학점", 60점 이상이면 "D학점", 나머지는 "F학점"을 출력
		 */
		int mat2 = 95;
		if( mat2 >= 90 ) {
			System.out.println("A");
		} else if( mat2 >= 80 ) {
			System.out.println("B");
		} else if ( mat2 >= 70 ) {
			System.out.println("C");
		} else if ( mat2 >= 60 ) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		System.out.println("---------------------------");

		
		// ------------------- switch ------------------------
		/*
		 * 7. 1은 "축구", 2은 "농구", 3은 "야구", 4는 "배구", 
		 * 그 외에는 "배드민턴"이 출력되도록 프로그램을 만드시오
		 */
		int num = 3;
		
		switch( num ) {
			case 1:
				System.out.println("축구");
				break;
			case 2:
				System.out.println("농구");
				break;
			case 3:
				System.out.println("야구");
				break;
			case 4:
				System.out.println("배구");
				break;
			default:
				System.out.println("배드민턴");
				break;
		}
		System.out.println("------------------------");
		
		
		/*
		 * 8. 숫자가 3이면 "안녕"이 세줄, 2이면 "안녕"이 두 줄,
		 * 1이면 "안녕"이 한줄, 그 외에는 "잘가"가 출력되도록 하시오.
		 */
		int num2 = 2;
		switch(num2) {
			case 3:
				System.out.println("안녕");
			case 2:
				System.out.println("안녕");
			case 1:
				System.out.println("안녕");
				break;
			default:
				System.out.println("잘가");
		}
		
	}

}









