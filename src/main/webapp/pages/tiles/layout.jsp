<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<html>
<head>
    <meta charset="utf-8" content="application/http"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <title><tiles:getAsString name="title" ignore="true"/></title>
</head>
<body>
    <tiles:insert attribute="header"/>
    <tiles:insert attribute="menu"/>
<div class="body clearfix">
    <p> News >> <tiles:getAsString name="title" ignore="true"/></p>
    <tiles:insert attribute="body"/>
</div>
    <tiles:insert attribute="footer"/>
</body>
</html>
