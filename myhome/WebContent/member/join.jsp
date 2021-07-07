<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join_result.jsp">
		아이디 : <input type="text" name="user_id"><br/>
		비밀번호 : <input type="text" name="user_password"><br/>
		닉네임 : <input type="text" name="user_nickname"><br/>
	 	회원유형 :  일반 <input type="radio" name="type" value="일반"> 관리자 <input type="radio" name="type" value="관리자"><br/> 
		<button>회원가입</button>
</form>
</body>
</html>