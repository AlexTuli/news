package com.epam.alex.action;

import com.epam.alex.dao.HibernateNewsDao;
import com.epam.alex.dao.NewsDao;
import com.epam.alex.exceptions.DaoException;
import com.epam.alex.model.News;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

/**
 * Created on 1/22/2016.
 *
 * @author Bocharnikov Alexander
 */

public class ViewListNews extends ActionSupport {


    private static final Logger log = Logger.getLogger(ViewListNews.class);
    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";
    private static final String NEWS_LIST = "newsList";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (readNewsList(request)) return mapping.findForward(FAILURE);
        return mapping.findForward(SUCCESS);
    }

    private boolean readNewsList(HttpServletRequest request) {
        NewsDao newsDao = getWebApplicationContext().getBean(HibernateNewsDao.class);
        List<News> newsList;
        try {
            newsList = newsDao.readAll();
        } catch (DaoException e) {
            log.error("Fail in ViewListNews action");
            return true;
        }
        request.setAttribute(NEWS_LIST, newsList);
        return false;
    }
}
