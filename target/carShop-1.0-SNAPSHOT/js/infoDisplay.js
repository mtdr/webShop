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

function addCookie(l) {
    document.cookie="lang="+l;
}
