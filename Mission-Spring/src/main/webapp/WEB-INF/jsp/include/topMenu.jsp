<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<script type="text/javascript">
	function addFavorite() {
		try {
			window.external.AddFavorite('http://localhost:9999/Mission-Spring',
					'첫 번째 나의 스프링 웹');
		} catch (e) {
			alert("현재 사용 중인 브라우저에서는 사용할 수 있습니다.\n chrome의 경우 'ctrl + d'를 누르세요");
		}
	}
</script>
<table border="1" style="width: 100%">
	<tr>
		<td rowspan="2" style="width: 190px; height: 58px;"><a
			href="/Mission-Spring"> <img src="${ pageContext.request.contextPath }/resources/images/logo.png" style="width: 150px; height: 45px;"></a></td>
		<td align=right>
			<!-- <a href="javascript:window.external.AddFavorite('http://localhost:9999/Mission-WEB', '첫 번째 나의 웹')"> -->
			<!-- <a href="javascript:window.addFavorite()"> --> <a href="#"
			onclick="addFavorite()"> 즐겨찾기 </a> <c:if test="${ !empty loginVO }">
            [${ loginVO.id }님 으로 로그인 중...]
         </c:if>
		</td>
	</tr>
	<tr>
		<td>
			<nav>
				<c:if test="${ loginVO.type == 'S' }">
               회원관리 | 
            </c:if>
				<a href="${ pageContext.request.contextPath }/board">게시판</a>|
				<c:choose>
					<c:when test="${ empty loginVO }">
						<a>회원가입</a> | 
                  <a href="${ pageContext.request.contextPath }/login">로그인</a> |
               </c:when>
					<c:otherwise>
						<a>마이페이지</a> |
                  <a href="${ pageContext.request.contextPath }/logout">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</nav>
		</td>
	</tr>
</table>