<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>레스토랑 관리화면</title>
    <script src="/webjars/jquery/3.1.0/dist/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.btn_add').click(function (event) {
                var restaurantNo = event.target.value;

                $.ajax({
                    type: 'POST',
                    url: 'restaurantState.json',
                    dataType: 'json',
                    data: {
                        'restaurantNo': restaurantNo,
                        'restaurantState': 'A',
                        'memberType' : 'USR002'
                    },
                    success: function (json) {
                        alert('등록 완료');
                        $(event.target).attr('class', 'btn_del');
                        $(event.target).text("정지");
                    }
                });
            });

            $('.btn_del').click(function (event) {
                var restaurantNo = event.target.value;

                $.ajax({
                    type: 'POST',
                    url: 'restaurantState.json',
                    dataType: 'json',
                    data: {
                        'restaurantNo': restaurantNo,
                        'restaurantState': 'S',
                        'memberType' : 'USR001'
                    },
                    success: function (json) {
                        alert('정지 완료');
                        $(event.target).attr('class', 'btn_add');
                        $(event.target).text("승인");
                    }
                });
            });
        });
    </script>
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
        <th>State</th>
        <th>Member Type</th>
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
            <c:choose>
                <c:when test="${restaurant.restaurantState eq 'A'}">
                    <td><button class="btn_del" value="${restaurant.restaurantNo}">정지</button></td>
                </c:when>

                <c:otherwise>
                    <td><button class="btn_add" value="${restaurant.restaurantNo}">승인</button></td>
                </c:otherwise>
            </c:choose>
            <td>${restaurant.member.memberType}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
