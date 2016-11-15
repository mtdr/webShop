package com.dao;

/**
 * Created by FlipBook TP300LD on 14.11.2016.
 */
import com.beans.beanCar.Ad;
import com.dao.HibernateSessionFactory;
import com.entity.AdsEntity;
import com.entity.OrderEntity;
import com.entity.ShopEntity;
import com.entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.Date;


public class testDB {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session1 = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();

//        UsersEntity user = new UsersEntity();
//
//        user.setIdUser(1);
//        user.setName("Vasya");

//        ShopEntity shop = new ShopEntity();
//
//        shop.setAddress("Nevsky 1");
//        shop.setoX(1.021);
//        shop.setoY(1.000);

//        OrderEntity order = new OrderEntity();
//
//        order.setIdOrder(1);
//        order.setDate(new java.util.Date());
//        order.setCount(1);
//        order.setDelivery("kolotushkina 1");
//        order.setIdCar(1);
//        order.setUser("Vlad");

        AdsEntity a1 = new AdsEntity("sedan", "Audi A8",500000,"Peter","2012",
                "120.000","White","Dsg","petrol","400","3.5","left side","2","original",
                "car1/1.jpg","car1/2.jpg","car1/3.jpg","car1/4.jpg");
        AdsEntity a2 = new AdsEntity("sedan", "BMW M5",700000,"Andrew","2010",
                "110.000","White","auto","petrol","600","4.5","left side","1","original",
                "car2/1.jpg","car2/2.jpg","car2/3.jpg","car2/4.jpg");
        AdsEntity a3 = new AdsEntity("suv", "Audi Q3",300000,"Max","2012",
                "12.000","White","Dsg","petrol","150","2.5","left side","1","original",
                "car3/1.jpg","car3/2.jpg","car3/3.jpg","car3/4.jpg");
        AdsEntity a4 = new AdsEntity("suv", "BMW X3",450000,"Толик","2012",
                "120.000","Белый","Автомат","АИ-98","400","5.5","Левый","2","Оригинал",
                "car4/1.jpg","car4/2.jpg","car4/3.jpg","car4/4.jpg");
        AdsEntity a5 = new AdsEntity("coupe", "Toyota Mark",100000,"Jo Hi Man","1996",
                "700.000","White","Dsg","petrol","270","3.5","right side","2","original",
                "car5/1.jpg","car5/2.jpg","car5/3.jpg","car5/4.jpg");




        Integer result = null;
        result = (Integer) session1.save(a1);
        result = (Integer) session1.save(a2);
        result = (Integer) session1.save(a3);
        result = (Integer) session1.save(a4);
        result = (Integer) session1.save(a5);
        System.out.println(result);


        tx.commit();
        session1.close();
    }
}

