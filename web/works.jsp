<%@ page import="mypackage.Work" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="mypackage.Component" %><%--
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

    <tr>
        <td colspan="4">
            <%Iterator itr;%>
            <% LinkedList<Work> data = (LinkedList<Work>) request.getAttribute("works");
                Work work;
                for (itr=data.iterator(); itr.hasNext(); ) {
                    work = (Work) itr.next();
            %>
            <table>
                <tr>
                    <td>
                        <h3 align="center">Серия &laquo;<%=name%>&raquo;</h3>
                    </td>
                    <td>
                        <h3 align="center">art.<%=work.getArticle()%></h3>
                    </td>
                    <td>
                        <h3 align="center">Цена <%=work.getPrice()%> рублей</h3>
                    </td>
                </tr>
                <tr>
                    <td width="50%" colspan="2">
                        <img src="/img/<%=work.getOwn_photo()%>" width="60%" alt="<%=work.getOwn_photo()%>" hspace="20%">
                    </td>

                    <td>
                        Размер: <%=work.getSize_x()%>*<%=work.getSize_y()%> см
                        <hr>
                        Количество листов <%=work.getCount_lists()%>
                        <hr>
                        <%=work.getDescription()%>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <table>
                            <tr>
                                <th colspan="3">С этим так же покупают</th>
                            </tr>
                            <tr>
                            <%LinkedList<Component>components=work.getComponents();
                            Iterator i;
                            Component component;
                            for(i=components.iterator();i.hasNext();){
                                component=(Component)i.next();%>
                                <td width="33%">
                            <table>
                                <tr>
                                    <td><%=component.getName_ru()%></td>
                                    <td>Цена: <%=component.getPrice()%></td>
                                </tr>
                                <tr>
                                    <td width="50%">
                                        <img src="/img/components/<%=component.getPhoto()%>" width="100%"">
                                    </td>
                                    <td>
                                        <%=component.getDescription()%>
                                    </td>
                                </tr>

                            </table>
                                </td>
                            <%}%>
                            </tr>
                        </table>
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
