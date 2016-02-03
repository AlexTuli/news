package com.epam.alex.model;

import java.util.Calendar;


/**
 * Created on 1/20/2016.
 *
 * @author Bocharnikov Alexander
 */
//@Entity
//@Table(name = "NEWS")
public class News {


    //    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NEWS_ID_SEQ")
//    @SequenceGenerator(name = "NEWS_ID_SEQ", sequenceName = "NEWS_ID_SEQ")
//    @Type(type = "integer")
    private Integer id;

    private String title;

    private String brief;
    //    @Column(name = "POST_CONTENT")
    private String content;

    //    @Column(name = "CREATION_DATE")
//    @Type(type = "calendar")
    private Calendar dateOfCreation;

    public News() {

    }

    public News(String title, String brief, String content, int id, Calendar dateOfCreation) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return String.format("%tm/%td/%tY", dateOfCreation, dateOfCreation, dateOfCreation);
    }

    public String getDay() {
        return String.format("%td", dateOfCreation);
    }

    public String getMonth() {
        return String.format("%tm", dateOfCreation);
    }

    public String getYear() {
        return String.format("%tY", dateOfCreation);
    }

    public Calendar getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Calendar dateOfCreation) {
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
