package com.codingbox.MyLogin.domain.login;

import org.springframework.stereotype.Service;

import com.codingbox.MyLogin.domain.member.Member;
import com.codingbox.MyLogin.domain.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final MemberRepository memberRepository;
	
	public Member login(String loginId, String password) {
		Member member = memberRepository.findByLoginId(loginId);
		
		if(member != null && member.getLoginId().equals(loginId) && member.getPassword().equals(password)) {
			return member;
		} else {
			return null;
		}
	}
}
