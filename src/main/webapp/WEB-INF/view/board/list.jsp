<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>게시글 목록 페이지</h1>
        <hr>

        <%@ include file="../layout/link.jsp" %>

   <table border="1">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            
            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td>${board.id}</td>
                    <td>${board.title}</td>
                    <td>${board.createdAtToString}</td>
                </tr>
            </c:forEach>
        </table>

            <%@ include file="../layout/footer.jsp" %>