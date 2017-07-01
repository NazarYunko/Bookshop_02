<%--
  Created by IntelliJ IDEA.
  User: Study
  Date: 10.06.2017
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<link rel="stylesheet" href="/css/book/allbooks.css">
<table>
    <thead>
    <tr>
        <th>Book name</th>
        <th>Author</th>
        <th>Price</th>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <th>Update</th>
            <th>Delete</th>
        </sec:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><strong><a style="color: black; text-decoration-line: none;" href="/books/${book.id}">${book.name}</a></strong></td>
            <td><strong>${book.author.name} ${book.author.lastName}</strong></td>
            <td><strong>${book.price}</strong></td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td><a style="text-decoration-line: none; color: dodgerblue" href="/updatebook/${book.id}"> UPDATE</a>
                </td>
                <td><a style="text-decoration-line: none; color: red;" href="/deletebook/${book.id}"> DELETE</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>