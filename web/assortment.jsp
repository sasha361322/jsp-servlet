<%@ page import="mypackage.Seria" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 06.06.2016
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ассортимент</title>
</head>
<body>

<table border=0
       cellpadding=0
       cellspacing=0
       width="90%"
       align="center"
>
    <tr>
        <th><a href="main.jsp">Главная</a></th>
        <th><a href="about.jsp">О нас</a></th>
        <th>Ассортимент</th>
        <th><a href="contacts.jsp">Контактные данные</a></th>
    </tr>
    <%Iterator itr;%>
    <% LinkedList<Seria> data = (LinkedList<Seria>) request.getAttribute("data");
        Seria seria;
        for (itr=data.iterator(); itr.hasNext(); ) {
            seria = (Seria) itr.next();
    %>
    <tr>
        <td colspan="4">
            <p style="text-align: center">
                <img src="/img/<%=seria.getPhoto()%>" width="33%" alt="cars">
            </p>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
