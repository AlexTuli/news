package com.epam.alex.action;

import com.epam.alex.dao.JDBCNewsDao;
import com.epam.alex.dao.NewsDao;
import com.epam.alex.exceptions.UtilException;
import com.epam.alex.form.NewsForm;
import com.epam.alex.model.News;
import com.epam.alex.util.Utilites;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * Created on 21.01.2016.
 *
 *@author Bocharnikov Alexander
 *
 */
public class SaveNews extends ActionSupport {

    private static final Logger log = Logger.getLogger(SaveNews.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        News news = new News();

        news.setContent(newsForm.getContent());
        news.setBrief(newsForm.getBrief());
        news.setTitle(newsForm.getTitle());
        try {
            news.setDateOfCreation(Utilites.getCalendarFromString(newsForm.getDateOfCreation()));
        } catch (UtilException e) {
            return mapping.findForward("failure");
        }

        NewsDao newsDao = new JDBCNewsDao();
        newsDao.save(news);

        return mapping.findForward("success");
    }
}
