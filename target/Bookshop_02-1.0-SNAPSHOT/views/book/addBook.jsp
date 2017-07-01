<%--
  Created by IntelliJ IDEA.
  User: Study
  Date: 10.06.2017
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/css/book/book.css" >
<div class="book-form">
    <form:form action="/addbook?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <h1 class="hClass">Add book</h1>
        <h1 style="color:red;">${bookException}</h1>
        <input type="text" name="name" placeholder="name">
        <br>
        <h3 class="hClass">Genre: </h3>
        <select name="genreId">
            <option value="0"></option>
            <c:forEach var="genre" items="${genres}">
                <option value="${genre.id}">${genre.name}</option>
            </c:forEach>
        </select>
        <br>
        <textarea name="description" cols="30" rows="10" placeholder="Description..."></textarea>
        <br>
        <h3 class="hClass">Count of pages: </h3>
        <input type="number" name="countOfPages" required="required" min="1" max="15000" value="1">
        <br>
        <h3 class="hClass">Author: </h3>
        <select name="authorId">
            <option value="0"></option>
            <c:forEach var="author" items="${authors}">
                <option value="${author.id}">${author.name} ${author.lastName}</option>
            </c:forEach>
        </select>
        <h3 class="hClass">Date of publication: </h3>
        <input type="date" name="dateOfPublication" value="0001-01-01">
        <br>
        <h3 class="hClass">Publisher: </h3>
        <select name="publisherId">
            <option value="0"></option>
            <c:forEach var="publisher" items="${publishers}">
                <option value="${publisher.id}">${publisher.name}</option>
            </c:forEach>
        </select>
        <br>

        <h3 class="hClass">Quantity: </h3>
        <input type="number" required="required" name="quantity" min="1" max="9999999" value="1">
        <br>
        <h3 class="hClass">Price: </h3>
        <input type="number" required="required" name="price" min="1" max="9999999" value="1">
        <br>
        <input type="file" accept="image/*" name="image" required/>
        <button>add</button>
    </form:form>
</div>