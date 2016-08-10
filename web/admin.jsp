<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 25.06.2016
  Time: 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Администрирование</title>
    <style>
        <%@include file='css/style.css' %>
    </style>
</head>
<body>
<%if ((request.getAttribute("admin")==null)||(!(boolean)request.getAttribute("admin"))){
    %><jsp:forward page="login.jsp"/><%
}%>
<h1 align="center">Администрирование</h1>
<table align="center" width="100%" height="100%">
    <tr align="center">
    <th align="center">
        <form action="add" method="post">
            <input class = "button head_button" type="submit" value="Добавить"/>
        </form>
    </th>
    <th align="center">
        <form action="edit" method="post">
            <input class = "button head_button" type="submit" value="Редактировать"/>
        </form>
    </th>
    <th align="center">
        <form action="delete" method="post">
            <input class = "button head_button" type="submit" value="Удалить"/>
        </form>
    </th>
    </tr>
</table>
</body>
</html>