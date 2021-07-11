<%@page import="java.util.List"%>
<%@page import="myhome.domain.MemberDto"%>
<%@page import="myhome.domain.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   
 <%
 	MemberDao dao = MemberDao.getInstance();
 	List<MemberDto> list = dao.selectAll();
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<td>회원번호</td>
		<td>회원아이디</td>
		<td>가입날짜</td>
		<td>회원유형</td>
		<td>회원탈퇴</td>
	</tr>
	
	<tr>
	<%  for(MemberDto dto : list){%>
		<td><%=dto.getNo() %></td>
		<td><%=dto.getUsername() %></td>
		<td><%=dto.getRegdate() %></td>
		<td><%=dto.getType() %></td>
		<%if(dto.getType()==1){ %>
		<td><a href="/myhome/view/member/manage_delete.jsp?no=<%=dto.getNo() %>">강퇴</a></td>
		<% } %>
	</tr>
	<% } %>
	

</table>
</body>
</html>