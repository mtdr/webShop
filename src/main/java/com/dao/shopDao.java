package com.dao;

import com.entity.ShopEntity;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by FlipBook TP300LD on 14.11.2016.
 */
public class shopDao {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public List<ShopEntity> getAllShopes() {
        return session.createQuery("FROM ShopEntity ", ShopEntity.class)
                .getResultList();
    }
}
