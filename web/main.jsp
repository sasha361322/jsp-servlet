<%@ page import="java.util.LinkedList" %>
<%@ page import="mypackage.News" %><%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 04.06.2016
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="windows-1251"%>
<html>
  <head>
      <meta charset="UTF-8">
      <title>Главная</title>
      <style>
          <%@include file='css/style.css' %>
      </style>
      <script type="text/javascript" src="js/slider.js"></script>
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
              <form action="" method="post">
                <input class = "button head_button" type="submit" value="Главная"/>
              </form>
          </th>
          <th>
              <form action="about.jsp" method="post">
                  <input class = "button head_button" type="submit" value="О нас"/>
              </form>
          </th>
          <th>
              <form action="assortment" method="post">
                  <input class = "button head_button" type="submit" value="Ассортимент"/>
              </form>
          </th>
          <th>
              <form action="contacts.jsp" method="post">
                  <input class = "button head_button" type="submit" value="Контактные данные"/>
              </form>
          </th>
      </tr>
      <tr>
          <td colspan="4">
              <h2 align="center">Новости</h2>
            <%
                LinkedList<News>newses = (LinkedList<News>) request.getAttribute("news");
                for(News news:newses){%>
                    <p><%=news.getText()%></p><br><br>
                    <%
                    for (String photo:news.getPhotoes()){%>
                    <img src="<%=photo%>"><br><br><br>
                    <%}
                    %><hr><%
                }%>
          </td>
      </tr>
  </table>
  </body>
</html>
