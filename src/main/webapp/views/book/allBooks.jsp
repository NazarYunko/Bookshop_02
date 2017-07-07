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
<table>
    <thead>
    <tr>
        <th>Image</th>
        <th>Book name</th>
        <th>Author</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><image scr="${book.pathImage}" width="250px" height="325px" class="img-rounded"></image></td>
            <td><strong><a style="color: black; text-decoration-line: none;" href="/books/${book.id}">${book.name}</a></strong></td>
            <td><strong>${book.author.name} ${book.author.lastName}</strong></td>
            <td><strong>${book.price}</strong></td>

        </tr>
    </c:forEach>
    </tbody>
</table>