package Extends;

public class Main02 {

	public static void main(String[] args) {
		FileArticle fileArticle = new FileArticle();
		fileArticle.setNum(1);
		fileArticle.setTitle("첫 번째 자료입니다.");
		fileArticle.setFileName("java.ppt");
		System.out.println(fileArticle.toString());
		
		System.out.println("----------------");
		
		QNAArticle qnaArticle = new QNAArticle();
		qnaArticle.setNum(1);
		qnaArticle.setTitle("첫 번째 질문입니다.");
		qnaArticle.setAnswer("첫 번째 답변입니다.");
		System.out.println(qnaArticle.toString());
		
	}

}








