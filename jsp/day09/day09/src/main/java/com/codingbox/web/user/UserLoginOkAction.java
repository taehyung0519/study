package com.codingbox.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.web.user.action.Action;
import com.codingbox.web.user.action.ActionForward;
import com.codingbox.web.user.dao.UserDAO;

public class UserLoginOkAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("excute 도착");
		ActionForward forward = new ActionForward();
		UserDAO udao = new UserDAO();
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		if(udao.login(userid, userpw)) {
			// 로그인 성공
			forward.setPath("/main/mainview.jsp");
		} else {
			// 로그인 실패
			forward.setPath("/user/loginview.jsp");
		}
		forward.setRedirect(true);
		return forward;
	}

}









