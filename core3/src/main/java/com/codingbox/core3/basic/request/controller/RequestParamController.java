package com.codingbox.core3.basic.request.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codingbox.core3.basic.HelloData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RequestParamController {
	// 반환 타입이 없으면서 이렇게 응답에 값을 직접 넣으면, view 조회 
	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("username :" + username);
		System.out.println("age:" + age);
		response.getWriter().write("ok");
				
	}

	/*
	 * @ResponseBody - view 조회를 무시하고, Http message body에 직접 해당 내용 입력
	 * @RequestParam("username") = request.getparameter("username")
	 */
	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(
			@RequestParam("username") String memberName,
			@RequestParam("age") int memberAge){
		System.out.println("username : " +  memberName);
		System.out.println("age : " +  memberAge);
		return "name:"+memberName+" age:"+memberAge;
				
	}
	
	/*
	 * @RequestParam - Http파라미터 이름이 변수 이름과 같으면
	 *  @RequestParam(name="XXX") 생략 가능.
	 */
	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParamV3(
			@RequestParam String username,
			@RequestParam int age){
		System.out.println("username : " +  username);
		System.out.println("age : " +  age);
		return "name:"+username+" age:"+age;
				
	}
	
	/*
	 * @RequestParam - String, int 등의 단순 타입이면 @RequestParam 생략 가능.
	 * @RequestParam 어노테이션을 생략하면 스프링 MVC는 내부에서 required=false를 적용한다.
	 * @RequestParam이 있으면 명확하게 요청 파라미터에서 데이터를 읽는다는 것을 알 수 있다.
	 */
	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(
			 String username,
			 int age){
		System.out.println("username : " +  username);
		System.out.println("age : " +  age);
		return "name:"+username+" age:"+age;
				
	}
	
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(
			 @RequestParam(required=true, defaultValue = "guest") String username,
			 @RequestParam(required=false, defaultValue = "-1") Integer age){
		System.out.println("username : " +  username);
		System.out.println("age : " +  age);
		return "name:"+username+" age:"+age;
				
	}
	
	@ResponseBody
	@RequestMapping("/request-param-map")
	// 파라미터를 Map으로 조회
	public String requestParamMap(
			 @RequestParam Map<String, Object> paramMap){
		System.out.println("username : " +  paramMap.get("username"));
		System.out.println("age : " +  paramMap.get("age"));
		return "name:"+paramMap.get("username")+" age:"+paramMap.get("age");			
	}
	
	@ResponseBody
	@RequestMapping("/request-attribute-v1")
	public String requestAttributeV1(
			@RequestParam String username,
			@RequestParam int age){
		HelloData helloData = new HelloData();
		helloData.setUsername(username);
		helloData.setAge(age);
		
		System.out.println("username : " +  helloData.getUsername());
		System.out.println("age : " +  helloData.getAge());
		return "name:"+helloData.getUsername()+" age:"+helloData.getAge();		
	}
	
	
	/*
	 * @ModelAttribute
	 * - mdel.addAttribute(helloData) 코드도 함께 자동적용.
	 * - 요청 파라미터의 이름으로 HelloData 객체의 프로퍼리틀 찾는다.
	 * - 그리고 해당 프로퍼티의 setter를 호출해서 파라미터 값을 입력(바인딩) 한다.
	 * - name -> setname()
	 */
	@ResponseBody
	@RequestMapping("/request-attribute-v2")
	public String requestAttributeV2(
			@ModelAttribute HelloData helloData) {
		
		System.out.println("username : " +  helloData.getUsername());
		System.out.println("age : " +  helloData.getAge());
		System.out.println("helloData : " +  helloData.toString());
		
		return "name:"+helloData.getUsername()+" age:"+helloData.getAge();		
	}
	
	
	/*
	 * @ModelAttribute의 생략가능
	 * - String, int 같은 단순 타입 = @RequestParam 생략
	 * - 객체로 파라미터가 넘어왔을때 = @ModelAttribute 생략
	 */
	@ResponseBody
	@RequestMapping("/request-attribute-v3")
	public String requestAttributeV3(HelloData helloData) {
		System.out.println("username : " +  helloData.getUsername());
		System.out.println("age : " +  helloData.getAge());
		System.out.println("helloData : " +  helloData.toString());
		
		return "name:"+helloData.getUsername()+" age:"+helloData.getAge();		
	}
}
