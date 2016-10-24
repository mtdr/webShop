package net.servlets;

/**
 * Created by FlipBook TP300LD on 22.10.2016.
 */
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("windows-1251");
        response.setContentType("text/html; charset=windows-1251");
        response.setCharacterEncoding("windows-1251");

        String lang = request.getParameter("lang");

//         title = request.getParameter("title");
//         owner = request.getParameter("owner");
//         price = request.getParameter("price");
//         imgRep = request.getParameter("imgRep");
        Locale locale;
        if("en".equals(lang)) {
            locale = new Locale("en", "GB");
        } else if ("ru".equals(lang)) {
            locale = Locale.getDefault();
        } else if ("de".equals(lang)) {
            locale=new Locale("de", "DE");
        } else {
            locale = Locale.getDefault();
        }
        ResourceBundle rb = ResourceBundle.getBundle("shop", locale);
////        StringBuilder sb = new StringBuilder();
//
////        if (request instanceof HttpServletRequest) {
//        String queryString = request.getQueryString();
//        System.out.println(queryString);
//
//        System.out.println(request.getServletPath());
        PrintWriter out = response.getWriter();
        String pageTitle = rb.getString("pageTitle");
        String hintMessage = rb.getString("hintMessage");
        String fotoTitle = rb.getString("fotoTitle");
        String currency = rb.getString("currency");
        String buyButton = rb.getString("buyButton");
        String carTitle = rb.getString("carTitle");
        String price = rb.getString("price");
        String owner = rb.getString("owner");

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

        String yearIssInfo = rb.getString("yearIssInfo");
        String mileageInfo = rb.getString("mileageInfo");
        String bodyInfo = rb.getString("bodyInfo");
        String carColourInfo = rb.getString("carColourInfo");
        String transmissionInfo = rb.getString("transmissionInfo");
        String engineInfoV = rb.getString("engineInfoV");
        String engineInfoPower = rb.getString("engineInfoPower");
        String engineInfoFuel = rb.getString("engineInfoFuel");
        String wheelInfo = rb.getString("wheelInfo");
        String numOfOwnersInfo = rb.getString("numOfOwnersInfo");
        String PTSInfo = rb.getString("PTSInfo");

        String reviewerName1 = rb.getString("reviewerName1");
        String reviewerText1 = rb.getString("reviewerText1");
        String reviewerName2 = rb.getString("reviewerName2");
        String reviewerText2 = rb.getString("reviewerText2");

        int firstPar;
        firstPar = Integer.parseInt(first);
        out.println("<%--\n" +
                "  Created by IntelliJ IDEA.\n" +
                "  User: FlipBook TP300LD\n" +
                "  Date: 19.09.2016\n" +
                "  Time: 0:12\n" +
                "  To change this template use File | Settings | File Templates.\n" +
                "--%>\n" +
                "<%@ page contentType=\"text/html;charset=windows-1251\" language=\"java\" %>\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>"+ pageTitle +"</title>\n" +
                "    <link rel=\"stylesheet\" href=\"../../../../css/styles.css\">\n" +
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
                "        <div id=\"languages\">\n" +
                "            <ul class=\"language-ul\" id=\"language-panel\">\n" +
                "                <li class=\"small-pic\"><a href=\"w?lang=ru\" ><img id=\"rus\" src=\"./img/rus.png\" alt=\"Russian\"></a></li>\n" +
                "                <li class=\"small-pic\"><a href=\"w?lang=en\" ><img id=\"eng\" src=\"./img/eng.png\" alt=\"English\"></a></li>\n" +
                "                <li class=\"small-pic\"><a href=\"w?lang=de\" ><img id=\"de\" src=\"./img/de.png\" alt=\"Deutsch\"></a></li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </header>\n" +
                "    <div id=\"content\">\n" +
                "        <div id=\"photo-div\">\n" +
                "            <p id=\"large-text\">"+ fotoTitle +"</p>\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/car1/1.jpg\" alt=\"1\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/car1/1.jpg\" alt=\"1\">\n" +
                "                    <div class=\"desc\">"+fotoDescription1+"</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/car1/2.jpg\" alt=\"Forward\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/car1/2.jpg\" alt=\"Forward\">\n" +
                "                    <div class=\"desc\">"+fotoDescription2+"</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/car1/3.jpg\" alt=\"Forward\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/car1/3.jpg\" alt=\"Forward\">\n" +
                "                    <div class=\"desc\">"+fotoDescription3+"</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"dropdown-photo\">\n" +
                "                <img src=\"./img/car1/4.jpg\" alt=\"Forward\">\n" +
                "                <div class=\"dropdown-photo-content\">\n" +
                "                    <img src=\"./img/car1/4.jpg\" alt=\"Forward\">\n" +
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
                "                <div id=\"buy-button\"><button class=\"buy\" name=\"buy-car\" type=\"submit\" value=\"carId\">"+ buyButton +"</button></div>\n" +
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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("wow!!!!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("windows-1251");
        response.setCharacterEncoding("windows-1251");
        processRequest(request,response);
//            request.setCharacterEncoding("windows-1251");
//            response.setContentType("text/html; charset=windows-1251");
//            String title = request.getParameter("title");
//            String owner = request.getParameter("owner");
//            String price = request.getParameter("price");
//            String imgRep = request.getParameter("imgRep");
//
//            System.out.println(title+owner+price);
//            PrintWriter out = response.getWriter();
////            out.println("<h3>Profile " + title + "</h3>");
////        c:/git/ServletLab/web/img/car1
//// ./img
//            out.println("<%--\n" +
//                    "  Created by IntelliJ IDEA.\n" +
//                    "  User: FlipBook TP300LD\n" +
//                    "  Date: 19.09.2016\n" +
//                    "  Time: 0:12\n" +
//                    "  To change this template use File | Settings | File Templates.\n" +
//                    "--%>\n" +
//                    "<%@ page contentType=\"text/html;charset=windows-1251\" language=\"java\" %>\n" +
//                    "<!DOCTYPE html>\n" +
//                    "<html>\n" +
//                    "<head>\n" +
//                    "    <title>Главная</title>\n" +
//                    "    <link rel=\"stylesheet\" href=\"../css/styles.css\">\n" +
//                    "\n" +
//                    "</head>\n" +
//                    "<body>\n" +
//                    "<div id=\"wrapper\">\n" +
//                    "    <header id=\"header\">\n" +
//                    "        <div id=\"logo\"><a href=\"/\"><img src=\"./img/car.png\" alt=\"Logo\"></a></div>\n" +
//                    "        <div id=\"nav-div\"><ul id=\"navigation-list\">\n" +
//                    "            <li class=\"nav\"><a href=\"/\" >First</a></li>\n" +
//                    "            <li class=\"nav\"><a href=\"/\" >Second</a></li>\n" +
//                    "            <li class=\"nav\">\n" +
//                    "                <a href=\"#\" class=\"dropbtn\">Dropdown</a>\n" +
//                    "                <div class=\"dropdown-content\">\n" +
//                    "                    <a href=\"#\">Link 1</a>\n" +
//                    "                    <a href=\"#\">Link 2</a>\n" +
//                    "                    <a href=\"#\">Link 3</a>\n" +
//                    "                </div>\n" +
//                    "            </li>\n" +
//                    "        </ul></div>\n" +
//                    "        <div id=\"search-row\"><form action=\"search\" method=\"GET\" name=\"search-req\" accept-charset=\"windows-1251\"><input type=\"search\" placeholder=\"Введите название авто\" name=\"search-req\">\n" +
//                    "            <button class=\"search-button\"><a href=\"/\"><img src=\"./img/search.png\" alt=\"search\"></a></button> </form>\n" +
//                    "        </div>\n" +
//                    "        <div id=\"languages\">\n" +
//                    "            <ul id=\"language-panel\">\n" +
//                    "                <li class=\"small-pic\"><a href=\"/\" ><img id=\"rus\" src=\"./img/rus.png\" alt=\"Russian\"></a></li>\n" +
//                    "                <li class=\"small-pic\"><a href=\"/\" ><img id=\"eng\" src=\"./img/eng.png\" alt=\"English\"></a></li>\n" +
//                    "                <li class=\"small-pic\"><a href=\"/\" ><img id=\"de\" src=\"./img/de.png\" alt=\"Deutsch\"></a></li>\n" +
//                    "            </ul>\n" +
//                    "        </div>\n" +
//                    "    </header>\n" +
//                    "    <div id=\"content\">\n" +
//                    "        <div id=\"photo-div\">\n" +
//                    "            <p id=\"large-text\">Фотографии</p>\n" +
//                    "            <div class=\"dropdown-photo\">\n" +
//                    "                <img src=\"./img/img_fjords.jpg\" alt=\"Trolltunga Norway\">\n" +
//                    "                <div class=\"dropdown-photo-content\">\n" +
//                    "                    <img src=\"./img/car1/1.jpg\" alt=\"Forward\">\n" +
//                    "                    <div class=\"desc\">Beautiful Trolltunga, Norway</div>\n" +
//                    "                </div>\n" +
//                    "            </div>\n" +
//                    "\n" +
//                    "            <div class=\"dropdown-photo\">\n" +
//                    "                <img src=\"./img/car1/2.jpg\" alt=\"Forward\">\n" +
//                    "                <div class=\"dropdown-photo-content\">\n" +
//                    "                    <img src=\"./img/car1/2.jpg\" alt=\"Forward\">\n" +
//                    "                    <div class=\"desc\">Beautiful Trolltunga, Norway</div>\n" +
//                    "                </div>\n" +
//                    "            </div>\n" +
//                    "\n" +
//                    "            <div class=\"dropdown-photo\">\n" +
//                    "                <img src=\"./img/car1/3.jpg\" alt=\"Forward\">\n" +
//                    "                <div class=\"dropdown-photo-content\">\n" +
//                    "                    <img src=\"./img/car1/3.jpg\" alt=\"Forward\">\n" +
//                    "                    <div class=\"desc\">Beautiful Trolltunga, Norway</div>\n" +
//                    "                </div>\n" +
//                    "            </div>\n" +
//                    "\n" +
//                    "            <div class=\"dropdown-photo\">\n" +
//                    "                <img src=\"./img/car1/4.jpg\" alt=\"Forward\">\n" +
//                    "                <div class=\"dropdown-photo-content\">\n" +
//                    "                    <img src=\"./img/car1/4.jpg\" alt=\"Forward\">\n" +
//                    "                    <div class=\"desc\">Beautiful Trolltunga, Norway</div>\n" +
//                    "                </div>\n" +
//                    "            </div>\n" +
//                    "\n" +
//                    "\n" +
//                    "        </div>\n" +
//                    "\n" +
//                    "        <div id=\"all-info\">\n" +
//                    "            <div id=\"buy-block\">\n" +
//                    "                <div id=\"car-title\"><h2>" + title +"</h2></div>\n" +
//                    "                <div id=\"price\"><img src=\"./img/rouble.png\" alt=\"Rouble\"><p>"+ price + " рублей</p></div>\n" +
//                    "                <div id=\"owner\"><img src=\"./img/owner.png\" alt=\"Owner\"><p>"+ owner +"</p></div>\n" +
//                    "                <div id=\"buy-button\"><button class=\"buy\" name=\"buy-car\" type=\"submit\" value=\"carId\">Купить</button></div>\n" +
//                    "            </div>\n" +
//                    "            <div id=\"info-block\">\n" +
//                    "\n" +
//                    "            </div>\n" +
//                    "\n" +
//                    "        </div>\n" +
//                    "\n" +
//                    "    </div>\n" +
//                    "</div>\n" +
//                    "\n" +
//                    "\n" +
//                    "</body>\n" +
//                    "</html>\n");
//
//            out.flush();
//            out.close();
////        response.sendError(400);

    }
}
