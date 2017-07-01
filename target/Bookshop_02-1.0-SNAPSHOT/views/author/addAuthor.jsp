<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 09.06.2017
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/css/author/author.css">
<div class="author-form">
    <form:form action="/addauthor?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <h1 class="hClass">Add author</h1>
        <br>
        <h1 style="color: red;">${authorException}</h1>
        <br>
        <input type="text" name="name" placeholder="Author name...">
        <br>
        <input type="text" name="lastName" placeholder="Author last name...">
        <br>
        <textarea name="biography" id="" cols="30" rows="10"></textarea>
        <br>
        <input type="date" name="dateOfBirth" value="0001-01-01">
        <br>
        <select name="cityId">
            <option value="0">None</option>
            <c:forEach var="city" items="${cities}">
                <option value="${city.id}">${city.name}</option>
            </c:forEach>
        </select>
        <input type="file" name="image" accept="image/*" required/>
        <br>
        <button>add</button>
    </form:form>
</div>