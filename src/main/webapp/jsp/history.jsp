<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 14.11.2016
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.beans.*" %>
<%@ taglib prefix="m" uri="/WEB-INF/tld/tag1.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/styles1.css">
    <script src="../js/infoDisplay.js"></script>
    <jsp:useBean id="user" class="com.beans.beanUser.User" scope="session" />
    <jsp:useBean id="basket" class="com.beans.beanShopBasket.SBList" scope="session" />
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
    <title><fmt:message key="history"/> </title>

</head>
<body>
<div class="bodyHistory">
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
        <div id="search-row"><form action="search" method="GET" accept-charset="windows-1251"><input type="search" placeholder="<fmt:message key="hintMessage"/>" name="search-req">
            <button class="search-button"><a href="/"><img src="../img/search.png" alt="search"></a></button> </form>
        </div>
        <div class="service-buttons">
            <c:if test="${user.auth==null}">
                <a href="/auth?page=list&lang=${lang}" class="hat-button"><fmt:message key="signIn"/></a>
            </c:if>
            <c:if test="${user.auth=='1'}">
                <a href="/w?page=account&lang=${lang}" class="hat-button">${user.name}</a>
                <a href="/logout?page=list" class="hat-button"><fmt:message key="logOut"/> </a>
            </c:if>

            <a href="/auth?page=history&lang=${lang}" class="hat-button"><fmt:message key="history"/> </a>
            <c:if test="${m:getSize()>0}">
                <a href="/auth?page=order&lang=${lang}" class="hat-button"><fmt:message key="checkout"/> </a>
            </c:if>

            <a href="/jsp/sb.jsp?lang=${lang}"> <img src="../img/shoppingbag.png"></a>

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
    <h2 id="history"><fmt:message key="history"/></h2>
    <div class="history">
        <c:forEach var="order1" items="${sessionScope.orders}">
            <div class="historyOffice">
                <ul>
                    <li id="historyLi1">
                        <p><fmt:message key="yourOrder"/>: ${order1.car}</p>
                        <p><fmt:message key="address"/>: ${order1.delivery}</p>
                    </li>
                    <li id="historyLi2">
                        <p><fmt:message key="count"/>: ${order1.count}</p>
                        <p><fmt:message key="date"/>: ${order1.date}</p>
                    </li>
                </ul>
                <hr>
            </div>
        </c:forEach>
    </div>
    </div>
</body>
</html>