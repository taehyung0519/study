package com.codingbox.jpa;

import java.util.List;

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
		
		// jpql
		// jpa는 쿼리를 짤때 table을 대상으로 쿼리를 짜지 않고, 
		// Member 객체를 통새서 쿼리를 짠다고 보면 된다.ㅣ
		List<Member> result = em.createQuery("select m from Member as m",Member.class)
				.setFirstResult(5) // 5번 글부터
				.setMaxResults(10) // 10개 가져와.
				.getResultList();
		
		for(Member member : result) {
			System.out.println("member.name : " + member.getName());
		}
	
		tx.commit();
		em.close();
		emf.close();
	}
}
