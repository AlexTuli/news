package com.epam.alex.dao;

import com.epam.alex.exceptions.DaoException;
import com.epam.alex.model.News;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public List<News> getList() {
        return null;
    }

    @Override
    public News getById(News news) {
        return null;
    }

    @Override
    public void save(News news) {
        log.info("Start to save news.");
        getConnection();
        PreparedStatement ps = null;
        try {
            if (news.getId() == null) {
                ps = connection.prepareStatement(INSERT_QUERY);
            } else {
                // NOT IMPLEMENTED YET
                ps = connection.prepareStatement(UPDATE_QUERY);
            }
            ps = fillSavePreparedStatement(news, ps);
            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Can't execute save in DAO.");
            throw new DaoException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                connection.close();

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
        String date = String.format("%td", news.getDateOfCreation());
        ps.setString(4, date);
        return ps;
    }


    @Override
    public void delete(News news) {

    }
}
