package com.epam.alex.model;

import java.util.Date;

/**
 * Created on 1/20/2016.
 *
 * @author Bocharnikov Alexander
 */
public class News {

    private String title;
    private String brief;
    private String content;
    private int id;
    private Date dateOfCreation;

    public News() {

    }

    public News(String title, String brief, String content, int id, Date dateOfCreation) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.id = id;
        this.dateOfCreation = dateOfCreation;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (!title.equals(news.title)) return false;
        if (!brief.equals(news.brief)) return false;
        if (!content.equals(news.content)) return false;
        return dateOfCreation.equals(news.dateOfCreation);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + brief.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + id;
        result = 31 * result + dateOfCreation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ID of this news is " + id;
    }
}
