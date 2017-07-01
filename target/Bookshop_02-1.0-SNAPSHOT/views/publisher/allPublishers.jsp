<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 08.06.2017
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="/css/publisher/publisher.css">
<div class="publishers-container">
    <c:forEach var="publisher" items="${publishers}">
        <br>
        <strong><a href="/publishers/${publisher.id}"> ${publisher.name}</a></strong>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a style="text-decoration-line: none; color: dodgerblue" href="/updatepublisher/${publisher.id}">UPDATE</a>
            <a style="text-decoration-line: none; color: red;" href="/deletepublisher/${publisher.id}"> DELETE</a>
        </sec:authorize>
        <hr>
    </c:forEach>
</div>