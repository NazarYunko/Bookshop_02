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
<table>
    <thead>
    <tr>
        <th>Author</th>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th>Update</th>
            <th>Delete</th>
        </sec:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td><strong><a style="color: black; text-decoration-line: none;"
                           href="/authors/${author.id}">${author.name} ${author.lastName}</a></strong></td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td><a style="text-decoration-line: none; color: dodgerblue" href="/updateauthor/${author.id}">UPDATE</a></td>
                <td><a style="text-decoration-line: none; color: red;" href="/deleteauthor/${author.id}"> DELETE</a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>