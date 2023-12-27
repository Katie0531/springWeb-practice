<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 로그인 정보 </h2>
	<hr>
	<table border="1px solid gray" style="border-collapse:collapse;">
		<tr align="center" height="50">
			<td width="200"> 번호 </td>
			<td width="200"> ${login.seq} </td>
		</tr>
		<tr align="center" height="50">
			<td width="200"> id </td>
			<td width="200"> ${login.id} </td>
		</tr>
		<tr align="center" height="50">
			<td width="200"> password </td>
			<td width="200"> ${login.password} </td>
		</tr>
		<tr align="center" height="50">
			<td colspan="1">
			<input type="button" value="목록보기"
			onclick="location.href='getBoardList.do'">
		</tr>


	</table>
</body>
</html>