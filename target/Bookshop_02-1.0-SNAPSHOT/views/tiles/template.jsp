<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 04.06.2017
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book shop</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/css/main-container/main-container.css">
</head>
<body style="margin: 0; padding: 0%;">
<div class="main-header"><tiles:insertAttribute name="header"/></div>
<div class="main-container"><tiles:insertAttribute name="body"/></div>
<div class="main-footer"><tiles:insertAttribute name="footer"/></div>
</body>
</html>
