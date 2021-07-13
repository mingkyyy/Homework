<%@page import="myhome.domain.MemberDto"%>
<%@page import="myhome.domain.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("currentDto") != null){ %>
		<a href="/myhome/view/member/delete?no=<%=((MemberDto)session.getAttribute("currentDto")).getNo() %>">회원탈퇴</a>
	<% } else { %>
		<h2>로그인을 하셔야 합니다.</h2>
	<% } %>
</body>
</html>



