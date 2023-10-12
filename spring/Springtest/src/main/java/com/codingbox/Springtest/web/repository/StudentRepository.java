package com.codingbox.Springtest.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingbox.Springtest.web.dto.Student;


@Repository
public class StudentRepository {
	private static final Map<Long, Student> store = new HashMap<>();
	private static long sequence = 0L;
	
	// 저장
	public Student save(Student std) {
		std.setId(++sequence);
		store.put(std.getId(), std);
		return std;
	}
	
	// 학생 하나 검색
	public Student findById(Long id) {
		return store.get(id);
	}
	
	// 전체 항목
	public List<Student> findAll(){
		return new ArrayList<Student>(store.values());
	}
	
	// 학생 수정
	public void update(Long stdId, Student updatParam) {
		// 학생 먼저 찾는다
		Student findStd = findById(stdId);
		findStd.setStudentName(updatParam.getStudentName());
		findStd.setAge(updatParam.getAge());
		findStd.setSubject(updatParam.getSubject());
		findStd.setPhone(updatParam.getPhone());
		findStd.setAddr(updatParam.getAddr());
		
	}
	
	// store clear
	public void clearStore() {
		store.clear();
	}

}
