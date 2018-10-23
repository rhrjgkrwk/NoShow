<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>레스토랑 리스트</title>
    <script src="/webjars/jquery/3.1.0/dist/jquery.min.js"></script>
</head>
<body>
<table border="1">
    <tr>
        <th>idx</th>
        <th>Restaurant Name</th>
        <th>tel</th>
        <th>Address</th>
        <th>Latitude</th>
        <th>Longitude</th>
        <th>Host</th>
        <th>Host Tel</th>
    </tr>
    <tbody>
    <c:forEach items="${restaurantList}" var="restaurant">
        <tr>
            <td>${restaurant.restaurantNo}</td>
            <td><a href="/menu.do?idx=${restaurant.restaurantNo}">${restaurant.restaurantName}</a></td>
            <td>${restaurant.restaurantTel}</td>
            <td>${restaurant.restaurantAddress}</td>
            <td>${restaurant.restaurantLatitude}</td>
            <td>${restaurant.restaurantLongitude}</td>
            <td>${restaurant.member.memberName}</td>
            <td>${restaurant.member.memberTel}</td>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
