<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header clearfix">
    <p class="header-title"><bean:message key="label.news.header.title"/></p>
    <p class="header2">
        <a class="special" href="<c:url value="/locale.do?method=english"/>"><bean:message key="label.news.header.lang.english"/></a>
        <a class="special" href="<c:url value="/locale.do?method=russian"/>"><bean:message key="label.news.header.lang.russian"/></a>
    </p>
</div>

