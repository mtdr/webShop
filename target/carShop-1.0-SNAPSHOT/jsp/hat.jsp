<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 25.10.2016
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="/WEB-INF/tld/tag1.tld" %>
<html>
<head>
    <jsp:useBean id="user" class="com.beans.beanUser.User" scope="session" />
    <link rel="stylesheet" href="../css/styles1.css">
</head>
<body>
<header id="header">
    <div id="logo"><a href="/"><img src="../img/car.png" alt="Logo"></a></div>
    <div id="nav-div"><ul id="navigation-list">
        <li class="nav"><a href="" >First</a></li>
        <li class="nav"><a href="" >Second</a></li>
        <li class="nav">
            <a href="#" class="dropbtn">Dropdown</a>
            <div class="dropdown-content">
                <a href="#">Link 1</a>
                <a href="#">Link 2</a>
                <a href="#">Link 3</a>
            </div>
        </li>
    </ul>
    </div>
    <div id="search-row"><form action="search" method="GET" accept-charset="windows-1251"><input type="search" placeholder="<%=res.getString("hintMessage")%>" name="search-req">
        <button class="search-button"><a href="/"><img src="../img/search.png" alt="search"></a></button> </form>
    </div>
    <div class="service-buttons">
        <c:if test="${user.auth==null}">
            <%--<form action="/auth?page=list&lang=<%=lang%>" method="get" class="hat-form">--%>
                <%--<button type="submit" class="hat-button"><%=res.getString("signIn")%></button>--%>
            <%--</form>--%>
            <a href="/auth?page=list&lang=<%=lang%>" class="hat-button"><%=res.getString("signIn")%></a>
        </c:if>
        <c:if test="${user.auth=='1'}">
            <a href="/w?page=account&lang=<%=lang%>" class="hat-button">${user.name}</a>
            <%--<form action="/logout?page=list&lang=<%=lang%>" method="get" class="hat-form">--%>
                <%--<button type="submit" class="hat-button"><%=res.getString("logOut")%></button>--%>
            <%--</form>--%>

            <a href="/logout?page=list" class="hat-button"><%=res.getString("logOut")%></a>
        </c:if>
        <%--<a href="?lang=<%=request.getParameter("lang")%>"></a>--%>

        <form action="#" class="hat-form">
            <button type="submit" name="history-button" class="hat-button" onclick="alert('history')"><%=res.getString("history")%></button>
        </form>
        <%--<form action="/jsp/basket.jsp?lang=<%=lang%>" class="hat-form-box">--%>
            <%--<button type="submit" name="box-button" onclick="alert('Корзина')"><img src="../img/shoppingbag.png" alt="bag"></button>--%>
        <%--</form>--%>
        <a href="/jsp/sb.jsp?lang=<%=lang%>"> <img src="../img/shoppingbag.png"></a>

        <p id="productsInBasket"> ${m:getSize()}</p>

    </div>
    <div id="languages">
        <ul id="language-panel">
            <li class="small-pic"><a href="?lang=ru_RU" onclick="addCookie('ru_RU');"><img id="rus" src="../img/rus.png" alt="Russian"></a></li>
            <li class="small-pic"><a href="?lang=en_GB" onclick="addCookie('en_GB');"><img id="eng" src="../img/eng.png" alt="English"></a></li>
            <li class="small-pic"><a href="?lang=de_DE" onclick="addCookie('de_DE');"><img id="de" src="../img/de.png" alt="Deutsch"></a></li>
        </ul>
    </div>
</header>
</body>
</html>
