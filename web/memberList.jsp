<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HeemangHan
  Date: 2016. 9. 7.
  Time: 오후 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tbody>
    <c:forEach items="${memberList}" var="member">
        <tr>
            <td>${member.memberNo}</td>
            <td>${member.memberId}</td>
            <td>${member.memberPw}</td>
            <td>${member.memberName}</td>
            <td>${member.memberTel}</td>
            <td>${member.memberRegdate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
