package collection;

import java.util.ArrayList;
import java.util.List;

public class Main03 {

	public static void main(String[] args) {
		// People 객체를 담기 위한 ArrayList 객체 생성
		List<People> plist = new ArrayList<People>();
		
		// 10명의 데이터를 임의로 추가
//		plist.add(new People("회원1", "010-1234-5670"));
//		plist.add(new People("회원2", "010-1234-5671"));
//		plist.add(new People("회원3", "010-1234-5672"));
//		plist.add(new People("회원4", "010-1234-5673"));
//		plist.add(new People("회원5", "010-1234-5674"));
//		plist.add(new People("회원6", "010-1234-5675"));
		
		for( int i=0; i<10; i++ ) {
			People p = new People("회원" + i, "010-1234-567"+i);
			plist.add(p);
		}
		
		// 출력
//		People item0 = plist.get(0);
//		People item1 = plist.get(1);
//		People item2 = plist.get(2);
//		People item3 = plist.get(3);
		
		for( int i=0; i<plist.size(); i++ ) {
			People item = plist.get(i);
			System.out.println(item.toString());
		}
	}
}








