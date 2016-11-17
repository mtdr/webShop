package com.servlets;

import com.beans.beanUser.User;
import com.dao.HibernateSessionFactory;
import com.dao.orderDao;
import com.entity.OrderEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by FlipBook TP300LD on 06.11.2016.
 */
// TODO: Везде написать javaDoc
public class authServlet extends HttpServlet{
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
        User user = User.get(session);
        user.setName(request.getRemoteUser());
        user.setAuth("1");

        String page = request.getParameter("page");
        String lang = request.getParameter("lang");

        Session hSession = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = hSession.beginTransaction();
        orderDao or = new orderDao();
        List<OrderEntity> orders = or.getOrder();
        session.setAttribute("orders",orders);
        tx.commit();
        hSession.close();
        switch (page) {
            case "w":
                String id = request.getParameter("id");
                response.sendRedirect("/w?id=" + id +"&lang="+lang);
                break;
            case "list":
                response.sendRedirect("/?lang="+lang);
                break;
            case "sb":
                response.sendRedirect("/jsp/sb.jsp?lang="+lang);
                break;
            case "history":
                response.sendRedirect("/jsp/history.jsp?lang="+lang);
                break;
            case "order":
                response.sendRedirect("/order?lang="+lang);
                break;
            default:
                response.sendRedirect("/?lang="+lang);
                break;
        }
    }
}
