<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="madecss.css" rel="stylesheet" type="text/css"/>

    <script>
        function fnSearch() {
            let category = document.getElementsByName("")
            let keyword = document.getElementsByName("query").values();


        }

        function list_pressCheck() {

        }
    </script>
</head>

<body>


<div id="HANA_CONTENTS_DIV">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">

        <h2>정보소통</h2>
        <div class="locate">
            HOME &gt; 고객센터 &gt; 손님의소리 &gt; <strong>정보소통</strong>
        </div>
    </section>

    <!-- ======= Certificate Section ======= -->
    <section>
        <div class="container">
            <div class="searchBoard">
                <div class="searchField">
                    <select id="searchField" name="searchField" title="검색분류 선택" class="wd80px">
                        <option value="all" selected>검색분류</option>
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                    </select>
                </div>
                <div class="searchInput">
                    <input type="text" title="검색어 입력" class="wd130px" id="query" name="query" value=""
                           onkeydown="javascript:list_pressCheck((event),this);">
                    <a href="#" onclick="javascript:fnSearch(); return false;">
                        <button>검색</button>
                    </a>
                </div>
            </div>
            <div class="tbldiv board mt15">

                <table class="tbl_col01" border="1" style="width: 100%">
                    <colgroup>
                        <col span="1" style="width: 10%;">
                        <col span="1" style="width: 50%;">
                        <col span="1" style="width: 15%;">
                        <col span="1" style="width: 10%;">
                        <col span="1" style="width: 15%;">
                    </colgroup>
                    <thead>
                    <!-- <tr>-->
                    <th class="b-tnone color3" scope="col" style="border-left: hidden;">번호</th>
                    <th class="b-tnone color3" scope="col">제목</th>
                    <th class="b-tnone color3" scope="col">글쓴이</th>
                    <th class="b-tnone color3" scope="col">조회수</th>
                    <th class="b-tnone color3" scope="col" style="border-right: hidden;">작성일</th>
                    <!--</tr>-->
                    </thead>
                    <c:forEach items="${ boardList }" var="board" varStatus="loop">
                        <tr>
                            <td style="border-left: hidden;">${ boardVO.no }</td>
                            <td>
                                <a href="javascript:doAction(${ boardVO.no })" data-toggle="modal"
                                   data-target="#loginModal">
                                    <c:out value="${ boardVO.title }"/>
                                </a>
                                <%--
                                <a href="detail.jsp?no=${ boardVO.no }">
                                    <c:out value="${ boardVO.title }"/>
                                </a>
                                --%>
                            </td>
                            <td>${ boardVO.writer }</td>
                            <td>${ boardVO.viewCnt }</td>
                            <td style="border-right: hidden;">${ boardVO.regDate }</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>

            <div class="paging">
                <a href="/contents/kor/recruit/notice/public/index.jsp" class="btn first">
                    <img src="img/btn/btn_first.gif" alt="처음페이지"></a>
                <a href="/contents/kor/recruit/notice/public/index.jsp" class="btn">
                    <img src="img/btn/btn_prev.gif" alt="이전페이지"></a>
                <a href="/contents/kor/recruit/notice/public/index.jsp" class="on">
                    <strong>1</strong></a>
                <a href="/contents/kor/recruit/notice/public/index.jsp" class="btn">
                    <img src="img/btn/btn_next.gif" alt="다음페이지"></a>
                <a href="/contents/kor/recruit/notice/public/index.jsp" class="btn last">
                    <img src="img/btn/btn_last.gif" alt="마지막페이지"></a>
            </div>
            <br>
            <div>
                <c:if test="${ not empty userVO }">
                    <button onclick="goWriteForm()" class="btn btn-primary">새글등록</button>
                </c:if>
            </div>
        </div>
    </section>
</div>

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabel" contenteditable="true">회원만 이용 가능한 서비스입니다.</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" contenteditable="true">
                로그인 한 회원만 이용할 수 있습니다. 로그인 하러 가시겠습니까?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" contenteditable="true">로그인</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal" contenteditable="true">취소</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>