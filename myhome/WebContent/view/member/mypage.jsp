
<%@page import="myhome.domain.MemberDto"%>
<%@page import="myhome.domain.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
MemberDao dao = MemberDao.getInstance();
MemberDto dto = dao.findByUsernameAndPassword(username, password);
boolean result = dto != null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(result){ %>
		<a href="/myhome/view/member/delete.jsp?no=<%=dto.getNo() %>">회원탈퇴</a>
	<% } else { %>
		<h2>아이디, 비밀번호를 다시 확인해주세요.</h2>
	<% } %>
</body>
</html>
