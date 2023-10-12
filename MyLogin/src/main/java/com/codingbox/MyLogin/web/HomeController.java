package com.codingbox.MyLogin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.codingbox.MyLogin.domain.member.Member;
import com.codingbox.MyLogin.domain.member.MemberRepository;
import com.codingbox.MyLogin.web.session.SessionConst;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final MemberRepository memberRepository;
	// welcome page 재 정의
	// home.html로 가게 정의
	// home()
	
//	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// 로그인 성공 여부를 cookie가 구별해줌
	/*
	 * memberId			-> 쿠키의 key 값으로 get
	 * required = false	-> 로그인 안한 사용자도 접속 가능 
	 */
	//@GetMapping("/")
	public String homeLogin(@CookieValue(name="memberId", required = false) Long memberId, Model model) {
		// 로그인 하지않은 사용자라면 home으로 보낸다.
		if(memberId == null) {
			return "home";
		}
		
		//db 조회한 후, 사용자가 없으면 다시 null 처리, home으로 return
		Member loginMember = memberRepository.findById(memberId);
		if(loginMember == null) {
			return "home";
		}
		
		// 로그인 성공한 사용자라면 loginHome으로 이동
		model.addAttribute("member", loginMember);
		return "loginHome";
	}
	
	//@GetMapping("/")
	public String homeLoginV2(HttpServletRequest req,Model model) {
		// 로그인 하지않은 사용자라면 home으로 보낸다.
		
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			return "home";
		}
		
		Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
		// 세션에 회원 데이터가 없으면 home
		if(loginMember == null) {
			return "home";
		}
		
		//db 조회한 후, 사용자가 없으면 다시 null 처리, home으로 return 
		Member dbMember = memberRepository.findById(loginMember.getId()); 
		if(dbMember == null) { 
			return "home"; 
		}
		
		// 로그인 성공한 사용자라면 loginHome으로 이동
		model.addAttribute("member", loginMember);
		return "loginHome";
	}
	
	// @SessionAttribute: session 객체를 name속성값을 기준으로 찾는다.
	// required = false : session 값이 없을 수도 있다.
	@GetMapping("/")
	public String homeLoginV3(@SessionAttribute(name=SessionConst.LOGIN_MEMBER, required = false)Member loginMember,Model model) {
		// 세션에 회원 데이터가 없으면 home으로
		if(loginMember == null) {
			return "home";
		}
		
		// 로그인 성공한 사용자라면 loginHome으로 이동
		model.addAttribute("member", loginMember);
		return "loginHome";
	}
}
