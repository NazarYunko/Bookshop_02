<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 05.06.2017
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/css/city/city.css">
<div class="city-form">
    <h1>Update country</h1>
    <form:form action="/updatecity/${currentCity.id}" method="post">
        <input type="text" name="name" value="${currentCity.name}">
        <select name="countryId">
            <option value="0">None</option>
            <c:forEach var="country" items="${countries}">
                <option value="${country.id}">${country.name}</option>
            </c:forEach>
        </select>
        <button>update</button>     <br>
        <h2 style="color: red;">${cityException}</h2>
    </form:form>
</div>
