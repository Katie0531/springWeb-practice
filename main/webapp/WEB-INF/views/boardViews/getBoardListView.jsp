<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 전체 회원 데이터 보기 (getBoardListView.jsp)</h2>
	<hr>
	<a href="insertBoard.do"> 회원가입 하기 </a>
	<br><br>
	<a href="loginBoard.do"> 로그인 하기 </a> 
	<br><hr>
	<table border="1px solid gray" style="border-collapse:collapse;">
		<tr align="center" height="50">
			<td width="200"> 번호 </td>
			<td width="200"> id </td>
			<td width="200"> password </td>
		</tr>
		<!-- jstl을 이용하여 데이터 출력 -->
		<c:forEach items="${bList}" var="login">
			<tr align="center" height="50">
				<td width="200"> ${login.seq} </td>
				<td width="200"> 
					<a href="getBoard.do?seq=${login.seq}">${login.id}</a> 
				</td>
				<td width="200"> ${login.password} </td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>