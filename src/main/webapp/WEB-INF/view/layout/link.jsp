<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <ul>
        <div>

        </div>

        <c:choose>
            <c:when test="${principal == null}">
                <div>
                    <a href="/">홈 </a>
                    <a href="/loginForm">로그인 </a>
                    <a href="/joinForm">회원가입 </a>
                </div>
            </c:when>

            <c:otherwise>
                <div>
                    <a href="/">홈 </a>
                    <a href="/purchase">회원정보</a>
                    <a href="/logout">로그아웃</a>
                </div>
            </c:otherwise>
        </c:choose>
    </ul>
    <hr>