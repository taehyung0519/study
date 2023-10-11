<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		session 값을 비워
		login page로 이동 -> loginview.jsp
	 -->
	 <%
	 	//session.invalidate();	// session에 있는 모든 값 삭제
	 	session.removeAttribute("session_id");	// session에 정의된 특정 값만 삭제
	 	response.sendRedirect("loginview.jsp");
	 %>
	 
	 
</body>
</html>








