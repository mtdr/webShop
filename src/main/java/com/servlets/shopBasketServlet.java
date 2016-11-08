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
public class shopBasketServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SBList bean = SBList.get(session);

        String key = request.getParameter("id");
        String lang = request.getParameter("lang");

        if (key == null) {
            key = request.getParameter("idP");
            if (key == null) {
                key = request.getParameter("idM");
                if (key == null) {
                    key = request.getParameter("idServlet");
                    if (key == null) {
                        bean.removeBasket();
                        response.sendRedirect("/"+"?lang="+lang);
                    } else {
                        bean.addItem(Integer.parseInt(key));
                        response.sendRedirect("/w?id="+key+"&lang="+lang);
                    }
                } else {
                    bean.removeItem(Integer.parseInt(key));
                    response.sendRedirect("/jsp/sb.jsp"+"?lang="+lang);
                }
            } else {
                bean.addItem(Integer.parseInt(key));
                response.sendRedirect("/jsp/sb.jsp"+"?lang="+lang);
            }
        } else {
            bean.addItem(Integer.parseInt(key));
            response.sendRedirect("/"+"?lang="+lang);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
    }
}
