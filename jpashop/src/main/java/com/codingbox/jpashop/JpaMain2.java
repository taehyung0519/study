package com.codingbox.jpashop;

import java.util.List;

import com.codingbox.jpashop.relation.Member;
import com.codingbox.jpashop.relation.Team;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		
		// 양방향 매핑시에 가장 많이하는 실수
//		Member member = new Member();
//		member.setUsername("member1");
//		em.persist(member);
//		
//		Team team = new Team();
//		team.setName("TeamA");
//		team.getMember().add(member);  // team은 연관관계의 주인이 아니기 때문에 insert,update 불가.
//		em.persist(team);
		
		// 수정
		Team team = new Team();
		team.setName("TeamB");
		em.persist(team);
		
		Member member = new Member();
		member.setUsername("member2");
		//member.setTeam(team);  // 연관관계의 주인에게 값을 설정 (자식관계에 있는 엔티티가 주인이 된다.)
		//member.changeTeam(team);
		em.persist(member);  
		
		team.addMember(member);
		
		// team.getMember().add(member); // 양쪽에 모두 값을 넣어 줘야한다
		
		// em.flush();
		// em.clear(); // 이 두개 주석 처리시 영속성 컨텍스트에 member가 할당되지 않아서 team을 중심으로 member가 조회 되지 않는다.
		
		System.out.println("=======================================================");
		Team findTeam  = em.find(Team.class, team.getId());
		List<Member> members = findTeam.getMember();
		
		for(Member m : members ) {
			System.out.println("m = " + m.getUsername());
		}
		
		
		System.out.println("=======================================================");
		
		
		tx.commit();
		em.close();
		emf.close();
	}
}
