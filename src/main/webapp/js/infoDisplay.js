function show(par) {
    var elem = document.getElementsByClassName('nav-li');
    for (i = 0; i < elem.length; i++) {
        elem[i].style.backgroundColor = '#FF0000';
    }
    var elem1 = document.getElementsByClassName('tabs');
    for (i = 0; i < elem1.length; i++) {
        elem1[i].style.display = 'none';
    }
    console.log(par);
    switch (par) {
        case '1':
            document.getElementById('short').style.display='block';
            document.getElementById('li1').style.backgroundColor='#8B0000';
            break;
        case '2':
            document.getElementById('detail').style.display='block';
            document.getElementById('li2').style.backgroundColor='#8B0000';
            break;
        case '3':
            document.getElementById('reviews').style.display='block';
            document.getElementById('li3').style.backgroundColor='#8B0000';
            break;
    }
}

function setCarType() {
    var value = document.getElementsByTagName('select')[0].value;
    window.location='?carType=' + value;
}

function orderShow(par) {
    var elem = document.getElementsByClassName('choice-order');
    for (i = 0; i < elem.length; i++) {
        elem[i].style.backgroundColor = '#F5736D';
    }
    var elem1 = document.getElementsByClassName('specification1');
    for (i = 0; i < elem1.length; i++) {
        elem1[i].style.display = 'none';
    }
    switch (par) {
        case '1':
            document.getElementById('pickup').style.display = 'block';
            document.getElementById('navBarA1').style.backgroundColor = '#8B0000';
            break;
        case '2':
            document.getElementById('delivery').style.display = 'block';
            document.getElementById('navBarA2').style.backgroundColor = '#8B0000';
            break;
    }
}

function addCookie(l) {
    document.cookie="lang="+l;
}
function initialize(coordX, coordY, address, shop, id) {
    var myLatlng = new google.maps.LatLng(59.970960891326854, 30.319606160730018);
    var myOptions = {
        zoom: 10,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    for (var i = 0; i < address.length; i++) {
        mark(coordX[i], coordY[i], address[i], shop[i], map, id[i]);
    }
}
function mark(coordX, coordY, address, shop, map, id) {
    var contentString = '<div id="content"><p>' + shop + '</p><br><p>' + address + '</p></div>';ads
    var infowindow = new google.maps.InfoWindow({
        content: contentString
    });
    var marker = new google.maps.Marker({
        position: new google.maps.LatLng(coordX, coordY),
        map: map,
        title: shop
    });
    var onchange = function () {
        map.setCenter(new google.maps.LatLng(coordX, coordY));
        map.setZoom(15);
    };
    google.maps.event.addListener(marker, 'click', function () {
        var elem1 = document.getElementById('radio' + id);
        elem1.checked = true;
        infowindow.open(map, marker);
    });
    var radio = document.getElementById('radio' + id);
    radio.addEventListener("change", function () {
        onchange();
    });
}
function loadXMLDoc() {
    var xmlhttp;
    var elem = document.getElementById('comment').value;
    if (window.XMLHttpRequest)
        xmlhttp = new XMLHttpRequest();
    else
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            document.getElementById("list-of-comments").innerHTML = xmlhttp.responseText;
    };
    xmlhttp.open("GET", "/comments?comment=" + elem, true);
    xmlhttp.send();
}
function myTimer(lang) {
    var now = new Date();
    var now1;
    var options = {
        // era: 'long',
        year: 'numeric',
        month: 'numeric',
        day: 'numeric',
        weekday: 'long',
        timezone: 'UTC',
        hour: 'numeric',
        minute: 'numeric',
        second: 'numeric'
    };
    switch (lang) {
        case 'ru_RU':
            now1 = new Intl.DateTimeFormat("ru", options);
            break;
        case 'en_GB':
            now1 = new Intl.DateTimeFormat("en-GB", options);
            break;
        case 'de_DE':
            now1 = new Intl.DateTimeFormat("de-DE", options);
            break;
        default:
            now1 = new Intl.DateTimeFormat("ru", options);
            break;
    }
    var date = document.getElementById('current-time');
    date.innerHTML = '<p>' + now1.format(now) + '</p>';
}
