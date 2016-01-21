<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<html>
<head>
    <meta charset="utf-8" content="application/http"/>
    <title><tiles:getAsString name="title" ignore="true"/></title>
</head>
<body>

<div >
    <tiles:insert attribute="header"/>
</div>
<div>
    <tiles:insert attribute="menu"/>
</div>
<div>
    <tiles:insert attribute="body"/>
</div>
<div>
    <tiles:insert attribute="footer"/>
</div>

</body>
</html>
