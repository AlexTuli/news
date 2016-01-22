package com.epam.alex.action;

import com.epam.alex.form.NewsForm;
import com.epam.alex.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 21.01.2016.
 *
 *@author Bocharnikov Alexander
 *
 */
public class SaveNews extends ActionSupport {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setContent(newsForm.getContent());
        news.setBrief(newsForm.getBrief());
        news.setTitle(newsForm.getTitle());

        System.out.println(news.getTitle());

        return mapping.findForward("success");
    }
}
