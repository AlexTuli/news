<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="news" scope="request" type="com.epam.alex.model.News"/>


<div class="block">
    <div class="blockLeft"><bean:message key="label.news.body.view.newsTitle"/></div>
    <div class="blockRight"><c:out value="${news.title}"/></div>
</div>
<div class="block">
    <div class="blockLeft"><bean:message key="label.news.body.view.newsDate"/></div>
    <div class="blockRight"><c:out value="${news.date}"/></div>
</div>
<div class="block">
    <div class="blockLeft"><bean:message key="label.news.body.view.brief"/></div>
    <div class="blockRight"><c:out value="${news.brief}"/></div>
</div>
<div class="block">
    <div class="blockLeft"><bean:message key="label.news.body.view.content"/></div>
    <div class="blockRight"><c:out value="${news.content}"/></div>
</div>
<%--todo change from <a> to buttons from struts --%>
<div class="links"><a href="<c:url value="/editNews.do?id=${news.id}"/>">EDIT</a> <a href="<c:url value="/delete.do"/>">DELETE</a></div>