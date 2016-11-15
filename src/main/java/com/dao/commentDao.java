package com.dao;

import com.entity.CommentsEntity;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by FlipBook TP300LD on 15.11.2016.
 */
public class commentDao {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public commentDao(){}

    public List<CommentsEntity> getAllComments() {
        return session.createQuery("SELECT s FROM CommentsEntity s ORDER BY idComment DESC", CommentsEntity.class)
                .getResultList();
    }
}
