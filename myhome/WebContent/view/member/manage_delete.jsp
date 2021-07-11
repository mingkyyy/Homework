<%@page import="myhome.domain.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int no = Integer.parseInt(request.getParameter("no"));
	MemberDao dao = MemberDao.getInstance();
	boolean result = dao.delete(no);
	if(result ==true){
		response.sendRedirect("manage.jsp");
		
	}
			
%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>