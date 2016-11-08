<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 06.11.2016
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="m" uri="/WEB-INF/tld/tag1.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/sb-style.css">
    <script src="../js/infoDisplay.js"></script>
    <c:if test="${empty pageContext.request.parameterMap.lang[0]}">
        <c:choose>
            <c:when test="${empty cookie.lang.value}">
                <fmt:setLocale value="ru_RU"/>
                <c:set var="lang" value="ru_RU"/>
            </c:when>
            <c:otherwise>
                <fmt:setLocale value="${cookie.lang.value}"/>
                <c:set var="lang" value="${cookie.lang.value}"/>
            </c:otherwise>
        </c:choose>
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
    <jsp:useBean id="sb" class="com.beans.beanShopBasket.SBList" scope="session" />
    <jsp:useBean id="user" class="com.beans.beanUser.User" scope="session" />
    <title><fmt:message key="title"/></title>
</head>
<body>
<div class="sb-body">

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


            <form action="" class="hat-form">
                <button type="submit" name="history-button" class="hat-button" onclick="alert('history')"><fmt:message key="history" /></button>
            </form>
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
    <div class="upper">
        <h3><fmt:message key="sbTitle"/></h3>
        <form action="/sb?lang=${lang}" method="post">
            <input type="submit" id="clearBasketButton" name="idClear" value="<fmt:message key="sbClear"/>">
        </form>
    </div>
    <div class="basket-ads">
        <c:forEach var="product" items="${m:getSBList()}" >
            <div class="each-ad-div">
                <h4>${m: getAd(product.key).title}</h4>
                <p id="price">${m: getAd(product.key).price} <fmt:message key="currency"/></p>
                <div class="selectors">
                    <form action="/sb?lang=${lang}" method="post">
                        <input name="idM" type="image" src="../img/minus.png" width="16" height="16" value="${product.key}" >
                    </form>
                    <input type="text" value="${product.value}" size="3"/>
                    <form action="/sb?lang=${lang}" method="post">
                        <input name="idP" type="image" src="../img/plus.png" width="16" height="16" value="${product.key}">
                    </form>
                </div>
                <img src="../img/${m: getAd(product.key).foto1}" width="200px" height="150px">
                <p class="some-desc-to-each"><fmt:message key="yearIss"/> ${m: getAd(product.key).year}</p>
                <hr>
            </div>
        </c:forEach>
    </div>
    <div class="pre-order">
        <h3><fmt:message key="yourOrder"/></h3>
        <h4><fmt:message key="numOfOrder"/>:</h4>
        <h4 id="countOrder">${m:getSize()}</h4>
        <h4 id="sum"><fmt:message key="orderSum"/>: ${m:getSum()} <fmt:message key="currency"/></h4>
        <a href="/auth?page=order&lang=${lang}"><input type="button" id="checkout-button" value="<fmt:message key="checkout"/>"></a>
    </div>
</div>
</body>
</html>

