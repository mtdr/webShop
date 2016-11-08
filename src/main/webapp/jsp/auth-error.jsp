<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 06.11.2016
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/auth-style.css">

    <title><fmt:message key="authPageTitle"/></title>
    <script src="../js/infoDisplay.js"></script>
    <c:if test="${empty pageContext.request.parameterMap.lang[0]}">
        <fmt:setLocale value="ru_RU"/>
        <c:set var="lang" value="ru_RU"/>
    </c:if>
    <c:if test="${pageContext.request.parameterMap.lang[0] eq 'de_DE'}">
        <fmt:setLocale value="de_DE"/>
        <c:set var="lang" value="de_DE"/>
    </c:if>
    <c:if test="${pageContext.request.parameterMap.lang[0] eq 'en_GB'}">
        <fmt:setLocale value="en_GB"/>
        <c:set var="lang" value="eb_GB"/>
    </c:if>
    <c:if test="${pageContext.request.parameterMap.lang[0] eq 'ru_RU'}">
        <fmt:setLocale value="ru_RU"/>
        <c:set var="lang" value="ru_RU"/>
    </c:if>
    <fmt:setBundle basename="shop"/>
</head>
<body>
<%--bodyAuth--%>
<div class="wrapper-auth">
    <h1><fmt:message key="errorMessage"/></h1>
    <form class="auth" action="j_security_check?lang=${lang}" method="POST" name="loginForm">
        <div class="language-panel">
            <a href = "?page=${pageContext.request.parameterMap.page[0]}&lang=ru_RU" onclick="addCookie('de_DE');"> <img src = "../img/de.png" width="30" height="30"></a>
            <a href = "?page=${pageContext.request.parameterMap.page[0]}&lang=en_GB" onclick="addCookie('en_GB');"> <img src = "../img/eng.png" width="30" height="30"></a>
            <a href = "?page=${pageContext.request.parameterMap.page[0]}&lang=be_BY" onclick="addCookie('ru_RU');"> <img src = "../img/rus.png" width="30" height="30"></a>
        </div>
        <label class="label"><fmt:message key="labelLogin" /></label><br>
        <input class="input" type="text" name="j_username" placeholder="<fmt:message key="labelLogin" />" size="20"/><br>
        <label class="label"><fmt:message key="labelPass" /></label><br>
        <input class="input" type="password" name="j_password" size="20" placeholder="<fmt:message key="labelPass" />"/><br>
        <input class="button" type="submit" value="Ввод"/>
    </form>
</div>
</body>
</html>


