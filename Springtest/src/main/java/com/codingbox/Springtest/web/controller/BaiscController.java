package com.codingbox.Springtest.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingbox.Springtest.web.dto.Student;
import com.codingbox.Springtest.web.repository.StudentRepository;
import com.codingbox.item.domain.web.dto.Item;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/students")
@RequiredArgsConstructor
public class BaiscController {
	
	private final StudentRepository studentRepository;
	
	
	@GetMapping
	public String students(Model model) {
		List<Student> students = studentRepository.findAll();
		model.addAttribute("students", students);
		return "basic/students";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("student", new Student());
		return "basic/studentAddForm";
	}
	
	@PostMapping("/add")
	public String saveItemV9(Student student, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if( !StringUtils.hasText(student.getStudentName()) ) {
			bindingResult.addError( 
				new FieldError("student", "studentName", student.getStudentName(),
					false, new String[]{"required.student.studentName"}, null, null) );
		}
		
		if( student.getAge() == null || 
			student.getAge() < 15 || 
			student.getAge() > 60 ) {
			bindingResult.addError(
				new FieldError("student", "age", student.getAge(),
					false, new String[] {"range.student.age"}, new Integer[] {15,60}, null));
		}
		
		if( student.getSubject() == null || 
			student.getAge() > 10) {
			bindingResult.addError(
				new FieldError("student", "subject", student.getSubject(),
					false, new String[] {"max.student.subject"}, new Integer[] {10}, null));
			}
		
		if( student.getPhone().contains("010") ) {
			bindingResult.addError( 
				new FieldError("student", "phone", student.getPhone(),
					false, new String[]{"required.student.phone"}, null, null) );
		}
		
		if( !StringUtils.hasText(student.getAddr()) ) {
			bindingResult.addError( 
				new FieldError("student", "addr", student.getAddr(),
					false, new String[]{"required.student.addr"}, null, null) );
		}

		// 검증에 실패한다면 다시 입력 폼
		if( bindingResult.hasErrors() ) {
			System.out.println("errors : " + bindingResult);
			return "basic/studentAddForm";
		}
		
		Student savedStd = studentRepository.save(student);
		redirectAttributes.addAttribute("status", true);
		return "redirect:/basic/students/" + student.getId();
	}
	
}
