<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HeemangHan
  Date: 2016. 9. 8.
  Time: 오후 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
    <script src="webjars/jquery/3.1.0/dist/jquery.min.js"></script>
    <script>
        var test;
        $(document).ready(function() {
            $('.add_btn').click(function() {
                var parent = $(this).parent().parent();
                var menu_num = $(parent).find('.menu_num').html();
                var menu_name = $(parent).find('.menu_name').html();
                var menu_price = $(parent).find('.menu_price').html();
                var menu_count = $(parent).find('.menu_count').val();

                console.log(menu_num);
                console.log(menu_name);
                console.log(menu_price);
                console.log(menu_count);

                var content =   '<tr>' +
                        '<td class="menu_num">' + menu_num + '</td>' +
                        '<td class="menu_name">' + menu_name + '</td>' +
                        '<td class="menu_price">' + menu_price + '</td>' +
                        '<td class="menu_count">' + menu_count + '</td>' +
                        '<td><button class="delete_btn">X</button></td>' +
                        '</tr>';

                $('#menu_table > tbody:last-child').append(content);
            });
        });

        $(document).on('click', '.delete_btn', function() {
            var parent = $(this).parent().parent();
            parent.remove();
        });

        $(document).on('click', '#btn_reserve', function() {
            var member_no = ${sessionScope.member.getMemberNo()};
            var restaurant_no = ${menuList[0].restaurant.restaurantNo};
            var menu_num = $('#menu_table').find('.menu_num');
            var menu_count = $('#menu_table').find('.menu_count');
            var reserve_request = $('#reserve_request').val();
            var reserve_date = $('#reserve_date').val();
            var reserve_time = $('#reserve_time').val();
            var menu = new Array(menu_num.length);

            var json = new Object();
            var menuArr = new Array();

            json.memberNo = member_no;
            json.restaurantNo = restaurant_no;

            for(var i = 0; i < menu_num.length; i++) {
                var menuInfo = new Object();

                menuInfo.menuNum = menu_num[i].textContent;
                menuInfo.menuCount = menu_count[i].textContent;

                menuArr.push(menuInfo);
            }

            json.menu = menuArr;
            json.reservationDate = reserve_date;
            json.reservationTime = reserve_time;
            json.reservationRequest = reserve_request;

            $.ajax({
                type : 'POST',
                url :  'reserve.json',
                dataType : 'json',
                data : {json : JSON.stringify(json)},
                success : function(json) {
                    alert('에약 완료');
                }
            });
        });
    </script>
</head>
<body>
    <table border="1">
        <tr>
            <th colspan="6">${menuList[0].restaurant.restaurantName}</th>
        </tr>
        <tr>
            <th>메뉴번호</th>
            <th>메뉴이름</th>
            <th>가격</th>
            <th>설명</th>
            <th>개수</th>
            <th>예약</th>
        </tr>
        <c:forEach items="${menuList}" var="menu">
            <tr>
                <td class="menu_num">${menu.menuNum}</td>
                <td class="menu_name">${menu.menuName}</td>
                <td class="menu_price">${menu.menuPrice}₩</td>
                <td>${menu.menuDescription}</td>
                <td><input type="number" class="menu_count"></td>
                <td><button class="add_btn">추가</button></td>
            </tr>
        </c:forEach>
    </table>

    <br>

    <table border="1" id="menu_table">
        <tr>
            <th>메뉴번호</th>
            <th>메뉴이름</th>
            <th>가격</th>
            <th>개수</th>
            <th>취소</th>
        </tr>
    </table>

    요청사항 <input type="text" id="reserve_request"><br/>
    날짜 <input type="date" id="reserve_date"><br/>
    시간 <input type="time" id="reserve_time" step="1"><br/>

    <button id="btn_reserve">예약</button>

</body>
</html>
