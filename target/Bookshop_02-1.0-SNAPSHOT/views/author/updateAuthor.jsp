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
    <form:form action="/updateauthor/${currentAuthor.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <h1 class="hClass">Update author</h1>
        <br>
        <h2 style="color: red">${authorException}</h2>
        <br>
        <input type="text" name="name" value="${currentAuthor.name}">
        <br>
        <input type="text" name="lastName" value="${currentAuthor.lastName} ">
        <br>
        <textarea name="biography">${currentAuthor.biography}</textarea>
        <br>
        <input type="date" name="dateOfBirth" value="${currentAuthor.dateOfBirth}"/>
        <br>
        <select name="cityId">
            <option value="0">None</option>
            <c:forEach var="city" items="${cities}">
                <option value="${city.id}">${city.id}</option>
            </c:forEach>
        </select>
        <input type="file" name="image" accept="image/*" required/>
        <button>update</button>
        <br>
    </form:form>
</div>