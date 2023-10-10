package collection;

import java.util.ArrayList;
import java.util.List;

public class Main02 {

	public static void main(String[] args) {
		List<Integer> numberList =  new ArrayList<Integer>();
		
		// 데이터 추가
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);
		numberList.add(40);
		numberList.add(50);
		numberList.add(60);
		numberList.add(70);
		numberList.add(80);
		numberList.add(90);
		
		// 추가된 데이터의 수량
		int count = numberList.size();
		System.out.println("데이터의 크기 : " + count);
		
		// 5번째 요소의 값 얻기
		int value = numberList.get(4);
		System.out.println("5번째 요소의 값 : " + value);
		
		// 5번째 요소를 삭제
		numberList.remove(4);
		
		// 하나를 삭제 후, 전체 크기 다시 조회 
		count = numberList.size();
		System.out.println("데이터 크기 : " + count);
				
		// 5번째 요소의 값을 다시 얻기
		value = numberList.get(4);
		System.out.println("5번째 요소의 값 : " + value);
		
		// 5번째 자리에 데이터 추가
		numberList.add(4,123);
		value = numberList.get(4);
		System.out.println("5번째 요소의값 : " + value);
		
		// 전체삭제
		numberList.clear();
		count = numberList.size();
		System.out.println("데이터 크기 : " + count);
		
	}

}









