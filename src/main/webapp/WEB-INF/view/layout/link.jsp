<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <ul>
        <c:choose>
            <c:when test="${principal == null}">

                <a href="/">홈</a>
                <a href="/loginForm">로그인 페이지</a>
                <a href="/joinForm">회원가입 페이지</a>

            </c:when>

            <c:otherwise>

                <a href="/">홈 </a>
                <a href="/user/update">회원정보 수정</a>
                <a href="/logout">로그아웃</a>

            </c:otherwise>
        </c:choose>
    </ul>