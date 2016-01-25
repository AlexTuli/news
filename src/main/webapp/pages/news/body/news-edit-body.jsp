<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty news}"><jsp:useBean id="news" scope="request" type="com.epam.alex.model.News"/></c:if>


<html:form action="/saveNews">
    <div class="error"><html:errors/></div>
<div class="block">
    <div class="blockLeft">
        <bean:message key="label.news.body.view.newsTitle"/>
    </div>
    <div class="blockRight">
        <html:text property="title" size="50" maxlength="100" value="${news.title}"/>
    </div>
</div>

<div class="block">
    <div class="blockLeft">
        <bean:message key="label.news.body.view.newsDate"/>
    </div>
    <div class="blockRight">
        <html:text property="dateOfCreation" size="50" maxlength="10" value="${news.date}"/>
    </div>
</div>
<div class="block">
    <div class="blockLeft">
        <bean:message key="label.news.body.view.brief"/>
    </div>
    <div class="blockRight">
        <html:textarea property="brief" rows="8" cols="52" value="${news.brief}"/>
    </div>
</div>
<div class="block">
    <div class="blockLeft">
        <bean:message key="label.news.body.view.content"/>
    </div>
    <div class="blockRight">
        <html:textarea property="content" rows="12" cols="52" value="${news.content}"/>
    </div>
<div class="buttons">
    <html:submit style="margin: 0 10px;"><bean:message key="label.news.button.save"/></html:submit>
    <input type="button" value="<bean:message key="label.news.button.cancel"/>" onclick="window.location = '/'" style="margin: 0 10px;"/>
    <input type="hidden" value="${news.id}" name="id"/>
</div>
</div>
</html:form>
