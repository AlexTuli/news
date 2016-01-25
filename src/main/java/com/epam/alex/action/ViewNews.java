package com.epam.alex.action;

import com.epam.alex.dao.JDBCNewsDao;
import com.epam.alex.dao.NewsDao;
import com.epam.alex.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 1/25/2016.
 *
 * @author Bocharnikov Alexander
 */
public class ViewNews extends ActionSupport {

    private static final String ID = "id";
    private static final String SUCCESS = "success";
    private static final String NEWS = "news";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter(ID);
        NewsDao dao = new JDBCNewsDao();
        News news = dao.readById(Integer.parseInt(id));
        request.setAttribute(NEWS, news);
        return mapping.findForward(SUCCESS);
    }
}
