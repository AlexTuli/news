<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="newsList" scope="request" type="com.epam.alex.model.News"/>


<c:forEach items="${newsList}" var="news">
    <div class="newsBlock">
        <p>News title: <c:out value="news.title"/></p>
    </div>
</c:forEach>

