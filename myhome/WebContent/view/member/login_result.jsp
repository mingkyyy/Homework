
<%@page import="myhome.domain.MemberDto"%>
<%@page import="myhome.domain.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	MemberDao dao=MemberDao.getInstance();
	MemberDto dto=dao.findByUsernameAndPassword(username, password);
	
	
	String message = dto != null ? dto.getNickname() + "님, 안녕하세요."	: "로그인 실패!";
	
	if(dto != null){
		// http://127.0.0.1:8080/myhome
		response.sendRedirect("/myhome"); 
		return; // 해당 페이지의 service()는 종료
	}
	// 로그인 성공하면 index 페이지로 이동
	// 로그인 실패하면 로그인 실패! 를 alert() 하고, 
	// 로그인 페이지로 이동
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		
		location.href='/myhome/view/member/login.jsp'; 
	</script>
	
</body>
</html>
