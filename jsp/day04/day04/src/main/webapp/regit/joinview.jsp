<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 폼</h3>
	<form action="join.jsp" method="post" id="joinForm">
		아이디 	<input type="text" name="userid" id="userid" /><br/>
		비밀번호 	<input type="password" name="userpw" id="userpw" /><br/>
		이름 		<input type="text" name="username" id="username" /><br/>
		핸드폰 번호 <input type="text" name="userphone" id="userphone"/><br/>
		<br/>
		<input type="button" value="회원가입" onclick="sendit()"/> 
	</form>
	
	<script>
		function sendit(){
			let frm = document.getElementById("joinForm");
			let idTag = frm.userid;
			let pwTag = frm.userpw;
			let nameTag = document.getElementById("username");
			let phoneTag = document.getElementById("userphone");
			
			// 아이디의 "" 체크, "아이디를 입력하세요"
			if( idTag.value == "" ){
				alert("아이디를 입력하세요!");
				idTag.focus();
				return false;
			}
			
			// pw의 "" 체크, ...
			if( pwTag.value == "" ){
				alert("패스워드를 입력하세요!");
				pwTag.focus();
				return false;
			}
			
			// pw의 length 체크, 8자리 이상입력
			if( pwTag.value.length < 8 ){
				alert("패스워드는 8자리 이상으로 입력하세요!");
				pwTag.focus();
				return false;
			}
			
			// 이름의 "" 체크, ...
			if( nameTag.value == "" ){
				alert("이름을 입력하세요!");
				nameTag.focus();
				return false;
			}
			
			// 전화번호 "" 체크, ...
			if( phoneTag.value == "" ){
				alert("전화번호를 입력하세요!");
				phoneTag.focus();
				return false;
			}
			
			// 서버 전송		
			frm.submit();
		}
	</script>
</body>
</html>














