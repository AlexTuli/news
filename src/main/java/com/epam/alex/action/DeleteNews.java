package com.epam.alex.action;

import com.epam.alex.dao.JDBCNewsDao;
import com.epam.alex.dao.NewsDao;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 1/25/2016.
 *
 * @author Bocharnikov Alexander
 */

public class DeleteNews extends ActionSupport {

    private static final Logger log = Logger.getLogger(DeleteNews.class);
    private static final String SUCCESS = "success";
    private static final String checkbox = "checkbox";
    private static final String STARTING_TO_DELETE = "Starting to delete.";
    private static final String NEWS_WAS_DELETED = "News was deleted.";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsDao newsDao = new JDBCNewsDao();
        String[] ids = request.getParameterValues(checkbox);
        log.info(STARTING_TO_DELETE);
        for (String id : ids) {
            newsDao.delete(Integer.parseInt(id));
        }
        log.info(NEWS_WAS_DELETED);
        return mapping.findForward(SUCCESS);
    }
}
