<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 06.11.2016
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="m" uri="/WEB-INF/tld/tag1.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <c:if test="${empty pageContext.request.parameterMap.lang[0]}">
        <c:set var="lang" value="ru_RU"/>
    </c:if>
    <c:if test="${pageContext.request.parameterMap.lang[0] eq 'ru_RU'}">
        <fmt:setLocale value="ru_RU"/>
        <c:set var="lang" value="ru_RU"/>
    </c:if>
    <c:if test="${pageContext.request.parameterMap.lang[0] eq 'en_GB'}">
        <fmt:setLocale value="en_GB"/>
        <c:set var="lang" value="en_GB"/>
    </c:if>
    <c:if test="${pageContext.request.parameterMap.lang[0] eq 'de_DE'}">
        <fmt:setLocale value="de_DE"/>
        <c:set var="lang" value="de_DE"/>
    </c:if>
    <fmt:setBundle basename="shop"/>
    <title><fmt:message key="accountLabel"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/styles1.css">
    <script src="../js/infoDisplay.js"></script>
    <jsp:useBean id="user" class="com.beans.beanUser.User" scope="session" />
    <jsp:useBean id="basket" class="com.beans.beanShopBasket.SBList" scope="session" />

</head>
<body>
<div class="bodyOffice">
    <header id="header">
        <div id="logo"><a href="/?lang=${lang}"><img src="../img/car.png" alt="Logo"></a></div>
        <div id="nav-div">
            <ul id="navigation-list">
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
        <div id="search-row"><form action="search" method="GET" accept-charset="windows-1251"><input type="search" placeholder="<fmt:message key="hintMessage" />" name="search-req">
            <button class="search-button"><a href="/"><img src="../img/search.png" alt="search"></a></button> </form>
        </div>
        <div class="service-buttons">
            <c:if test="${user.auth==null}">
                <%--<form action="/auth?page=list&lang=${lang}" method="get" class="hat-form">--%>
                <%--<button type="submit" class="hat-button"><fmt:message key="signIn" /></button>--%>
                <%--</form>--%>
                <a href="/auth?page=list&lang=${lang}" class="hat-button"><fmt:message key="signIn" /></a>
            </c:if>
            <c:if test="${user.auth=='1'}">
                <a href="/w?page=account&lang=${lang}" class="hat-button">${user.name}</a>
                <a href="/logout?page=sb" class="hat-button"><fmt:message key="logOut" /></a>

                <%--<form action="/logout?page=list&lang=${lang}" method="get" class="hat-form">--%>
                <%--<button type="submit" class="hat-button"><fmt:message key="logOut" /></button>--%>
                <%--</form>--%>

                <%--<a href="/logout?page=list" class="button1"><%=res.getString("logout")%></a>--%>
            </c:if>
            <%--<a href="?lang=<%=request.getParameter("lang")%>"></a>--%>

            <%--<form action="#" class="hat-form">--%>
            <%--<button type="submit" name="history-button" class="hat-button" onclick="alert('history')"><fmt:message key="history" /></button>--%>
            <%--</form>--%>
            <%--<form action="/jsp/sb.jsp?lang=${lang}" class="hat-form-box">--%>
            <%--<button type="submit" name="box-button" onclick="alert('Корзина')"><img src="../img/shoppingbag.png" alt="bag"></button>--%>
            <%--</form>--%>


            <%--<form class="hat-form">--%>
                <button type="submit" name="history-button" class="hat-button" onclick="alert('history')"><fmt:message key="history" /></button>
            <%--</form>--%>
            <a href="/jsp/sb.jsp?lang=${lang}"> <img src="../img/shoppingbag.png"></a>
            <p id="productsInBasket"> ${m:getSize()}</p>

        </div>
        <div id="languages">
            <ul id="language-panel">
                <li class="small-pic"><a href="?page=account&lang=ru_RU" onclick="addCookie('ru_RU');"><img id="rus" src="../img/rus.png" alt="Russian"></a></li>
                <li class="small-pic"><a href="?page=account&lang=en_GB" onclick="addCookie('en_GB');"><img id="eng" src="../img/eng.png" alt="English"></a></li>
                <li class="small-pic"><a href="?page=account&lang=de_DE" onclick="addCookie('de_DE');"><img id="de" src="../img/de.png" alt="Deutsch"></a></li>
            </ul>
        </div>
    </header>

    <h1 id="account-label"><fmt:message key="accountLabel"/></h1>
    <div class="userPhoto">
        <img src="../img/incognito.jpg" alt="incognito">
    </div>
    <div class="userInfo">
        <h2><fmt:message key="userNameLabel"/>: ${user.name}</h2>
        <h2><fmt:message key="defaultPage" />: ${pageContext.request.parameterMap.accT[0]}</h2>
    </div>
</div>
</body>
</html>
