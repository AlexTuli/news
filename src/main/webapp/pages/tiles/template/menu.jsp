<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div class="menu clearfix">

    <p class="middle"><bean:message key="label.news.menu.title"/></p>

    <ul class="list">
        <li><a><bean:message key="label.news.menu.addNews"/></a></li>
        <li><a href="${pageContext.request.contextPath}/viewNews.do"><bean:message key="label.news.menu.listNews"/></a></li>
    </ul>

</div>
