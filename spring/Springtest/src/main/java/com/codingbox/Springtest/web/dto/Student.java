package com.codingbox.Springtest.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student {
	private Long id;
	private String studentName;
	private Integer age;
	private Integer subject;
	private String phone;
	private String addr;
	
	public Student() {
		super();
	}

}
