package com.epam.alex.dao;

import com.epam.alex.model.News;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created on 1/28/2016.
 *
 * @author Bocharnikov Alexander
 */

//@Component(value = "newsDao")
public class HibernateNewsDao implements NewsDao {

    //    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Read all newses from DB
     *
     * @return List of News
     */
    @Override
    @SuppressWarnings(value = "unchecked")
    public List<News> readAll() {
        Session session = getSession();
        Query query = session.createQuery("from News");
        List<News> result = query.list();
        session.close();
        return result;
    }

    /**
     * Read news from DB by id
     *
     * @param id - ID of news
     * @return News
     */
    @Override
    public News readById(Integer id) {
        return (News) getSession().get(News.class, id);
    }

    /**
     * Insert new news if news have no ID, else just update
     *
     * @param news - news that will be Updated/Inserted
     */
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

    /**
     * Delete news from DB
     *
     * @param id ID of news
     */
    @Override
    public void delete(Integer id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        News news = readById(id);
        session.delete(news);
        tx.commit();
        session.close();
    }
}
