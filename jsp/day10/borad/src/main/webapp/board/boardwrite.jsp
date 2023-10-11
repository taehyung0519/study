<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin:0 auto;
		width:900px;
	}
</style>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/board/BoardWriteOK.bo"
			method="post" name="boardForm" >
			<table style="width: 900px; border: 0px;">
				<tr align="center" valign="middle">
					<td><h3>MVC 게시판</h3></td>
				</tr>
			</table>
			<table border="1" style="border-collapse:collapse;">
				<tr height="30px">
					<th align="center" width="150px">
						제 목
					</th>
					<td>
						<input name="boardtitle" size="50" maxlength="100" value="" placeholder="제목을 입력하세요">
					</td>
				</tr>
				<tr height="30px">
					<th align="center" width="150px">
						글쓴이
					</th>
					<td>
						<input name="username" size="10" maxlength="20" value="" placeholder="이름을 입력하세요">
					</td>
				</tr>
				<tr height="300px">
					<th align="center" width="150px">
						내 용
					</th>
					<td>
						<textarea name="boardcontent" style="width:700px;height:250px;"></textarea>					
					</td>
				</tr>
			</table>
			<table style="border: 0px;">
				<tr align="right" valign="middle">
					<td>
						<a href="javascript:document.boardForm.submit();">[등록]</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/board/BoardList.bo">
							[목록]
						</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>














