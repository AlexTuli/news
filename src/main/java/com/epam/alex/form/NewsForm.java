package com.epam.alex.form;

import com.epam.alex.model.News;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 1/20/2016.
 *
 * @author Bocharnikov Alexander
 */
public class NewsForm extends ValidatorForm {

    private News newsMessage;

    private String title;
    private String brief;
    private String content;
    private String id;
    private String dateOfCreation;

    public News getNewsMessage() {
        return newsMessage;
    }

    public void setNewsMessage(News newsMessage) {
        this.newsMessage = newsMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        title = null;
        brief = null;
        content = null;
        id = null;
        dateOfCreation = null;
    }
}
