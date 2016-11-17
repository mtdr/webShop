package com.dao;

import org.hibernate.Session;
import com.entity.OrderEntity;
import java.util.List;

/**
 * Created by FlipBook TP300LD on 14.11.2016.
 */
public class orderDao{
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public orderDao(){
    }

    public List<OrderEntity> getOrder() {
        return session.createQuery("SELECT t FROM OrderEntity t ", OrderEntity.class)
                .getResultList();
    }

}
