<%--
  Created by IntelliJ IDEA.
  User: FlipBook TP300LD
  Date: 19.09.2016
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Главная</title>
    <link rel="stylesheet" href="css/styles1.css">
    <script src="js/infoDisplay.js"></script>

</head>
<body>
<div id="wrapper">
    <header id="header">
        <div id="logo"><a href="/"><img src="img/car.png" alt="Logo"></a></div>
        <div id="nav-div"><ul id="navigation-list">
            <li class="nav"><a href="/" >First</a></li>
            <li class="nav"><a href="/" >Second</a></li>
            <li class="nav">
                <a href="#" class="dropbtn">Dropdown</a>
                <div class="dropdown-content">
                    <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>
                </div>
            </li>
        </ul></div>
        <div id="search-row"><form action="" method="GET"><input type="search" placeholder="Введите название авто" name="search-req">
            <button class="search-button"><a href="/"><img src="img/search.png" alt="search"></a></button> </form>
        </div>
        <div class="service-buttons">

            <form action="#" class="hat-form">
                <button type="submit" name="signin-button" class="hat-button">ВХОД</button>
            </form>
            <form action="#" class="hat-form">
                <button type="submit" name="history-button" class="hat-button">ИСТОРИЯ</button>
            </form>
            <form action="#" class="hat-form-box">
                <button type="submit" name="box-button" onclick="alert('Корзина')"><img src="img/shoppingbag.png" alt="bag"></button>
            </form>

        </div>
        <div id="languages">
            <ul id="language-panel">
                <li class="small-pic"><a href="/" ><img id="rus" src="img/rus.png" alt="Russian"></a></li>
                <li class="small-pic"><a href="/" ><img id="eng" src="img/eng.png" alt="English"></a></li>
                <li class="small-pic"><a href="/" ><img id="de" src="img/de.png" alt="Deutsch"></a></li>
            </ul>
        </div>
    </header>
    <div id="content">
        <div id="photo-div">
            <p id="large-text">Фотографии</p>
            <div class="dropdown-photo">
                <img src="img/img_fjords.jpg" alt="Trolltunga Norway">
                <div class="dropdown-photo-content">
                    <img src="img/img_fjords.jpg" alt="Trolltunga Norway">
                    <div class="desc">Beautiful Trolltunga, Norway</div>
                </div>
            </div>

            <div class="dropdown-photo">
                <img src="img/car1/2.jpg" alt="Forward">
                <div class="dropdown-photo-content">
                    <img src="img/car1/2.jpg" alt="Forward">
                    <div class="desc">Beautiful Trolltunga, Norway</div>
                </div>
            </div>

            <div class="dropdown-photo">
                <img src="img/car1/3.jpg" alt="Forward">
                <div class="dropdown-photo-content">
                    <img src="img/car1/3.jpg" alt="Forward">
                    <div class="desc">Beautiful Trolltunga, Norway</div>
                </div>
            </div>

            <div class="dropdown-photo">
                <img src="img/car1/4.jpg" alt="Forward">
                <div class="dropdown-photo-content">
                    <img src="img/car1/4.jpg" alt="Forward">
                    <div class="desc">Beautiful Trolltunga, Norway</div>
                </div>
            </div>


        </div>

        <div id="all-info">
            <div id="buy-block">
                <div id="car-title"><h2>Самая хорошая машина</h2></div>
                <div id="price"><img src="img/rouble.png" alt="Rouble"><p>500 рублей</p></div>
                <div id="owner"><img src="img/owner.png" alt="Owner"><p>Вася Пупкин</p></div>
                <div id="buy-button"><button class="buy" name="buy-car" type="submit" value="carId">Купить</button></div>
            </div>
            <div id="info-block">
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
            </div>

        </div>

    </div>
</div>


</body>
</html>
