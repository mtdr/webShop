package com.servlets;

import com.beans.beanShopBasket.SBList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by FlipBook TP300LD on 06.11.2016.
 */
public class logOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String page = request.getParameter("page");
        SBList bean = SBList.get(session);
        bean.removeBasket();
        session.invalidate();
        switch (page) {
            case "w":
                String id = request.getParameter("id");
                response.sendRedirect("/w?id=" + id);
                break;
            case "list":
                response.sendRedirect("/");
                break;
            case "sb":
                response.sendRedirect("/jsp/sb.jsp");
                break;
            case "order":
                response.sendRedirect("/");
                break;
        }
    }
}
