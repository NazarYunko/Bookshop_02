<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 07.07.2017
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<table class="table table-hover table-sm">
    <thead>
    <tr>
        <th>Image</th>
        <th>Book name</th>
        <th>Author</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td><a href="/books/${book.id}"><img src="${book.pathImage}" width="250px" height="325px"></a></td>
            <td><strong><a style="color: black; text-decoration-line: none;" href="/books/${book.id}">${book.name}</a></strong></td>
            <td><strong>${book.author.name} ${book.author.lastName}</strong></td>
            <td><strong>${book.price}</strong></td>
        </tr>
    </tbody>
</table>
