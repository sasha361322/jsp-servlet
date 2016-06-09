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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Ассортимент</title>
    <style>
        <%@include file='css/style.css' %>
    </style>
    <script>var array = new Array();
    var speed = 10;
    var timer = 10;
    // Loop through all the divs in the slider parent div //
    // Calculate search content divs height and set it to a variable //
    function slider(target, showfirst) {
        var slider = document.getElementById(target);
        var divs = slider.getElementsByTagName('div');
        var divslength = divs.length;
        for(i = 0; i < divslength; i++) {
            var div = divs[i];
            var divid = div.id;
            if(divid.indexOf("header") != -1) {
                div.onclick = new Function("processClick(this)");
            } else if(divid.indexOf("content") != -1) {
                var section = divid.replace('-content','');
                array.push(section);
                div.maxh = div.offsetHeight;
                if(showfirst == 1 && i == 1) {
                    div.style.display = 'block';
                } else {
                    div.style.display = 'none';
                }
            }
        }
    }
    // Process the click - expand the selected content and collapse the others //
    function processClick(div) {
        var catlength = array.length;
        for(i = 0; i < catlength; i++) {
            var section = array[i];
            var head = document.getElementById(section + '-header');
            var cont = section + '-content';
            var contdiv = document.getElementById(cont);
            clearInterval(contdiv.timer);
            if(head == div && contdiv.style.display == 'none') {
                contdiv.style.height = '0px';
                contdiv.style.display = 'block';
                initSlide(cont,1);
            } else if(contdiv.style.display == 'block') {
                initSlide(cont,-1);
            }
        }
    }
    // Setup the variables and call the slide function //
    function initSlide(id,dir) {
        var cont = document.getElementById(id);
        var maxh = cont.maxh;
        cont.direction = dir;
        cont.timer = setInterval("slide('" + id + "')", timer);
    }
    // Collapse or expand the div by incrementally changing the divs height and opacity //
    function slide(id) {
        var cont = document.getElementById(id);
        var maxh = cont.maxh;
        var currheight = cont.offsetHeight;
        var dist;
        if(cont.direction == 1) {
            dist = (Math.round((maxh - currheight) / speed));
        } else {
            dist = (Math.round(currheight / speed));
        }
        if(dist <= 1) {
            dist = 1;
        }
        cont.style.height = currheight + (dist * cont.direction) + 'px';
        cont.style.opacity = currheight / cont.maxh;
        cont.style.filter = 'alpha(opacity=' + (currheight * 100 / cont.maxh) + ')';
        if(currheight < 2 && cont.direction != 1) {
            cont.style.display = 'none';
            clearInterval(cont.timer);
        } else if(currheight > (maxh - 2) && cont.direction == 1) {
            clearInterval(cont.timer);
        }
    }</script>
</head>
<body onload="slider('slider',0)">

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
            <form action="" method="post">
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
            <div id="intro">
                <p>
                <div id="slider">
                    <div class="header" id="1-header">Папертоли</div>
                    <div class="content" id="1-content">
                        <div class="text">
                                <%Iterator itr;%>
                                <% LinkedList<Seria> data = (LinkedList<Seria>) request.getAttribute("data");
                                Seria seria;
                                for (itr=data.iterator(); itr.hasNext(); ) {
                                    seria = (Seria) itr.next();
                                %>
                                <form id="<%=seria.getId()%>" action="/seria" method="post">
                                    <input type="hidden" name="seria_id" value=<%=seria.getId()%>>
                                    <table onclick="document.getElementById('<%=seria.getId()%>').submit();">
                                        <tr>
                                            <td colspan="2">
                                                <h3 align="center">Серия &laquo;<%=seria.getName()%>&raquo;</h3>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="50%">
                                                    <img src="/img/<%=seria.getPhoto()%>" width="60%" alt="cars" hspace="20%">
                                            </td>
                                            <td>
                                                <%=seria.getDescription()%>
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                                <hr>
                                <%}%>
                        </div>
                    </div>
                    <div class="header" id="3-header">Комплектующие</div>
                    <div class="content" id="3-content">
                        <div class="text">
                            Содержимое блока.
                        </div>
                    </div>
                </div>
                </p>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
