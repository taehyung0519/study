package com.codingbox.querydsl.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {
	
	@Id @GeneratedValue
	@Column(name = "team_id")
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "team")
	private List<Member> members 
		= new ArrayList<>();
	
	public Team(String name) {
		this.name = name;
	}

//	protected Team() {}
//
//	@Override
//	public String toString() {
//		return "Team [id=" + id 
//				+ ", name=" + name + "]";
//	}
	
}

















