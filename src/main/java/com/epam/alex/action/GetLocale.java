package com.epam.alex.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created on 2/8/2016.
 *
 * @author Bocharnikov Alexander
 */
public class GetLocale extends ActionSupport {

    public static final String SUCCESS = "success";
    private static Locale currentLocale;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        currentLocale = getLocale(request);
        return mapping.findForward(SUCCESS);

    }

    public static Locale getCurrentLocale() {
        if (currentLocale != null) {
            return currentLocale;
        } return Locale.getDefault();
    }
}
