<%@page import="myhome.domain.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	MemberDao dao = MemberDao.getInstance();
	boolean result = dao.delete(no);		
			
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%= result ? "삭제 완료!" :"삭제 실패.." %></h2>
</body>
</html>