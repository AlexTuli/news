package com.epam.alex.dao;

import com.epam.alex.exceptions.DaoException;
import com.epam.alex.model.News;
import com.epam.alex.util.Utilities;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created on 1/22/2016.
 *
 * @author Bocharnikov Alexander
 */
public class JDBCNewsDao implements NewsDao {

    private static final Logger log = Logger.getLogger(JDBCNewsDao.class);
    private static final String ORACLE_DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USER_NAME = "alex";
    private static final String PASSWORD = "qwerty";
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    private static final String INSERT_QUERY = "insert into NEWS (TITLE, BRIEF, POST_CONTENT, CREATION_DATE) values (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "";
    private static final String READ_ALL_QUERY = "select (TITLE, BRIEF, POST_CONTENT, CREATION_DATE, ID) from NEWS";
    private Connection connection;


    public JDBCNewsDao () {
        try {
            Class.forName(ORACLE_DB_DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Can't get driver.");
            throw new DaoException(e);
        }
        log.info(this.getClass().getName() + " was created.");
    }

    private void getConnection () {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            log.debug(connection + " was opened.");
        } catch (SQLException e) {
            log.error("Can't get connection to DB");
            throw new DaoException(e);
        }
        log.info("Connection " + connection + " was created.");
    }

    @Override
    public List<News> readAll() {
        log.info("Start to readAll news");
        List<News> result;
        getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(READ_ALL_QUERY);
            ResultSet resultSet = ps.executeQuery();
            result = parseResultSet(resultSet);
        } catch (SQLException e) {
            log.error("Can't create read all query");
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public News readById(News news) {
        return null;
    }

    /**
     * Save news to DB
     * @param news News
     */
    @Override
    public void save(News news) {
        log.info("Start to save news.");
        getConnection();
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            if (news.getId() == null) {
                ps = connection.prepareStatement(INSERT_QUERY);
            } else {
                // NOT IMPLEMENTED YET
                ps = connection.prepareStatement(UPDATE_QUERY);
            }
            ps = fillSavePreparedStatement(news, ps);
            ps.executeUpdate();

        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ignored) {
            }
            log.error("Can't execute save in DAO.");
            throw new DaoException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                connection.commit();
                connection.setAutoCommit(true);
                connection.close();
                log.debug("Connection was closed.");
            } catch (SQLException e) {
                log.error("Can't close connection");
            }
            log.info("News saved successfully!");
        }
    }

    private PreparedStatement fillSavePreparedStatement(News news, PreparedStatement ps) throws SQLException {
        ps.setString(1, news.getTitle());
        ps.setString(2, news.getBrief());
        ps.setString(3, news.getContent());
        String date = String.format("%tD", news.getDateOfCreation());
        ps.setString(4, date);
        return ps;
    }

    /**
     * Parse result set and return List of news
     * @param rs Result Set
     * @return List of News
     */
    private List<News> parseResultSet (ResultSet rs) {
        List<News> result = new ArrayList<>();
        try {
            while (rs.next()) {
                News news = new News();
                String title = rs.getString(1);
                news.setTitle(title);
                String brief = rs.getString(2);
                news.setBrief(brief);
                String content = rs.getString(3);
                news.setContent(content);
                String date = rs.getString(4);
                news.setDateOfCreation(Utilities.getCalendarFromString(date));
                Integer id = rs.getInt(5);
                news.setId(id);
                result.add(news);
            }
        } catch (SQLException e) {
            log.error("Can't parse result set");
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public void delete(News news) {

    }
}
