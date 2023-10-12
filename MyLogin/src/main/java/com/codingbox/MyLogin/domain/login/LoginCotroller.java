package com.codingbox.MyLogin.domain.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbox.MyLogin.domain.member.Member;
import com.codingbox.MyLogin.domain.member.MemberRepository;
import com.codingbox.MyLogin.web.session.SessionConst;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginCotroller {
	@GetMapping("/login")
	public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
		
		return "login/loginForm";
	}
	
	private final LoginService loginService;
	private final MemberRepository memberRepository;
	
	//@PostMapping("/login")
	public String login(@ModelAttribute LoginForm form, Model model, RedirectAttributes redirectAttrs,
							HttpServletResponse response) {
		/*
		 * login 가능한 사람인지 체크 -> loginService
		 * 로그인 실패 -> login/loginForm
		 * 로그인 성공 -> /
		 */
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		
		if(loginMember == null) {
			// 로그인 실패 시
			model.addAttribute("msg", "로그인실패");
			return "login/loginForm";
		} else {
			// 로그인 성공 시
			Cookie idcookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
			response.addCookie(idcookie); // 서버가 클라이언트에 보낸 답변
			
			redirectAttrs.addFlashAttribute("msg", "로그인성공");
			return "redirect:/"; //
		}
		
	}
	
	//@PostMapping("/login")
	public String loginV2(@ModelAttribute LoginForm form, Model model, RedirectAttributes redirectAttrs,
							HttpServletRequest request) {
		/*
		 * login 가능한 사람인지 체크 -> loginService
		 * 로그인 실패 -> login/loginForm
		 * 로그인 성공 -> /
		 */
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		
		if(loginMember == null) {
			// 로그인 실패 시
			model.addAttribute("msg", "로그인실패");
			return "login/loginForm";
		} else {
			// 로그인 성공 시
			// 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
			HttpSession session = request.getSession();
			// 세션에 로그인 회원 정보 보관
			session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
			redirectAttrs.addFlashAttribute("msg", "로그인성공");
			return "redirect:/";
		}
		
	}
	
	@PostMapping("/login")
	public String loginV3(@ModelAttribute LoginForm form, Model model, RedirectAttributes redirectAttrs,
							HttpServletRequest request, @RequestParam(defaultValue = "/")String redirectURL) {
		/*
		 * login 가능한 사람인지 체크 -> loginService
		 * 로그인 실패 -> login/loginForm
		 * 로그인 성공 -> /
		 */
		Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
		
		if(loginMember == null) {
			// 로그인 실패 시
			model.addAttribute("msg", "로그인실패");
			return "login/loginForm";
		} else {
			// 로그인 성공 시
			// 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
			HttpSession session = request.getSession();
			// 세션에 로그인 회원 정보 보관
			session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
			redirectAttrs.addFlashAttribute("msg", "로그인성공");
			return "redirect:" + redirectURL;
		}
		
	}
	
	//@PostMapping("/logout")
	public String logout(HttpServletResponse response) {
		// 쿠키 만료
		expireCookie(response,"memberId");
		return "redirect:/";
	}
	
	@PostMapping("/logout")
	public String logoutV2(HttpServletRequest request) {
		// 세션 삭제
		HttpSession session = request.getSession(false); 
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	private void expireCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName,null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
}
