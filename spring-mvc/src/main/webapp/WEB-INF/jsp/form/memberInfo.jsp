<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--
** MemberVO의 객체를 스프링이 자동으로 등록하면, memberVO라는 이름으로 등록된다. **
<h1>회원 정보</h1>
id : ${ memberVO.id } <br />
password : ${ memberVO.password } <br />
name : ${ memberVO.name } <br />
-->

<h1>회원 정보</h1>
id : ${ member.id } <br />
password : ${ member.password } <br />
name : ${ member.name } <br />
</body>
</html>