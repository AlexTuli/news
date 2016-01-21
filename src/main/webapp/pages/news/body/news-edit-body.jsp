<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>



<div class="block">
    <div class="error">
        <html:messages id="err.title" property="err.title.length"/>
        <html:messages id="err.title" property="err.news.title.required"/>
    </div>
    <div class="blockLeft">
        <bean:message key="label.news.body.view.newsTitle"/>
    </div>
    <div class="blockRight">

        <%--<html:text property="title" size="100" maxlength="100"/>--%>
    </div>
</div>
<div class="block">
    <div class="error">
        <html:messages id="err.dateOfCreation" property="err.news.dateOfCreation.invalid"/>
        <html:messages id="err.dateOfCreation" property="err.news.dateOfCreation.required"/>
        <html:messages id="err.dateOfCreation" property="err.news.dateOfCreation.length"/>
    </div>
    <div class="blockLeft">
        <bean:message key="label.news.body.view.newsDate"/>
    </div>
    <div class="blockRight">

    </div>
</div>
<div class="block">
    <div class="error">
        <html:messages id="err.brief" property="err.news.brief.length"/>
        <html:messages id="err.brief" property="err.news.brief.required"/>
    </div>
    <div class="blockLeft">
        <bean:message key="label.news.body.view.brief"/>
    </div>
    <div class="blockRight">

    </div>
</div>
<div class="block">
    <div class="error">
        <html:messages id="err.content" property="err.news.content.length"/>
        <html:messages id="err.content" property="err.news.content.required"/>
    </div>
    <div class="blockLeft">
        <bean:message key="label.news.body.view.content"/>
    </div>
    <div class="blockRight">

    </div>
</div>