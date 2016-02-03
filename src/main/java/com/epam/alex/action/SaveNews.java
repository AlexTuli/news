package com.epam.alex.action;

import com.epam.alex.dao.NewsDao;
import com.epam.alex.exceptions.UtilException;
import com.epam.alex.form.NewsForm;
import com.epam.alex.model.News;
import com.epam.alex.util.Utilities;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Created on 21.01.2016.
 *
 * @author Bocharnikov Alexander
 */

public class SaveNews extends ActionSupport {

    private static final Logger log = Logger.getLogger(SaveNews.class);
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String ID = "id";
    private static final String NEWS_DAO = "newsDao";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {


        News news = extractNews((NewsForm) form, request);

        if (news == null) {
            return mapping.findForward(FAILURE);
        }

        NewsDao newsDao = (NewsDao) getWebApplicationContext().getBean(NEWS_DAO);
        newsDao.save(news);

        log.info(SUCCESS);

        return mapping.findForward(SUCCESS);
    }

    private News extractNews(NewsForm form, HttpServletRequest request) {
        News news = new News();
        String id = request.getParameter(ID);
        if (id != null && !id.isEmpty()) {
            news.setId(Integer.parseInt(id));
        }
        news.setContent(form.getContent());
        news.setBrief(form.getBrief());
        news.setTitle(form.getTitle());
        StringBuilder date = getDate(request);
        Calendar dateOfCreation;
        try {
            dateOfCreation = Utilities.getCalendarFromString(date.toString(), DATE_FORMAT);
        } catch (UtilException e) {
            ResourceBundle bundle = ResourceBundle.getBundle("news", getLocale(request));
            request.setAttribute("error", bundle.getString("err.news.dateOfCreation.invalid"));
            request.setAttribute("news", news);
            log.error("Can't parse date");
            return null;
        }
        news.setDateOfCreation(dateOfCreation);
        return news;
    }

    private StringBuilder getDate(HttpServletRequest request) {
        StringBuilder date = new StringBuilder(request.getParameter("month"));
        date.append('/').append(request.getParameter("day"));
        date.append('/').append(request.getParameter("year"));
        return date;
    }
}
