<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="newsList" scope="request" type="com.epam.alex.model.News"/>


<c:forEach items="${newsList}" var="news">
    <div class="newsBlock">
        <div class="title"><c:out value="news.title"/></div>
        <div class="date"><c:out value="news.dateOfCreation"/></div>
        <div class="post-content"><c:out value="news.content"/></div>
        <%--todo have to send id of news with this links--%>
        <div class="links"><a href="<c:url value="/viewNews.do"/>">view</a><a href="<c:url value="/editNews.do"/>">edit</a></div>
    </div>
</c:forEach>

