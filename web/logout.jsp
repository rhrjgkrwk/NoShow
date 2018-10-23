<%--
  Created by IntelliJ IDEA.
  User: HeemangHan
  Date: 2016. 9. 25.
  Time: PM 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
