package com.codingbox.core2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingbox.core2.dto.Member;
import com.codingbox.core2.repository.MemberRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class MemberService {
	// MemoryMemberRepository mRepository = new MemoryMemberRepository();
	private final MemberRepository mRepository;
	
	@Autowired
	public MemberService(MemberRepository mRepository){
		this.mRepository = mRepository;
		
	}
	
	public int join(Member member) {
		mRepository.save(member);
		return member.getId();
	}
	
	public List<Member> findMembers(){
		return mRepository.findAll();
	}
}
