//package net.servlets;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
///**
// * Created by FlipBook TP300LD on 22.10.2016.
// */
//@javax.servlet.annotation.WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
//public class searchServlet extends HttpServlet{
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        request.setCharacterEncoding("windows-1251");
//        String search = request.getParameter("search-req");
//        System.out.println(search);
//        response.setContentType("text/html; charset=windows-1251");
//
//        PrintWriter out = response.getWriter();
//        out.println("<h3>" + search + " обязательно скоро появится!</h3");
//        out.flush();
//        out.close();
//    }
//
//}
