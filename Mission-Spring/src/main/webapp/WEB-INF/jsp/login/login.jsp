<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
/*
*** Mission-WEB/js 디렉토리에 checkData.js라는 소스파일에 따로 선언 ***

function isNull(obj, msg) {
	if(obj.value == '') {
		alert(msg);
		obj.focus();
		return true;
	}		
	return false;
}
*/
function checkForm() {
	
	//document.lform.id.value
	//document.lform.password.value
	var f = document.lform;
	
	/*
	if(f.id.value == '') {
		alert("아이디를 입력해주세요")
		f.id.focus();s
		return false;
	}
	*/
	if(isNull(f.id, '아이디를 입력하세요.'))	return false;
	
	/*
	if(f.password.value == '') {
		alert('패스워드를 입력해주세요');
		f.password.focus();
		return false;			
	}
	*/
	if(isNull(f.password, '패스워드를 입력하세요.')) return false;
	
	
	return true;
	
}
</script>
</head>
<body>
<section>
		<div align="center">
			<br>
			<hr>
			<h2>로그인</h2>
			<hr>
			<br>
			
			<form action="${ pageContext.request.contextPath }/login"
			 method="post" onsubmit="return checkForm()" name="lform">
				<table style="width: 40%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<br>
				<button type="submit">로그인</button>
			</form>
		</div>
	</section>
</body>
</html>