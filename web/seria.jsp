<%@ page import="mypackage.Type_work" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 09.06.2016
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <% LinkedList<Type_work> type_works = (LinkedList<Type_work>) request.getAttribute("type_works");%>
<head>
    <title><%=type_works%></title>
</head>
<body>
</body>
</html>
