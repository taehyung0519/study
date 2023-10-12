package com.codingbox.jpashop.relation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Member {
	@Id
	@GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	private String username;
	
//	@Column(name="TEAM_ID")
//	private Long teamid;
	
	
	/*
	 * 1대다의 개념을 객체에게 알려야 하는데, DB기준으로 1대단의 개념을 알려줘야 한다.
	 * @ManyToOne  : 여기선 Team이 하나이다.
	 */
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	@Setter(value = AccessLevel.NONE)  // team에 대해서는 setter 자동생성을 하지 않는다.
	private Team team;
	
	// 일반적인 setter의 형태가 아니면 메서드 이름을 바꿔준다.
	// 추후 코드를 봤을때 단순 setter 작업이 아닌 중요한 작업을 진행하는지를 파악할 수 있다.
	public void changeTeam(Team team) {
		this.team = team;
		team.getMember().add(this);
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
