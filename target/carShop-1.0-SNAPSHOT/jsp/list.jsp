<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="com.beans.beanCar.AdList" %>
<%@ page import="com.beans.beanCar.Ad" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.dao.HibernateSessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.entity.AdsEntity" %>
<%@ taglib prefix="m" uri="/WEB-INF/tld/tag1.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/styles1.css">
    <script src="../js/infoDisplay.js"></script>

    <%
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String lang = request.getParameter("lang");
        String carType = request.getParameter("carType");

        Cookie[] cookies = request.getCookies();
        if(lang == null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("lang".equals(cookies[i].getName())) {
                    lang = cookies[i].getValue();
                }
            }
        }
        Locale locale;
        if ("en_GB".equals(lang)) {
            locale = new Locale("en", "GB");
        } else if ("ru_RU".equals(lang)) {
            locale = Locale.getDefault();
        } else if ("de_DE".equals(lang)) {
            locale = new Locale("de", "DE");
        } else {
            locale = Locale.getDefault();
        }
        Cookie cookie1 = new Cookie("lang", lang);
        response.addCookie(cookie1);
        // cookie expire
        int expiry = 120;


        ResourceBundle res = ResourceBundle.getBundle("shop", locale);

        AdList.deleteList();
//        AdList.addElem(new Ad("sedan", "Audi A8",500000,"Peter","2012",
//                "120.000","White","Dsg","petrol","400","3.5","left side","2","original",
//                "car1/1.jpg","car1/2.jpg","car1/3.jpg","car1/4.jpg"));
//        AdList.addElem(new Ad("sedan", "BMW M5",700000,"Andrew","2010",
//                "110.000","White","auto","petrol","600","4.5","left side","1","original",
//                "car2/1.jpg","car2/2.jpg","car2/3.jpg","car2/4.jpg"));
//        AdList.addElem(new Ad("suv", "Audi Q3",300000,"Max","2012",
//                "12.000","White","Dsg","petrol","150","2.5","left side","1","original",
//                "car3/1.jpg","car3/2.jpg","car3/3.jpg","car3/4.jpg"));
//        AdList.addElem(new Ad("suv", "BMW X3",450000,"Толик","2012",
//                "120.000","Белый","Автомат","АИ-98","400","5.5","Левый","2","Оригинал",
//                "car4/1.jpg","car4/2.jpg","car4/3.jpg","car4/4.jpg"));
//        AdList.addElem(new Ad("coupe", "Toyota Mark",100000,"Jo Hi Man","1996",
//                "700.000","White","Dsg","petrol","270","3.5","right side","2","original",
//                "car5/1.jpg","car5/2.jpg","car5/3.jpg","car5/4.jpg"));

//        AdList.addElem(new Ad("sedan", "1_title","1_price","1_owner","1_year",
//                "1_mileage","1_colour","1_transmission","1_fuel","1_power","1_v","1_wheel","1_nos","1_pts",
//                "car1/1.jpg","car1/2.jpg","car1/3.jpg","car1/4.jpg"));
//        AdList.addElem(new Ad("sedan", "2_title","2_price","2_owner","2_year",
//                "2_mileage","2_colour","1_transmission","1_fuel","2_power","2_v","1_wheel","1_nos","1_pts",
//                "car2/1.jpg","car2/2.jpg","car2/3.jpg","car2/4.jpg"));
//        AdList.addElem(new Ad("suv", "3_title","3_price","3_owner","3_year",
//                "3_mileage","3_colour","1_transmission","1_fuel","3_power","3_v","1_wheel","1_nos","1_pts",
//                "car3/1.jpg","car3/2.jpg","car3/3.jpg","car3/4.jpg"));
//        AdList.addElem(new Ad("suv", "4_title","4_price","4_owner","4_year",
//                "4_mileage","4_colour","1_transmission","1_fuel","4_power","4_v","1_wheel","1_nos","1_pts",
//                "car4/1.jpg","car4/2.jpg","car4/3.jpg","car4/4.jpg"));
//        AdList.addElem(new Ad("coupe", "5_title","5_price","5_owner","5_year",
//                "5_mileage","5_colour","1_transmission","1_fuel","5_power","5_v","1_wheel","1_nos","1_pts",
//                "car5/1.jpg","car5/2.jpg","car5/3.jpg","car5/4.jpg"));
        Session Hsession = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = Hsession.beginTransaction();
        List list = Hsession.createQuery("FROM AdsEntity").list();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            AdsEntity cur = (AdsEntity) iterator.next();
            AdList.addElem(new Ad(cur.getCarType(),cur.getTitle(),cur.getPrice(),cur.getOwner(),cur.getYear(),
                    cur.getMileage(), cur.getColour(),cur.getTransmission(),cur.getEngineFuel(),cur.getEnginePower(),
                    cur.getEngineV(), cur.getWheel(),cur.getNumOfOwners(),cur.getPts(),cur.getFoto1(),cur.getFoto2(),
                    cur.getFoto3(), cur.getFoto4()));
        }
        tx.commit();
        Hsession.close();

        ArrayList<Ad> adList1 = AdList.getAdList();
    %>
    <title><%=res.getString("pageTitle")%></title>
    <jsp:useBean id="adId" class="com.beans.beanCar.Ad" scope="page"/>
    <jsp:useBean id="basket" class="com.beans.beanShopBasket.SBList" scope="session" />


</head>
<body>
<div id="wrapper-list">
    <%@include file="hat.jsp" %>
    <div class="main-div">
        <div class="miniature">
            <div class="filter" id="t">
                <select name="selectName" onchange="setCarType();">
                    <option value='val'><%=res.getString("select")%>
                    </option>
                    <option value='all'><%=res.getString("all")%>
                    </option>
                    <option value='sedan'><%=res.getString("sedan")%>
                    </option>
                    <option value='suv'><%=res.getString("suv")%>
                    </option>
                    <option value='coupe'><%=res.getString("coupe")%>
                    </option>
                </select>

            </div>
            <%
                if (carType == null) {
                    if (cookies == null) {
                        carType = "all";
                        Cookie cookie = new Cookie("carType", carType);
                        response.addCookie(cookie);
                    } else {
                        for (int i = 0; i < cookies.length; i++) {
                            if ("carType".equals(cookies[i].getName())) {
                                carType = cookies[i].getValue();
                                break;
                            }
                        }
                        if (carType == null) {
                            carType = "all";
                            Cookie cookie = new Cookie("carType", carType);
                            cookie.setMaxAge(expiry);
                            response.addCookie(cookie);
                        }
                    }
                } else {
                    Cookie cookie = new Cookie("carType", carType);
                    cookie.setMaxAge(expiry);
                    response.addCookie(cookie);
                }
            %>
            <h2><%=res.getString(carType)%></h2>
            <%
                if (carType != null) {
                    switch (carType) {
                        case "sedan":
                            for (int i = 0; i < adList1.size(); i++) {
                                if (adList1.get(i).getCarType().equals("sedan")) {
//                                    adId.setTitle(res.getString(adList1.get(i).getTitle()));
//                                    adId.setId(adList1.get(i).getId());
//                                    adId.setYear(res.getString(adList1.get(i).getYear()));
//                                    adId.setMileage(res.getString(adList1.get(i).getMileage()));
//                                    adId.setColour(res.getString(adList1.get(i).getColour()));
//                                    adId.setPrice(res.getString(adList1.get(i).getPrice()));
//                                    adId.setCarType(res.getString(adList1.get(i).getCarType()));

                                    adId.setTitle(adList1.get(i).getTitle());
                                    adId.setId(adList1.get(i).getId());
                                    adId.setYear(adList1.get(i).getYear());
                                    adId.setMileage(adList1.get(i).getMileage());
                                    adId.setColour(adList1.get(i).getColour());
                                    adId.setPrice(adList1.get(i).getPrice());
                                    adId.setCarType(adList1.get(i).getCarType());

                                    adId.setFoto1(adList1.get(i).getFoto1());
            %>
            <%@include file="model.jsp" %>
            <%
                        }
                    }
                    break;
                case "suv":
                    for (int i = 0; i < adList1.size(); i++) {
                        if (adList1.get(i).getCarType().equals("suv")) {
                            adId.setTitle(adList1.get(i).getTitle());
                            adId.setId(adList1.get(i).getId());
                            adId.setYear(adList1.get(i).getYear());
                            adId.setMileage(adList1.get(i).getMileage());
                            adId.setColour(adList1.get(i).getColour());
                            adId.setPrice(adList1.get(i).getPrice());
                            adId.setCarType(adList1.get(i).getCarType());

                            adId.setFoto1(adList1.get(i).getFoto1());
            %>
            <%@include file="model.jsp" %>
            <%
                        }
                    }
                    break;
                case "coupe":
                    for (int i = 0; i < adList1.size(); i++) {
                        if (adList1.get(i).getCarType().equals("coupe")) {
                            adId.setTitle(adList1.get(i).getTitle());
                            adId.setId(adList1.get(i).getId());
                            adId.setYear(adList1.get(i).getYear());
                            adId.setMileage(adList1.get(i).getMileage());
                            adId.setColour(adList1.get(i).getColour());
                            adId.setPrice(adList1.get(i).getPrice());
                            adId.setCarType(adList1.get(i).getCarType());

                            adId.setFoto1(adList1.get(i).getFoto1());
            %>
            <%@include file="model.jsp" %>
            <%
                        }
                    }
                    break;
                case "all":
                    for (int i = 0; i < adList1.size(); i++) {
                        adId.setTitle(adList1.get(i).getTitle());
                        adId.setId(adList1.get(i).getId());
                        adId.setYear(adList1.get(i).getYear());
                        adId.setMileage(adList1.get(i).getMileage());
                        adId.setColour(adList1.get(i).getColour());
                        adId.setPrice(adList1.get(i).getPrice());
                        adId.setCarType(adList1.get(i).getCarType());

                        adId.setFoto1(adList1.get(i).getFoto1());
            %>
            <%@include file="model.jsp" %>
            <%
                    }
                    break;
                default:
                    for (int i = 0; i < adList1.size(); i++) {
                        adId.setTitle(adList1.get(i).getTitle());
                        adId.setId(adList1.get(i).getId());
                        adId.setYear(adList1.get(i).getYear());
                        adId.setMileage(adList1.get(i).getMileage());
                        adId.setColour(adList1.get(i).getColour());
                        adId.setPrice(adList1.get(i).getPrice());
                        adId.setCarType(adList1.get(i).getCarType());

                        adId.setFoto1(adList1.get(i).getFoto1());
            %>
            <%@include file="model.jsp" %>
            <%
                            }
                            break;
                    }
                }
            %>
        </div>

    </div>
</div>

</body>
</html>
