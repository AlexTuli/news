package com.epam.alex.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2/8/2016.
 *
 * @author Bocharnikov Alexander
 */
public class Welcome extends ActionSupport {

    public static final String SUCCESS = "success";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        setLocale(request, getLocale(request));
        return mapping.findForward(SUCCESS);
    }
}
