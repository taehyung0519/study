package com.codingbox.springprj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.springprj.domain.Member;
import com.codingbox.springprj.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

/*
 * @Transactional
 *  - DB와 관련된, 트랜잭션이 필요한 서비스 클래스 혹은 메서드에 @Transactional 추가
 *  - 일련의 작업들을 묶어서 하나의 단위로 처리할때
 *  - 옵션 : readOnly = true or false
 *  	=> 읽기 전용일때 사용
 *  	=> 비용을 아끼게 된다.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
	
	private final MemberRepository memberRepository;

	@Transactional
	public Long join(Member member) throws IllegalAccessException {
		// 중복회원 검증 로직 추가
		validationMemberCheck(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validationMemberCheck(Member member) 
			throws IllegalAccessException {
		List<Member> findMembers = 
			memberRepository.findByname(member.getName());
		
		if( !findMembers.isEmpty() ) {
			throw new IllegalAccessException("이미 존재하는 회원입니다.");
		}
	}

//	@Transactional(readOnly = true)
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	

}













