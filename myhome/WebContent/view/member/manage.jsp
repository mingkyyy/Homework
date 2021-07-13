<%@page import="myhome.domain.MemberDto"%>
<%@page import="java.util.List"%>
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
   <table border = "1">
      <tr>
         <th>회원번호</th>
         <th>아이디</th>
         <th>등록일자</th>
         <th>닉네임</th>
         <th>유형</th>
      </tr>
      <% for(MemberDto dto : (List<MemberDto>)session.getAttribute("memberList")) {%>
         <tr>
            <td><%=dto.getNo() %></td>
            <td><%=dto.getUsername() %></td>
            <td><%=dto.getRegdate() %></td>
            <td><%=dto.getNickname() %></td>
            <td><%=dto.getType() == 0 ? "관리자" : "일반회원" %>
            <td><a href="/myhome/view/member/manage_delete.jsp?no=<%=dto.getNo() %>">강퇴</a></td>         
         </tr>
      <%} %>
   </table>
</body>
</html>




