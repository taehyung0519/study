package com.codingbox.MyLogin.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	// db가 없어서 임의로 만드는 저장로직(db 대체)
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	// id값에 시퀀스 값을 넣음
	
	public Member findById(Long id) {
		return store.get(id);
	}
	// id값을 찾아옴
	
	public Member findByLoginId(String loginId) {
		List<Member> all = findAll();
		
		for(Member m : all) {
			if(m.getLoginId().equals(loginId)) {
				return m;
			}
		}
		
		return null;
		// 조건에 없는 사람은 null값을 줌
	}
	
	private List<Member> findAll() {
		
		return new ArrayList<>(store.values());
	}
}
