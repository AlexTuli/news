<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="menu clearfix">

    <p class="middle"><bean:message key="label.news.menu.title"/></p>

    <ul class="list">
        <li><a name="add-news" href="<c:url value="/addNews.do"/>"><bean:message key="label.news.menu.addNews"/></a></li>
        <li><a name="list-news" href="<c:url value="/viewListNews.do"/>"><bean:message key="label.news.menu.listNews"/></a></li>
    </ul>

</div>
