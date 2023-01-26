<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div class="link_box">

        <body>
            <c:choose>
                <c:when test="${principal == null}">
                    <a href="/loginForm">로그인</a>&nbsp;&nbsp;
                    <a href="/joinForm">회원가입</a>&nbsp;&nbsp;
                </c:when>

                <c:otherwise>
                    <a href="/updateForm">회원정보 수정</a>&nbsp;&nbsp;
                    <a href="/logout">로그아웃</a>&nbsp;&nbsp;
                </c:otherwise>
            </c:choose>
    </div>

    <div class="center_box">