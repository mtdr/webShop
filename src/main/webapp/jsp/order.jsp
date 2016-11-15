<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="m" uri="/WEB-INF/tld/tag1.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/styles1.css">
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyCcjVutbao2uKESWLeoqIBIZbCZ050klMM"></script>
    <title>Order</title>
    <script src="../js/infoDisplay.js"></script>
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
    <script type="text/javascript">
        var ox = [${pageContext.request.parameterMap.ox[0]}];
        var oy = [${pageContext.request.parameterMap.oy[0]}];
        var address = [${pageContext.request.parameterMap.Address[0]}];
        var shopTitle = [${pageContext.request.parameterMap.Title[0]}];
        var shopId = [${pageContext.request.parameterMap.Id[0]}];
    </script>
</head>
<body onload="initialize(ox,oy,address,shopTitle,shopId);">
<div class="body-order">
    <header id="header">
        <div id="logo"><a href="/"><img src="../img/car.png" alt="Logo"></a></div>
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
    <div class="order-main">
        <h2><fmt:message key="yourOrder"/></h2>
        <c:forEach var="product" items="${m:getSBList()}" >
            <div class="order-model">
                <h4>${m: getAd(product.key).title}</h4>
                <p id="price3">${m:getAd(product.key).price} <fmt:message key="currency"/> </p>
                <p id="countProd"><fmt:message key="count"/>: ${product.value}</p>
                <p class="description2"><fmt:message key="yearIss"/>: ${m: getAd(product.key).year}</p>
                <img src="../img/${m: getAd(product.key).foto1}" width="200px" height="150px">
                <hr>
            </div>
        </c:forEach>
    </div>
    <div class="navBar">
        <div id="navBarA1" class="choice-order" style="background-color: #83201b;" onclick="orderShow('1');">
            <p><fmt:message key="pickup"/></p>
        </div>
        <div id="navBarA2" class="choice-order" onclick="orderShow('2');">
            <p><fmt:message key="delivery"/></p>
        </div>
    </div>
    <div id="pickup" class="specification1" style="display: block;">
        <ul>
            <li>
                <div id="map_canvas"></div>
            </li>
            <form method="post" action="/order?lang=${lang}">
                <li id="liTake">
                    <c:forEach var="shop" items="${sessionScope.shops}">
                        <div class="shop">
                            <input id="radio${shop.idShop}" class="radioShop" type="radio" name="shop" value="${shop.address}">${shop.titleShop}
                            <p><fmt:message key="address"/>: ${shop.address}</p>
                            <%--TODO: localization--%>
                        </div>
                    </c:forEach>
                </li>
                <p class="sumOrder"><fmt:message key="orderSum"/></p>
                <p class="sumOrder1">${m:getSum()}</p>
                <input class="button4" type="submit" value="<fmt:message key="toOrder"/>">
            </form>
        </ul>
    </div>
    <div id="delivery" class="specification1" style="display: none;">
        <form method="post" action="/order?lang=${lang}&page=delivery">
            <label><fmt:message key="city"/></label><br>
            <input class="deliveryInp" name="city" type="text" size="50"/><br>
            <label><fmt:message key="street"/></label><br>
            <input class="deliveryInp" name="street" type="text" size="50"/><br>
            <label><fmt:message key="house"/></label><br>
            <input class="deliveryInp" name="house" type="text" size="50"/><br>
            <p class="sumOrder"><fmt:message key="orderSum"/></p>
            <p class="sumOrder1">${m:getSum()} <fmt:message key="currency"/></p>
            <input class="button4" type="submit" value="<fmt:message key="toOrder"/>">
        </form>
    </div>
</div>
</body>
</html>
