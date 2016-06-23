<%@ page import="mypackage.Type_work" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 09.06.2016
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% String seria_name =(String) request.getAttribute("seria_name");
//    response.sendRedirect("/sdasd");
//    String site = new String(seria_name);
//    response.setStatus(response.SC_MOVED_TEMPORARILY);
//    response.setHeader("Location", site);
//    response.setHeader("Connection", "close");
//    response.sendRedirect(site);
//    response.encodeURL (site);
%>

<head>
    <title><%=seria_name%></title>
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
    <tr>
        <td colspan="4">
            <%Iterator itr;%>
            <% LinkedList<Type_work> data = (LinkedList<Type_work>) request.getAttribute("type_works");
                Type_work type_works;
                for (itr=data.iterator(); itr.hasNext(); ) {
                    type_works = (Type_work) itr.next();
            %>
                <table>
                    <tr>
                        <td colspan="3">
                            <h3 align="center">Серия &laquo;<%=type_works.getName()%>&raquo;</h3>
                        </td>
                    </tr>
                    <tr>
                        <td width="50%" rowspan="2">
                            <img src="/img/<%=seria_name%>/<%=type_works.getPhoto()%>" width="60%" alt="cars" hspace="20%">
                        </td>
                        <td width="25%">
                            <form action="works" method="get">
                                <input type="submit" class="button head_button" value="Готовые папертоли">
                                <input type="hidden" name="is_finished" value="true">
                                <input type="hidden" name="name" value="<%=type_works.getName()%>">
                                <input type="hidden" name="type_work_id" value=<%=type_works.getId()%>>
                            </form>
                        </td>
                        <td width="25%">
                            <form action="works" method="get">
                                <input type="submit" class="button head_button" value="Папертольные карты">
                                <input type="hidden" name="is_finished" value="false">
                                <input type="hidden" name="name" value="<%=type_works.getName()%>">
                                <input type="hidden" name="type_work_id" value=<%=type_works.getId()%>>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <%=type_works.getDescription()%>
                        </td>
                    </tr>
                </table>
            <hr>
            <%}%>
        </td>
    </tr>
</table>
</body>
</html>