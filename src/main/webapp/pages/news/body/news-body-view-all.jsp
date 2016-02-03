<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="newsList" scope="request" type="java.util.List"/>

<bean:message key="title.viewall"/> <br/>
<form action="<c:url value="/deleteNews.do"/>">
    <c:forEach items="${newsList}" var="news">
        <div class="newsBlock">
            <div class="title"><c:out value="${news.title}"/></div>
            <div class="date"><c:out value="${news.date}"/></div>
            <div class="post-content"><c:out value="${news.content}"/></div>
            <div class="linksViewAll">
                <a href="<c:url value="/viewNews.do?id=${news.id}"/>"><bean:message
                        key="label.news.body.view.view"/></a>
                <a href="<c:url value="/editNews.do?id=${news.id}"/>"><bean:message
                        key="label.news.body.view.edit"/></a>
                <input type="checkbox" name="checkbox" value="${news.id}" title="checkbox"/>
            </div>
        </div>
    </c:forEach>
    <br/><br/><input style="float: right; margin: 5px" class="buttons" type="submit"
                     value="<bean:message key="label.news.body.view.button.delete"/>">
</form>
