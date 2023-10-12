package com.codingbox.core3.basic.thymeleaf;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingbox.core3.basic.User;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/basic")
public class BasicController {
	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data","Hello Spring!");
		//model.addAttribute("data","Hello Spring!");
		return "basic/text-basic";
	}
	
	@GetMapping("/text-unescaped")
	public String textUnescaped(Model model) {
		model.addAttribute("data","<b>Hello Spring!</b>");
		return "basic/text-unescaped";
	}
	
	@GetMapping("/variable")
	public String variable(Model model) {
		User userA = new User("UserA",10);
		User userB = new User("UserB",20);
		
		List<User> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);
		
		Map<String, User> map = new HashMap<String, User>();
		map.put("userA", userA);
		map.put("userB", userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);
		
		
		return "basic/variable";
	}
	
	@GetMapping("/basic-objects")
	public String basicObjects(HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) {
		session.setAttribute("sessionData", "session!!");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		model.addAttribute("servletContext", request.getServletContext());
		return "basic/basic-objects";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "basic/date";
	}
	
	@GetMapping("/link")
	public String link(Model model) {
		model.addAttribute("param1","date1");
		model.addAttribute("param2","date2");
		return "basic/link";
	}
	
	@GetMapping("/literal")
	public String literal(Model model) {
		model.addAttribute("data","spring");
		return "basic/literal";
	}
	
	@GetMapping("/operation")
	public String operation(Model model) {
		model.addAttribute("nullData",null);
		model.addAttribute("data","spring");
		return "basic/operation";
	}
	
	@GetMapping("/attribute")
	public String attribute() {
		return "basic/attribute";
	}
	
	@GetMapping("/each")
	public String each(Model model) {
		addUsers(model);
		
		return "basic/each";
	}
	
	@GetMapping("/condition")
	public String condition(Model model) {
		addUsers(model);
		return "basic/condition";
	}
	
	@GetMapping("/comments")
	public String comments(Model model) {
		model.addAttribute("data","spring");
		return "basic/comments";
	}
	
	@GetMapping("/block")
	public String block(Model model) {
		addUsers(model);
		return "basic/block";
	}
	
	@GetMapping("/javascript")
	public String javascript(Model model) {
		model.addAttribute("user",new User("user1",10));
		addUsers(model);
		return "basic/javascript";
	}
	
	
	
	public void addUsers(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User("userA",10));
		list.add(new User("userB",20));
		list.add(new User("userC",30));
		model.addAttribute("users",list);
	}
	
	
}
