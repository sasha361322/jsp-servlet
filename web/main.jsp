<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 04.06.2016
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="windows-1251"%>
<html>
  <head>
      <meta charset="UTF-8">
      <title>Главная</title>
  </head>
  <body>
  <table border=1
         cellpadding=0
         cellspacing=0
         width="90%"
         align="center"
  >
      <tr>
          <th><p>Главная</p></th>
          <th>О нас</th>
          <th>Ассортимент</th>
          <th>Контактные данные</th>
      </tr>
        <%Iterator itr;%>
        <% List data= (List)request.getAttribute("seriesPhotos");
            for (itr=data.iterator(); itr.hasNext(); ) {
        %>
        <tr>
            <td colspan="4">
                <img src="/img/<%=itr.next()%>" width="33%" alt="cars">
            </td>
        </tr>
        <%}%>
  </table>
  </body>
</html>
