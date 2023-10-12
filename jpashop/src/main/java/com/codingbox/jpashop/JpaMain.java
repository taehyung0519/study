package com.codingbox.jpashop;

import java.util.List;

import com.codingbox.jpashop.relation.Member;
import com.codingbox.jpashop.relation.Team;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		
		Team team = new Team();
		team.setName("TeamA");
		
		em.persist(team);
		
		Member member = new Member();
		member.setUsername("member1");
		//member.setTeamid(team.getId());
		//member.setTeam(team);
		em.persist(member);
		
		// select
		// 어떤 멤버가 어느팀 소속인지 알고 싶을때
//		Member findMember = em.find(Member.class, member.getId());
//		Long findTeamId = findMember.getTeamid();
//		Team findTeam =  em.find(Team.class, findTeamId);
//		System.out.println("findTeam : " + findTeam.getName());
		
		// 강제로 DB 쿼리를 보고 싶을때
		em.flush();
		em.clear();
		
		Member findMember = em.find(Member.class, member.getId());
		Team findTeam = findMember.getTeam();
		System.out.println("findTeam : " + findTeam.getName());
		
		// 양방향 매핑
		Member findSideMember = em.find(Member.class, member.getId());
		List<Member> members = findSideMember.getTeam().getMember();
		
		for(Member m : members) {
			System.out.println("result = " + m.getUsername());
		}
		
		tx.commit();
		em.close();
		emf.close();
	}
}
