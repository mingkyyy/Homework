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
	<%-- <script>
		alert("<%= request.getAttribute("msg") %>");
		location.href='/myhome/view/member/login.jsp'; 
	</script> --%>
	
	<h1><%= request.getAttribute("msg") %></h1>
	
	
</body>
</html>
