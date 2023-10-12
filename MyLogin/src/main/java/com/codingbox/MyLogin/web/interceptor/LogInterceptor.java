package com.codingbox.MyLogin.web.interceptor;

import java.util.UUID;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {

	public static final String LOG_ID = "logid";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String requestURI = request.getRequestURI();
		String uuid = UUID.randomUUID().toString();
		
		System.out.println("[interceptor] uuid : " + uuid);
		System.out.println("[interceptor] requestURI : " + requestURI);
		System.out.println("[interceptor] handler : " + handler);
		
		request.setAttribute(LOG_ID,uuid);
		
		return true; // false면 진행 X
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		System.out.println("[interceptor] postHandle : " + modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
		String requestURI = request.getRequestURI();
		String logId = (String)request.getAttribute(LOG_ID);
		
		System.out.println("[interceptor] logId : " + logId);
		System.out.println("[interceptor] requestURI : " + requestURI);
		
		// error가 생성된 경우
		if(ex != null) {
			System.out.println("[interceptor] agerCompletion error!" + ex);
			
		}
	}
}
