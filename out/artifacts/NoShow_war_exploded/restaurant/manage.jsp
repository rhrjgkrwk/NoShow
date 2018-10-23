<%--
  Created by IntelliJ IDEA.
  User: HeemangHan
  Date: 2016. 9. 14.
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>레스토랑 관리</title>
    <script src="/webjars/jquery/3.1.0/dist/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#btn_add_menu').click(function () {
                var menu_name = $('#menu_name').val();
                var menu_price = $('#menu_price').val();
                var menu_description = $('#menu_description').val();
                var menu_num = $('#menu_list')[0].length;

                var json = new Object();

                json.menuNum = menu_num;
                json.menuName = menu_name;
                json.menuPrice = menu_price;
                json.menuDescription = menu_description;

                $.ajax({
                    type : 'POST',
                    url : 'addMenu.json',
                    dataType : 'json',
                    data : {json : JSON.stringify(json)},
                    success : function (json) {
                        alert("추가 완료");
                        $('#menu_list').append($('<option>', {
                            value: $('#menu_list')[0].length + 1,
                            text: json.menuName
                        }));
                        console.log(json);
                    },
                    error : function(json) {
                        alert("실패");
                    }
                });
            });
        });
    </script>
</head>
<body>

<div>
    <table border="1">
        <tr>
            <th>사업자 등록번호</th>
            <td><input type="text" name="regnum" value="${restaurant.getRestaurantRegnum()}"></td>
        </tr>
        <tr>
            <th>레스토랑 이름</th>
            <td><input type="text" name="name" value="${restaurant.getRestaurantName()}"></td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td><input type="text" name="tel" value="${restaurant.getRestaurantTel()}"></td>
        </tr>
        <tr>
            <th>위도</th>
            <td><input type="text" name="latitude" value="${restaurant.getRestaurantLatitude()}"></td>
        </tr>
        <tr>
            <th>경도</th>
            <td><input type="text" name="longitude" value="${restaurant.getRestaurantLongitude()}"></td>
        </tr>
    </table>
    <button>수정</button>
</div>

<div>
    메뉴 이름 : <input type="text" name="menu_name" id="menu_name">
    메뉴 가격 : <input type="number" name="menu_price" id="menu_price">
    메뉴 설명 : <input type="text" name="menu_description" id="menu_description">
    <button id="btn_add_menu">메뉴 추가</button>
</div>
<div>
    <select id="menu_list" multiple>
        <c:forEach items="${menuList}" var="menu">
            <option value="${menu.menuNum}">${menu.menuName}</option>
        </c:forEach>
    </select>
</div>
</body>
</html>
