<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 17.06.2016
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% String name =(String) request.getAttribute("name");%>
    <title>name</title>
    <style>
        <%@include file='css/style.css' %>
    </style>
</head>
<body>
<table border=0
       cellpadding=0
       cellspacing=0
       width="90%"
       align="center"
>
    <tr>
        <th>
            <form action="main.jsp" method="post">
                <input class = "button head_button" type="submit" value="Главная"/>
            </form>
        </th>
        <th>
            <form action="about.jsp" method="post">
                <input class = "button head_button" type="submit" value="О нас"/>
            </form>
        </th>
        <th>
            <form action="/assortment" method="post">
                <input class = "button head_button" type="submit" value="Ассортимент"/>
            </form>
        </th>
        <th>
            <form action="contacts.jsp" method="post">
                <input class = "button head_button" type="submit" value="Контактные данные"/>
            </form>
        </th>
    </tr>
</table>
</body>
</html>
