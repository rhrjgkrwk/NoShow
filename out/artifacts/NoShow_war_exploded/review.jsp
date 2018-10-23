<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HeemangHan
  Date: 2016. 8. 29.
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리뷰 게시판</title>
</head>
<body>
<div>
    아이디 : ${sessionScope.userId}
    평가 : <input type="text" id="rating">
    <textarea name="content" id="content" cols="30" rows="10"></textarea>
    <button id="btn_write">작성</button>
    <hr>
    <div class="article_container">
        <table class="article_list">
            <tr>
                <th width="100">작성자</th>
                <th width="300">내용</th>
                <th width="100">작성일</th>
                <th width="60">평점</th>
            </tr>
            <tbody>
            <c:forEach items="${articleList}" var="article">
                <tr>
                    <td>${article.review_writer}</td>
                    <td>${article.review_content}</td>
                    <td>${article.review_regdate}</td>
                    <td>${article.review_rating}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
