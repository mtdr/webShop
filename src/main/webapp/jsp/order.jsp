<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 08.11.2016
  Time: 13:42
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

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/order-style.css">
    <script src="../js/infoDisplay.js"></script>

    <title><fmt:message key="orderPageTitle"/></title>
</head>
<body>
<div id="logo"><a href="/?lang=${lang}"><img src="../img/car.png" height="64" width="auto" alt="Logo"></a></div>
<p>Sth'll be here soon :)</p>
</body>
</html>
