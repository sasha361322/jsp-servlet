<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 24.06.2016
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Войти</title>
    <style>
        <%@include file='css/style.css' %>
    </style>
</head>
<body>
<div class="main">
<form action="login" method="post">
    Войдите в систему
    <br>
    <br>
    <div  class="field">
        <label for="1">
            Имя
        </label>
        <input type="text" name="name" id="1" maxlength="23">
    </div>
    <br>
    <div class="field">
        <label for="2">
            Пароль
        </label>
        <input type="password" name="password" id="2" maxlength="23">
    </div>
    <br>
    <div  class="field">
        <input type="submit" class="button" value="Войти">
    </div>
</form>
</div>
</body>
</html>