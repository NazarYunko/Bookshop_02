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
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
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
    <c:forEach var="author" items="${authors.content}">
        <tr>
            <td><a href="/authors/${author.id}">
                <image src="${author.pathImage}" class="img-rounded" width="250" height="325"></image>
            </a></td>
            <td><strong>${author.name}</strong></td>
            <td><strong>${author.lastName}</strong></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="text-align: center;">
    <a class="btn btn-primary btn-md" href="/authors?page=${authors.number}&size=${authors.size}">Previous</a>
    <a class="btn btn-primary btn-md" href="/authors?page=${authors.number+ 2}&size=${authors.size}">Next</a>
</div>