package com.codingbox.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class B extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt( req.getParameter("data1") );
		int num2 = Integer.parseInt( req.getParameter("data2") );
		double result = 0.0;
		if( num2 == 0 ) {
			req.setAttribute("result", "0으로 나눌수는 없습니다. ");
		} else {
			result = (double)num1/num2;
			req.setAttribute("result", result);
		}
		req.getRequestDispatcher("c.jsp").forward(req, resp);
	}
}











