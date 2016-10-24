<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 16.10.2016
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<html>
<head>
    <title>panel</title>
    <link rel="stylesheet" href="css/style-panel.css">

</head>
<body>
<div class="tab-nav">
    <ul class="nav-ul">
        <li class="nav-li"><a href="#" id="li-a1" class="tab-menu">Кратко</a></li>
        <li class="nav-li"><a href="#" id="li-a2" class="tab-menu">Подробно</a></li>
        <li class="nav-li"><a href="#" id="li-a3" class="tab-menu">Отзывы</a></li>
    </ul>
    <div class="tab-content">
        <div id="short">
            <ul class="info-ul">
                <li class="info-li">Год выпуска: 2016</li>
                <li class="info-li">Пробег: 45 000 км</li>
                <li class="info-li">Кузов: седан</li>
                <li class="info-li">Цвет: баклажан</li>
            </ul>
        </div>
        <div id="detail">
            <ul class="info-ul">
                <li class="info-li">Год выпуска: 2016</li>
                <li class="info-li">Пробег: 45 000 км</li>
                <li class="info-li">Кузов: седан</li>
                <li class="info-li">Цвет: баклажан</li>
                <li class="info-li">Коробка: автоматическая</li>
                <li class="info-li">Двигатель: 1.6 / 105 л.с. / бензин</li>
                <li class="info-li">Руль: левый</li>
                <li class="info-li">ПТС: оригинал</li>
                <li class="info-li">Количество владельцев: 2</li>
            </ul>
        </div>
        <div id="reviews">
            <ul class="reviews-ul">
                <li><b>Владимир</b> Очень хорошо</li>
                <li><b>Владимир</b> Очень плохо</li>
            </ul>
        </div>

    </div>
</div>

</body>
</html>
