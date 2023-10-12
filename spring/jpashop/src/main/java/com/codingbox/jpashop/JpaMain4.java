package com.codingbox.jpashop;

import java.time.LocalDateTime;

import com.codingbox.jpashop.embed.Address;
import com.codingbox.jpashop.embed.Member;
import com.codingbox.jpashop.embed.Period;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		
		Member member = new Member();
		member.setUsername("user1");
		member.setAddress(new Address("서울", "강남", "333"));
		member.setPeriod(new Period(LocalDateTime.now(),LocalDateTime.now()));
		em.persist(member);
		
		tx.commit();
		em.close();
		emf.close();
	}
}
