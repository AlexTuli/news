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
    private static final String INSERT_QUERY = "insert into NEWS (TITLE, BRIEF, POST_CONTENT, CREATION_DATE) values (?, ?, ?, to_date (? , 'MM/dd/yyyy'))";
    private static final String UPDATE_QUERY = "update NEWS SET\n" +
            "TITLE = ?,\n" +
            "BRIEF = ?,\n" +
            "POST_CONTENT = ?,\n" +
            "CREATION_DATE = (to_date (? , 'MM/dd/yyyy'))\n" +
            "where ID = ?";
    private static final String READ_ALL_QUERY = "select * from NEWS";
    public static final String READ_BY_ID_QUERY = "select * from NEWS where ID = ?";
    public static final String DELETE_QUERY = "delete NEWS where ID = ?";
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

    /**
     * Get connection to DB
     * @throws DaoException
     */
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

    /**
     * Close connection to DB
     * @throws DaoException
     */
    private void closeConnection () {
        try {
            log.debug(connection + " will be closed");
            connection.close();
            log.debug("Connection is closed");
        } catch (SQLException e) {
            log.error("Can't close connection");
            throw new DaoException(e);
        }
    }

    /**
     * Start transaction
     * @throws DaoException
     */
    private void startTransaction () {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            log.error("Can't start transaction");
            throw new DaoException(e);
        }
    }

    /**
     * Rollback changes in transaction and close connection
     * @throws DaoException
     */
    private void rollback () {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
            closeConnection();
        } catch (SQLException e) {
            log.error("Can't rollback");
            throw new DaoException(e);
        }
    }

    /**
     * Commit changes in DB and close connection
     * @throws DaoException
     */
    private void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
            closeConnection();
        } catch (SQLException e) {
            log.error("Can't commit");
            throw new DaoException(e);
        }
    }

    /**
     * Read all rows from NEWS table
     * @return List of News
     * @throws DaoException
     */
    @Override
    public List<News> readAll() {
        log.info("Start to readAll news");
        List<News> result;
        getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(READ_ALL_QUERY);
            log.debug("Start to execute query");
            ResultSet resultSet = ps.executeQuery();
            log.debug("Query was executed");
            result = parseResultSet(resultSet);
        } catch (SQLException e) {
            log.error("Can't create read all query");
            throw new DaoException(e);
        } finally {
            closeConnection();
        }
        return result;
    }

    // TODO: 24.01.2016 CHECK THIS
    @Override
    public News readById(Integer id) {
        log.info("Start to read news by ID");
        getConnection();
        PreparedStatement ps;
        News result;
        try {
            log.debug("Prepare statement");
            ps = connection.prepareStatement(READ_BY_ID_QUERY);
            ps.setInt(1, id);
            log.debug("Execute query");
            ResultSet resultSet = ps.executeQuery();
            log.debug("Parse result set");
            List<News> newses = parseResultSet(resultSet);
            result = newses.get(0);
        } catch (SQLException e) {
            log.error("Can't read by ID");
            throw new DaoException(e);
        } finally {
            closeConnection();
        }
        return result;
    }

    /**
     * Save news to DB
     * @param news News
     * @throws DaoException
     */
    @Override
    public void save(News news) {
        log.info("Start to save news.");
        getConnection();
        PreparedStatement ps;
        try {
            startTransaction();
            if (news.getId() == null) {
                ps = connection.prepareStatement(INSERT_QUERY);
            } else {
                // TODO: 24.01.2016 CHECK THIS
                ps = connection.prepareStatement(UPDATE_QUERY);
                ps.setInt(5, news.getId());
            }
            ps = fillSavePreparedStatement(news, ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            rollback();
            log.error("Can't execute save in DAO.");
            throw new DaoException(e);
        } finally {
            commit();
            log.info("News saved successfully!");
        }
    }

    private PreparedStatement fillSavePreparedStatement(News news, PreparedStatement ps) throws SQLException {
        ps.setString(1, news.getTitle());
        ps.setString(2, news.getBrief());
        ps.setString(3, news.getContent());
        String date = String.format("%tm/%td/%tY", news.getDateOfCreation(), news.getDateOfCreation(), news.getDateOfCreation());
        ps.setString(4, date);
        return ps;
    }

    /**
     * Parse result set and return List of news
     * @param rs Result Set
     * @return List of News
     * @throws DaoException
     */
    private List<News> parseResultSet (ResultSet rs) {
        List<News> result = new ArrayList<>();
        try {
            while (rs.next()) {
                News news = new News();
                Integer id = rs.getInt(1);
                String title = rs.getString(2);
                news.setTitle(title);
                String brief = rs.getString(3);
                news.setBrief(brief);
                String content = rs.getString(4);
                news.setContent(content);
                String date = rs.getString(5);
                date = date.substring(0, 11);
                date = date.replace('-', '/');
                news.setDateOfCreation(Utilities.getCalendarFromString(date, "yyyy/MM/dd"));
                news.setId(id);
                result.add(news);
            }
        } catch (SQLException e) {
            log.error("Can't parse result set");
            throw new DaoException(e);
        }
        return result;
    }

    /**
     * Delete row from DB
     * @param news News that will be deleted
     * @throws DaoException
     */
    @Override
    public void delete(News news) {
        getConnection();
        PreparedStatement ps;
        try {
            startTransaction();
            ps = connection.prepareStatement(DELETE_QUERY);
            ps.setInt(1, news.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            rollback();
            log.error("Can't execute delete query");
            throw new DaoException(e);
        } finally {
            commit();
        }
        log.info("Delete successful!");

    }
}
