package com.servlets;

import com.beans.beanCar.AdList;
import com.beans.beanShopBasket.SBList;
import com.beans.beanUser.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

@javax.servlet.annotation.WebServlet(name = "cardServlet", urlPatterns = {"/w"})
public class cardServlet extends HttpServlet {
    private String first;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        first = config.getInitParameter("first");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String lang = request.getParameter("lang");
        String page = request.getParameter("page");
        if ("account".equals(page)) {
            String accountTab = first;
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/account.jsp?lang="+lang+"&accT="+ accountTab);
            dispatcher.forward(request,response);
        }
        int id = Integer.parseInt(request.getParameter("id"));

        // cookies
        Cookie[] cookies = request.getCookies();


        if(lang == null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("lang".equals(cookies[i].getName())) {
                    lang = cookies[i].getValue();
                    break;
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


        // session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String idServlet;
        String log;
        String userName;

        if (user.getName() == null) {
            idServlet = "auth";
            log = "signIn";
            userName = "";
        } else {
            idServlet = "logout";
            log = "logOut";
            userName = user.getName();
        }

        ResourceBundle rb = ResourceBundle.getBundle("shop", locale);

        PrintWriter out = response.getWriter();
        String pageTitle = rb.getString("pageTitle");
        String hintMessage = rb.getString("hintMessage");
        String fotoTitle = rb.getString("fotoTitle");
        String currency = rb.getString("currency");
        String buyButton = rb.getString("buyButton");
//        String carTitle = rb.getString("carTitle");
//        String price = rb.getString("price");
//        String owner = rb.getString("owner");

        String shortInfo = rb.getString("shortInfo");
        String detailsInfo = rb.getString("detailsInfo");
        String reviews = rb.getString("reviews");


        String fotoDescription1 = rb.getString("fotoDescription1");
        String fotoDescription2 = rb.getString("fotoDescription2");
        String fotoDescription3 = rb.getString("fotoDescription3");
        String fotoDescription4 = rb.getString("fotoDescription4");

        String yearIss = rb.getString("yearIss");
        String mileage = rb.getString("mileage");
        String body = rb.getString("body");
        String carColour = rb.getString("carColour");
        String transmission = rb.getString("transmission");
        String engine = rb.getString("engine");
        String wheel = rb.getString("wheel");
        String numOfOwners = rb.getString("numOfOwners");
        String PTS = rb.getString("PTS");

//        String yearIssInfo = rb.getString(AdList.getAdList().get(id).getYear());
//        String mileageInfo = rb.getString(AdList.getAdList().get(id).getMileage());
//        String bodyInfo = rb.getString(AdList.getAdList().get(id).getCarType());
//        String carColourInfo = rb.getString(AdList.getAdList().get(id).getColour());
//        String transmissionInfo = rb.getString(AdList.getAdList().get(id).getTransmission());
//        String engineInfoV = rb.getString(AdList.getAdList().get(id).getEngineV());
//        String engineInfoPower = rb.getString(AdList.getAdList().get(id).getEnginePower());
//        String engineInfoFuel = rb.getString(AdList.getAdList().get(id).getEngineFuel());
//        String wheelInfo = rb.getString(AdList.getAdList().get(id).getWheel());
//        String numOfOwnersInfo = rb.getString(AdList.getAdList().get(id).getNumOfOwners());
//        String PTSInfo = rb.getString(AdList.getAdList().get(id).getPTS());
//
//        String carTitle = rb.getString(AdList.getAdList().get(id).getTitle());
//        String price = rb.getString(AdList.getAdList().get(id).getPrice());
//        String owner = rb.getString(AdList.getAdList().get(id).getOwner());

        String yearIssInfo = AdList.getAdList().get(id).getYear();
        String mileageInfo = AdList.getAdList().get(id).getMileage();
        String bodyInfo = AdList.getAdList().get(id).getCarType();
        String carColourInfo = AdList.getAdList().get(id).getColour();
        String transmissionInfo = AdList.getAdList().get(id).getTransmission();
        String engineInfoV = AdList.getAdList().get(id).getEngineV();
        String engineInfoPower = AdList.getAdList().get(id).getEnginePower();
        String engineInfoFuel = AdList.getAdList().get(id).getEngineFuel();
        String wheelInfo = AdList.getAdList().get(id).getWheel();
        String numOfOwnersInfo = AdList.getAdList().get(id).getNumOfOwners();
        String PTSInfo = AdList.getAdList().get(id).getPTS();

        String carTitle = AdList.getAdList().get(id).getTitle();
        int price = AdList.getAdList().get(id).getPrice();
        String owner = AdList.getAdList().get(id).getOwner();

        String reviewerName1 = rb.getString("reviewerName1");
        String reviewerText1 = rb.getString("reviewerText1");
        String reviewerName2 = rb.getString("reviewerName2");
        String reviewerText2 = rb.getString("reviewerText2");

        String signIn = rb.getString("signIn");
        String history = rb.getString("history");

        int firstPar;
        firstPar = Integer.parseInt(first);
        out.println("<%--\n" +
                "  Created by IntelliJ IDEA.\n" +
                "  User: FlipBook TP300LD\n" +
                "  Date: 19.09.2016\n" +
                "  Time: 0:12\n" +
                "  To change this template use File | Settings | File Templates.\n" +
                "--%>\n" +
                "<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %>\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>"+ pageTitle +"</title>\n" +
                "    <link rel=\"stylesheet\" href=\"../../../../css/styles1.css\">\n" +
                "        <script src=\"../../../../js/infoDisplay.js\"></script>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"wrapper\">\n" +
                "    <header id=\"header\">\n" +
                "        <div id=\"logo\"><a href=\"/\"><img src=\"./img/car.png\" alt=\"Logo\"></a></div>\n" +
                "        <div id=\"nav-div\"><ul class=\"navigation-ul\" id=\"navigation-list\">\n" +
                "            <li class=\"nav\"><a href=\"/\" >First</a></li>\n" +
                "            <li class=\"nav\"><a href=\"/\" >Second</a></li>\n" +
                "            <li class=\"nav\">\n" +
                "                <a href=\"#\" class=\"dropbtn\">Dropdown</a>\n" +
                "                <div class=\"dropdown-content\">\n" +
                "                    <a href=\"#\">Link 1</a>\n" +
                "                    <a href=\"#\">Link 2</a>\n" +
                "                    <a href=\"#\">Link 3</a>\n" +
                "                </div>\n" +
                "            </li>\n" +
                "        </ul></div>\n" +
                "        <div id=\"search-row\"><form action=\"search\" method=\"GET\" name=\"search-req\" accept-charset=\"windows-1251\"><input type=\"search\" placeholder=\""+ hintMessage +"\" name=\"search-req\">\n" +
                "            <button class=\"search-button\"><a href=\"/\"><img src=\"./img/search.png\" alt=\"search\"></a></button> </form>\n" +
                "        </div>\n" +
                "<div class=\"service-buttons\">\n" +
                "\n" +
                "                   <a href=\"w?page=account&lang="+lang+"\" class=\"hat-button\">" + userName + "</a>\n" +
                        "<a href=\"/"+idServlet+"?page=w&id="+id+"&lang="+lang+"\" class=\"hat-button\">"+rb.getString(log)+"</a>\n"+
//                "            <form action=\"/" + idServlet + "?page=w&id=" + id + "&lang="+lang+"\" class=\"hat-form\">\n" +
//                "                <button type=\"submit\" name=\"signin-button\" class=\"hat-button\">"+ signIn +"</button>\n" +
//                "            </form>\n" +
                "            <form action=\"#\" class=\"hat-form\">\n" +
                "                <button type=\"submit\" name=\"history-button\" class=\"hat-button\">"+ history +"</button>\n" +
                "            </form>\n" +
//                "            <form action=\"/jsp/sb.jsp\" class=\"hat-form-box\">\n" +
//                "                <button type=\"submit\" name=\"box-button\" onclick=\"alert('Корзина')\"><img src=\"./img/shoppingbag.png\" alt=\"bag\"></button>\n" +
//                "            </form>\n" +
                "                   <a href=\"/jsp/sb.jsp\" ><img src=\"../../../../img/shoppingbag.png\"></a>\n" +
                "                   <p id=\"productsInBasket\">" + SBList.getSize() + "</p>\n" +
                "\n" +
                "        </div>" +
                "        <div id=\"languages\">\n" +
                "            <ul class=\"language-ul\" id=\"language-panel\">\n" +
                "                <li class=\"small-pic\"><a href=\"w?id="+ id +"&lang=ru\" ><img id=\"rus\" src=\"./img/rus.png\" alt=\"Russian\"></a></li>\n" +
                "                <li class=\"small-pic\"><a href=\"w?id="+ id +"&lang=en\" ><img id=\"eng\" src=\"./img/eng.png\" alt=\"English\"></a></li>\n" +
                "                <li class=\"small-pic\"><a href=\"w?id="+ id +"&lang=de\" ><img id=\"de\" src=\"./img/de.png\" alt=\"Deutsch\"></a></li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </header>\n" +
                "    <div id=\"content\">\n" +
                "        <div id=\"photo-div\">\n" +
                "            <p id=\"large-text\">"+ fotoTitle +"</p>\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/"+ AdList.getAdList().get(id).getFoto1() + "\" alt=\"1\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/" + AdList.getAdList().get(id).getFoto1() +"\" alt=\"1\">\n" +
                "                    <div class=\"desc\">"+fotoDescription1+"</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/"+AdList.getAdList().get(id).getFoto2()+"\" alt=\"Forward\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/"+ AdList.getAdList().get(id).getFoto2() +"\" alt=\"Forward\">\n" +
                "                    <div class=\"desc\">"+fotoDescription2+"</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/"+ AdList.getAdList().get(id).getFoto3() +"\" alt=\"Forward\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/" + AdList.getAdList().get(id).getFoto3() + "\" alt=\"Forward\">\n" +
                "                    <div class=\"desc\">"+fotoDescription3+"</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/"+AdList.getAdList().get(id).getFoto4()+"\" alt=\"Forward\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/"+ AdList.getAdList().get(id).getFoto4() +"\" alt=\"Forward\">\n" +
                "                    <div class=\"desc\">"+fotoDescription4+"</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "\n" +
                "        </div>\n" +
                "\n" +
                "        <div id=\"all-info\">\n" +
                "            <div id=\"buy-block\">\n" +
                "                <div id=\"car-title\"><h2>" + carTitle +"</h2></div>\n" +
                "                <div id=\"price\"><img src=\"./img/rouble.png\" alt=\"Rouble\"><p>"+ price + " "+ currency +"</p></div>\n" +
                "                <div id=\"owner\"><img src=\"./img/owner.png\" alt=\"Owner\"><p>"+ owner +"</p></div>\n" +
//                "                <div id=\"buy-button\"><button class=\"buy\" name=\"buy-car\" type=\"submit\" value=\"carId\">"+ buyButton +"</button></div>\n" +
                        "<form action=\"/sb\" method=\"post\">\n" +
                        "    <input type=\"image\" src=\"../img/buy.png\" width=\"auto\" height=\"64\" id=\"buy-button\" name=\"idServlet\" value=\""+id+"\">\n" +
                        "</form>" +
                "            </div>\n" +
                "            <div id=\"info-block\">\n" +
                "<!--START-->\n" +
                "<div class=\"tab-nav\">\n" +
                "    <ul class=\"nav-ul\">\n" +
                "        <li class=\"nav-li\" id=\"li1\" style=\"background-color:" + ((firstPar == 1) ? "#8B0000;" : "#FF0000;") + "\" onclick=\"show('1')\"><a href=\"#w\" id=\"li-a1\" class=\"tab-menu\">"+ shortInfo +"</a></li>\n" +
                "        <li class=\"nav-li\" id=\"li2\" style=\"background-color:" + ((firstPar == 2) ? "#8B0000;" : "#FF0000;") + "\" onclick=\"show('2')\"><a href=\"#w\" id=\"li-a2\" class=\"tab-menu\">"+ detailsInfo +"</a></li>\n" +
                "        <li class=\"nav-li\" id=\"li3\" style=\"background-color:" + ((firstPar == 3) ? "#8B0000;" : "#FF0000;") + "\" onclick=\"show('3')\"><a href=\"#w\" id=\"li-a3\" class=\"tab-menu\">"+ reviews +"</a></li>\n" +
                "    </ul>\n" +
                "    <div class=\"tab-content\">\n" +
                "        <div id=\"short\" class=\"tabs\" style=\"display:"+((firstPar == 1) ? "block;" : "none;") + "\">\n" +
                "            <ul class=\"info-ul\">\n" +
                "                <li class=\"info-li\">"+ yearIss + ": " + yearIssInfo + "</li>\n" +
                "                <li class=\"info-li\">"+ mileage + ": " + mileageInfo + "</li>\n" +
                "                <li class=\"info-li\">"+ body + ": " + bodyInfo + "</li>\n" +
                "                <li class=\"info-li\">"+ carColour + ": " + carColourInfo +"</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        <div id=\"detail\" class=\"tabs\" style=\"display:"+((firstPar == 2) ? "block;" : "none;") + "\">\n" +
                "            <ul class=\"info-ul\">\n" +
                "                <li class=\"info-li\">"+ yearIss + ": " + yearIssInfo + "</li>\n" +
                "                <li class=\"info-li\">"+ mileage + ": " + mileageInfo + "</li>\n" +
                "                <li class=\"info-li\">"+ body + ": " + bodyInfo + "</li>\n" +
                "                <li class=\"info-li\">"+ carColour + ": " + carColourInfo +"</li>\n" +
                "                <li class=\"info-li\">"+ transmission + ": " + transmissionInfo +"</li>\n" +
                "                <li class=\"info-li\">"+ engine + ": " + engineInfoV + " / " + engineInfoPower + " / " + engineInfoFuel +"</li>\n" +
                "                <li class=\"info-li\">"+ wheel + ": " + " " + wheelInfo + "</li>\n" +
                "                <li class=\"info-li\">"+ PTS + ": " + PTSInfo+"</li>\n" +
                "                <li class=\"info-li\">"+ numOfOwners + ": " + numOfOwnersInfo+"</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        <div id=\"reviews\" class=\"tabs\" style=\"display:"+((firstPar == 3) ? "block;" : "none;") + "\">\n" +
                "            <ul class=\"reviews-ul\">\n" +
                "                <li><b>"+reviewerName1+"</b> " +reviewerText1+"</li>\n" +
                "                <li><b>"+reviewerName2+"</b> "+reviewerText2+"</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "</div>\n" +
                "<!--END-->\n" +
                "\n" +
                "            </div>\n" +
                "\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");

        out.flush();

        out.close();
out.println("<form action=\"/sb\" method=\"post\">\n" +
        "    <input type=\"image\" src=\"../img/buy.png\" width=\"64\" height=\"64\" id=\"buy-button-card\" name=\"idServlet\" value=\"id\">\n" +
        "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("windows-1251");
        resp.setCharacterEncoding("windows-1251");
        processRequest(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("windows-1251");
        response.setCharacterEncoding("windows-1251");
        processRequest(request,response);
    }
}
