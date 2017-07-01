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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color: #444444; text-align: center;">${book.name}</h1>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <span style="text-align: right;">
        <a style="text-decoration-line: none; color: dodgerblue" href="/updatebook/${book.id}"> UPDATE</a></td>
        <a style="text-decoration-line: none; color: red;" href="/deletebook/${book.id}"> DELETE</a>
    </span>
</sec:authorize>
<p style="font-size: 14px;">Genre: ${book.genre.name}</p>
<p style="font-size: 14px;">Desciption: ${book.description}</p>
<p style="font-size: 14px;">Count of pages: ${book.countOfPages}</p>
<p style="font-size: 14px;">Author: ${book.author.name} ${book.author.lastName}</p>
<p style="font-size: 14px;">Date of publication: ${book.dateOfPublication}</p>
<p style="font-size: 14px;">Publisher: ${book.publisher.name}</p>
<p style="font-size: 14px;">Date of print: ${book.dateOfPrint}</p>
<p style="font-size: 14px;">Price: ${book.price}</p>
<p style="font-size: 14px;">Quantity: ${book.quantity}</p>
<form:form action="/books/${book.id}/" method="post">
    <input type="number" name="quantity" onkeypress="return false" min="1" max="${book.quantity}" value="1"/>
    <button>ADD TO BASKET</button>
</form:form>