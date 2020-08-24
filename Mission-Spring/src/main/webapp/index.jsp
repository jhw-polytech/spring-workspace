<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

<!-- WEB-INF 폴더 밑의 파일들은 외부에서 접근할 수 없기 때문에, 원래대로면 index.jsp는 webapp폴더 바로 밑에 생성되어야 한다.  -->



	<a href="${ pageContext.request.contextPath }/board">게시판</a><br>	
	<c:choose>
	<c:when test="${ empty loginVO }">
	<a href="${ pageContext.request.contextPath }/login">로그인</a><br>
	</c:when>
	<c:otherwise>
	<a href="${ pageContext.request.contextPath }/logout">로그아웃</a><br>
	</c:otherwise>
	</c:choose>
	
</body>
</html>