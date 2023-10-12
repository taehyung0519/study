package com.codingbox.MyLogin.domain.member;

import lombok.Data;

@Data
public class Member {
	
	private Long id;
	private String loginId;		// 로그인 id
	private String name;		// 사용자 이름
	private String password;	// 사용자 pw
	
	
}
