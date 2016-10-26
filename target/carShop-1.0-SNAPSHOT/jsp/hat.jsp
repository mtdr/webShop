<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 25.10.2016
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
        </ul></div>
        <div id="search-row"><form action="search" method="GET" accept-charset="windows-1251"><input type="search" placeholder="<%=res.getString("hintMessage")%>" name="search-req">
            <button class="search-button"><a href="/"><img src="../img/search.png" alt="search"></a></button> </form>
        </div>
        <div class="service-buttons">
            <%--<a href="?lang=<%=request.getParameter("lang")%>"></a>--%>
            <form action="#" method="get" class="hat-form">
                <button type="submit" class="hat-button" onclick="alert('signIN')"><%=res.getString("signIn")%></button>
            </form>
            <form action="#" class="hat-form">
                <button type="submit" name="history-button" class="hat-button" onclick="alert('history')"><%=res.getString("history")%></button>
            </form>
            <form action="#" class="hat-form-box">
                <button type="submit" name="box-button" onclick="alert('Корзина')"><img src="../img/shoppingbag.png" alt="bag"></button>
            </form>

        </div>
        <div id="languages">
            <ul id="language-panel">
                <li class="small-pic"><a href="?lang=ru" ><img id="rus" src="../img/rus.png" alt="Russian"></a></li>
                <li class="small-pic"><a href="?lang=en" ><img id="eng" src="../img/eng.png" alt="English"></a></li>
                <li class="small-pic"><a href="?lang=de" ><img id="de" src="../img/de.png" alt="Deutsch"></a></li>
            </ul>
        </div>
    </header>
</body>
</html>
