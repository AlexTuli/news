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
    private static final String FAIL_TO_SAVE_NEWS = "Fail to save news";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        String id = request.getParameter(ID);
        if (id != null && !id.isEmpty()) {
            news.setId(Integer.parseInt(id));
        }
        news.setContent(newsForm.getContent());
        news.setBrief(newsForm.getBrief());
        news.setTitle(newsForm.getTitle());
        try {
            news.setDateOfCreation(Utilities.getCalendarFromString(newsForm.getDateOfCreation(), DATE_FORMAT));
        } catch (UtilException e) {
            log.error(FAIL_TO_SAVE_NEWS);
            return mapping.findForward(FAILURE);
        }
        NewsDao newsDao = (NewsDao) getWebApplicationContext().getBean("newsDao");
        newsDao.save(news);
        log.info(SUCCESS);
        return mapping.findForward(SUCCESS);
    }
}
