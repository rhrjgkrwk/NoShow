<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>메인화면</title>
</head>
<body>
<h1>${sessionScope.member.getMemberId()}</h1>

<c:if test="${sessionScope.member.getMemberType() eq 'USR001'}">
    <a href="regist.jsp">레스토랑 등록</a>
</c:if>
<c:if test="${sessionScope.member.getMemberType() eq 'USR002'}">
    <a href="/restaurant/manage.do">레스토랑 관리</a>
</c:if>
<c:if test="${sessionScope.member.getMemberType() eq 'USR100'}">
    <a href="/admin/restaurant.do">레스토랑 승인</a>
</c:if>
<a href="/restaurant/list.do">레스토랑 목록</a>
<a href="/logout.jsp">로그아웃</a>
</body>
</html>