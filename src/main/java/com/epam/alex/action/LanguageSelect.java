package com.epam.alex.action;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

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
    private static final String RU = "ru";
    private static final String RU1 = "RU";


    public ActionForward english(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward russian(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(Globals.LOCALE_KEY, new Locale(RU, RU1));
        return mapping.findForward(SUCCESS);
    }
}
