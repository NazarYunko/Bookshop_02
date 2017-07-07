<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 09.06.2017
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<link rel="stylesheet" href="/css/author/allauthors.css">
<table class="table table-hover table-sm">
    <thead>
    <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Last name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td><a href="/authors/${author.id}"><image src="${author.pathImage}" class="img-rounded" width="250" height="325"></image></a></td>
            <td><strong>${author.name}</strong></td>
            <td><strong>${author.lastName}</strong></td>
        </tr>
    </c:forEach>
    </tbody>
</table>