<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 04.06.2017
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/css/country/country.css">
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<div class="country-form">
    <h1 id="title">Add country</h1>
    <div class="form-group">
        <input class="form-control" style="width: 450px" type="text" id="countryName" name="name"
               oninput="checkField('#countryName')"
               placeholder="Country name...">
        <br>
        <div id="button">
            <button class="btn btn-default btn-md" id="saveCountryBtn">Add country</button>
        </div>
        <br>
        <p style="color: red; font-size: 16px;" id="error"></p>
    </div>
    <br>
    <br>
</div>

<div class="container">
    <table class="table table-hover table-sm">
        <thead>
        <tr>
            <th>Name</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody id="result">
        </tbody>
    </table>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<script type="text/javascript" src="/js/country/country.js"></script>