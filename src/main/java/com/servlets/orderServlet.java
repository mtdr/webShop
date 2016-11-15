package com.servlets;

import com.beans.beanCar.AdList;
import com.beans.beanShopBasket.SBList;
import com.entity.OrderEntity;
import com.entity.ShopEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.dao.*;

/**
 * Created by FlipBook TP300LD on 14.11.2016.
 */
public class orderServlet extends HttpServlet{

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String lang = request.getParameter("lang");
        String shop = request.getParameter("shop");
        String delivery = request.getParameter("page");
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
        ResourceBundle rb = ResourceBundle.getBundle("shop", locale);
        if(delivery != null) {
            String city =request.getParameter("city");
            if("".equals(city)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/order.jsp?lang=" + lang);
                dispatcher.forward(request, response);
            } else {
                String street = request.getParameter("street");
                String house =  request.getParameter("house");
                shop = city + " " + street + " " + house;
            }
        }
        if (shop == null) {
            Session hSession = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction tx = hSession.beginTransaction();
            shopDao shopDao = new shopDao();
            List<ShopEntity> list = shopDao.getAllShopes();
            session.setAttribute("shops", list);
            StringBuffer ox = new StringBuffer();
            StringBuffer oy = new StringBuffer();
            StringBuffer valuesAddress = new StringBuffer();
            StringBuffer valuesTitle = new StringBuffer();
            StringBuffer valuesId = new StringBuffer();
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                ShopEntity cur = (ShopEntity) iterator.next();
                if (ox.length() > 0) {
                    ox.append(',');
                }
                ox.append('"').append(cur.getOx()).append('"');
                if (oy.length() > 0) {
                    oy.append(',');
                }
                oy.append('"').append(cur.getOy()).append('"');
                if (valuesAddress.length() > 0) {
                    valuesAddress.append(',');
                }
                valuesAddress.append('"').append(cur.getAddress()).append('"');
                if (valuesTitle.length() > 0) {
                    valuesTitle.append(',');
                }
                valuesTitle.append('"').append(cur.getTitleShop()).append('"');
                if (valuesId.length() > 0) {
                    valuesId.append(',');
                }
                valuesId.append('"').append(cur.getIdShop()).append('"');
            }
            tx.commit();
            hSession.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/order.jsp?lang=" + lang + "&ox=" + ox.toString() + "&oy=" + oy.toString() + "&Address=" + valuesAddress.toString() + "&Title=" + valuesTitle.toString()+ "&Id=" + valuesId.toString());
            dispatcher.forward(request, response);
        } else {
            SBList prod = SBList.get(session);
            LinkedHashMap<Integer, Integer> prod1 = SBList.getSBList();
            for (Map.Entry<Integer, Integer> entry : prod1.entrySet()) {
                Session hSession = HibernateSessionFactory.getSessionFactory().openSession();
                Transaction tx = hSession.beginTransaction();
                OrderEntity order = new OrderEntity();
                order.setCar(AdList.getAd(entry.getKey()).getTitle());
                order.setDelivery(shop);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    String fileDate = dateFormat.format(new java.util.Date());
                    order.setDate(dateFormat.parse(fileDate));
                    order.setCount(entry.getValue());
                    order.setUser(request.getRemoteUser());
                    hSession.save(order);
                    tx.commit();
                    hSession.close();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            prod.removeBasket();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/?lang=" + lang);
            dispatcher.forward(request, response);
        }
    }
}


