<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 05.06.2017
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/css/city/city.css">
<div class="city-form">
    <form:form action="/addcity" method="post">
        <h1 class="hClass">Add city</h1>
        <input type="text" name="cityName" placeholder="city name...">

        <select name="countryId">
            <option value="0">None</option>
            <c:forEach var="country" items="${countries}">
                <option value="${country.id}">${country.name}</option>
            </c:forEach>
        </select>

        <button>add</button>
        <br>
        <h2 style="color: red;">${cityException}</h2>
    </form:form>
</div>

<h2 class="hClass">Cities:</h2>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Country</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="city" items="${cities}">
        <tr>
            <td><strong>${city.name}</strong></td>
            <td><strong>${city.country.name}</strong></td>
            <td> <a style="text-decoration-line: none; color: dodgerblue" href="/updatecity/${city.id}"> UPDATE</a></td>
            <td> <a style="text-decoration-line: none; color: red;" href="/deletecity/${city.id}"> DELETE</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>