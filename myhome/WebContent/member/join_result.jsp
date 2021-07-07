<%@page import="myhome.domain.MemberDao"%>
<%@page import="myhome.domain.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");

	String id=request.getParameter("user_id");
	String pass=request.getParameter("user_password");
	String nick=request.getParameter("user_nickname");
	String type=request.getParameter("type");
	int type2=1;
	if(type.equals("관리자")){
		type2=0;
	}else{
		type2=1;
	}
	MemberDao dao=MemberDao.getInstance();
	MemberDto dto = new MemberDto();
	
	dto.setUsername(id);
	dto.setPassword(pass);
	dto.setNickname(nick);
	dto.setType(type2);
	boolean result;
	if(dao.insert(dto)==true){
		result =true;
		
	}else
		result=false;
%>
	<%if(result==true)  %>회원가입에 감사드립니다 <br/> <button onclick="document.href='login.jsp'" >로그인하러가기</button>
 	<%if(result==false) %>회원가입에 실패하였습니다. <br/>  <button onclick="history.back()" >뒤로가기</button>


</body>
</html>