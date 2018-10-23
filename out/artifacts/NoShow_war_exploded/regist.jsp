<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap-theme.min.css">
    <script src="webjars/jquery/3.1.0/dist/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            getLocation();
        });

        function getLocation() {
            if (navigator.geolocation)
                navigator.geolocation.getCurrentPosition(showPosition);
        }

        function showPosition(position) {
            $('#lat').val(position.coords.latitude);
            $('#lng').val(position.coords.longitude);
        }
    </script>

    <title>Regist</title>
</head>
<body>
<form action="regist.do">
    <table>
        <tr>
            <td>사업자 등록번호</td>
            <td><input type="text" name="regnum"></td>
        </tr>
        <tr>
            <td>레스토랑 이름</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="tel"></td>
        </tr>
        <tr>
            <td>위도</td>
            <td><input type="text" id="lat" name="lat"></td>
        </tr>
        <tr>
            <td>경도</td>
            <td><input type="text" id="lng" name="lng"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="제출"></td>
        </tr>
    </table>
</form>
</body>
</html>
