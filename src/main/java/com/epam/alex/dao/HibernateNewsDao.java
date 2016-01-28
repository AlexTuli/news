package com.epam.alex.dao;

import com.epam.alex.model.News;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created on 1/28/2016.
 *
 * @author Bocharnikov Alexander
 */

@Component (value = "newsDao")
public class HibernateNewsDao implements  NewsDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<News> readAll() {
        Session session = getSession();
        Query query = session.createQuery("from News");
        List <News> result = query.list();
        session.close();
        return result;
    }

    @Override
    public News readById(Integer id) {
        return (News) getSession().get(News.class, id);
    }

    @Override
    public void save(News news) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        if (news.getId() == null) {
            session.save(news);
        } else {
            session.update(news);
        }
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        News news = (News) session.get(News.class, id);
        session.delete(news);
        tx.commit();
        session.close();
    }
}
