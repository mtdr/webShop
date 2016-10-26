package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**Создание первого сервлета
 *
 */
@WebServlet(name = "ShalomServlet", urlPatterns = {"/a/b/c", "/servlets/shalom", "/sh"})
public class shalomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("firstName");
        String surname = request.getParameter("secondName");
        System.out.println(name + " " + surname);
        response.setContentType("text/html; charset=windows-1251");
        PrintWriter out = response.getWriter();
        out.println("<h3>Profile shalomnika</h3>");
        out.println("Name: " + name + "<br>");
        out.println("Surname: " + surname + "<br>");
        out.flush();
        out.close();
//        response.sendError(400);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("windows-1251");
        String name = request.getParameter("firstName");
        String surname = request.getParameter("secondName");
        System.out.println(name + " " + surname);
        response.setContentType("text/html; charset=windows-1251");
        PrintWriter out = response.getWriter();
        out.println("<h1>Post Shalom, " + name + " " + surname + "</h1>");
        out.flush();
        out.close();
//        response.sendError(400);
    }
}
