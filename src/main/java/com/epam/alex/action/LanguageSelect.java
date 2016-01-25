package com.epam.alex.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.Globals;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created on 1/25/2016.
 *
 * @author Bocharnikov Alexander
 */
public class LanguageSelect extends DispatchAction {

    private static final String SUCCESS = "success";
//    private static final String UTF_8 = "utf-8";


    public ActionForward english(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.setCharacterEncoding(UTF_8);
//        response.setCharacterEncoding(UTF_8);
        request.getSession().setAttribute(
                Globals.LOCALE_KEY, Locale.ENGLISH);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward russian(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.setCharacterEncoding(UTF_8);
//        response.setCharacterEncoding(UTF_8);
        request.getSession().setAttribute(
                Globals.LOCALE_KEY, new Locale("ru", "RU"));
        return mapping.findForward(SUCCESS);
    }
}
