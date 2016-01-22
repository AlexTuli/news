package com.epam.alex.action;

import com.epam.alex.dao.JDBCNewsDao;
import com.epam.alex.dao.NewsDao;
import com.epam.alex.exceptions.DaoException;
import com.epam.alex.model.News;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created on 1/22/2016.
 *
 * @author Bocharnikov Alexander
 */
public class ViewListNews extends ActionSupport {

    private static final Logger log = Logger.getLogger(ViewListNews.class);
    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsDao newsDao = new JDBCNewsDao();
        List<News> newsList;
        try {
            newsList = newsDao.readAll();
        } catch (DaoException e) {
            log.error("Fail in ViewListNews action");
            return mapping.findForward(FAILURE);
        }
        request.setAttribute("newsList", newsList);

        return mapping.findForward(SUCCESS);
    }
}
