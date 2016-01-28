package com.epam.alex.dao;

import com.epam.alex.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created on 1/28/2016.
 *
 * @author Bocharnikov Alexander
 */
public class HibernateNewsDao implements  NewsDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<News> readAll() {
        return null;
    }

    @Override
    public News readById(Integer id) {
        return null;
    }

    @Override
    public void save(News news) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(news);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {

    }
}
