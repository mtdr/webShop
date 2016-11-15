package com.dao;

import com.beans.beanUser.User;
import com.dao.HibernateSessionFactory;
import com.entity.AdsEntity;
import com.entity.OrderEntity;
import com.entity.ShopEntity;
import com.entity.UsersEntity;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.Iterator;
import java.util.List;

/**
 * Created by FlipBook TP300LD on 14.11.2016.
 */
public class testReadDb {


    public static void main(String[] args) {
        Session session1 = HibernateSessionFactory.getSessionFactory().openSession();
//        List<UsersEntity> a
          Double a  = session1.createQuery("FROM ShopEntity ", ShopEntity.class)
                .getResultList().get(0).getOx();
        System.out.println(a);

    }
}
