package com.codingbox.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingbox.web.dao.UserDAO;
import com.codingbox.web.dto.UserDTO;

@WebServlet("/join")
public class Join extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		String username = req.getParameter("username");
		String userphone = req.getParameter("userphone");
		
		UserDTO dto = new UserDTO();
		dto.setUserid(userid);
		dto.setUsername(username);
		dto.setUserphone(userphone);
		dto.setUserpw(userpw);
		
		UserDAO udao = new UserDAO();
		if( udao.join(dto) ){
			// 회원 가입 성공
		} else {
			// 회원 가입 실패
		}
		
	}
}












