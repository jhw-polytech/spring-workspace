<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .error {
      color : red;
   }
</style>
</head>
<body>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시물 등록폼</h2>
			<hr width="80%">
			<br>
			<!-- Spring에서 제공하는 form이라는 형태의 태그를 쓴다 -->
			<form:form commandName="boardVO" method="post"> <!-- commandName을 통해 boardVO라는 이름으로 등록된 객체를 가져옴 -->
				<table border="1" style="width: 80%">
					<tr>
						<th width="23%">제목</th>
						<td>
							<!-- path라는 속성이 중요하다! 현재 이 form태그는 getter역할을 함 -->
							<form:input path="title" />
							<form:errors path="title" class="error" />
						</td>
					</tr>	
					<tr>
						<th width="23%">글쓴이</th>
						<td>
							<form:input path="writer" />
							<form:errors path="writer" class="error"  />
						</td>
					</tr>	
					<tr>
						<th>내용</th>
						<td>
							<form:input path="content" rows="7" cols="50" />
							<form:errors path="content" class="error"  />
						</td>
					</tr>	
		
				</table>
				<br> <input type="submit" value="  등록  ">
				<input type="button" value="  목록  " id="btnList">
			</form:form>
<!-- 			<form method="post"> 헤드에 이렇게만 써주면 현재와 같은 uri에 post 방식으로 날라간다. -->

		</div>
	</section>
</body>
</html>