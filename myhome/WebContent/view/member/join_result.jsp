<%@page import="myhome.domain.MemberDao"%>
<%@page import="myhome.domain.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//POST 로 넘어온 파라미터는 반드시 문자 인코딩 해줘야 한다..(UTF-8로)
	request.setCharacterEncoding("UTF-8");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String nickname=request.getParameter("nickname");
	int type=Integer.parseInt(request.getParameter("type"));
	
	MemberDto dto=new MemberDto();
	dto.setUsername(username);
	dto.setPassword(password);
	dto.setNickname(nickname);
	dto.setType(type);
	
	MemberDao dao=MemberDao.getInstance();
	boolean result=dao.insert(dto);
	String message=
			result? "회원가입에 감사드립니다." : "회원가입에 실패했습니다.";
	
%>   
    <h1> <%=message %></h1>
    <% if(result){ %>
    
    <button onclick="location.href='login.jsp'">로그인 하러 가기</button>
    <%}else{ %>
    <button onclick="history.back()">뒤로가기</button>
    <% } %>