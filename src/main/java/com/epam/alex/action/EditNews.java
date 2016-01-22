package com.epam.alex.action;

import com.epam.alex.form.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 1/22/2016.
 *
 * @author Bocharnikov Alexander
 */
public class EditNews extends ActionSupport {

    private static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        return mapping.findForward(SUCCESS);
    }
}
