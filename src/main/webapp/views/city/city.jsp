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
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<h1 id="title">Add city</h1>
<div class="form-group">
    <input class="form-control" style="width: 450px" type="text" id="cityName" name="name"
           oninput="checkField('#cityName')"
           placeholder="City name...">
    <br>
    <div class="form-group">
        <label for="countries">Country: </label>
        <select name="countryId" id="countries" class="selectpicker" style="width: 450px" data-live-search="true">
        </select>
    </div>

    <div id="button">
        <button class="btn btn-default btn-md" id="saveCityBtn">Add city</button>
    </div>
    <br>
    <p style="color: red; font-size: 16px;" id="error"></p>
</div>
<br>
<br>

<div class="container">
    <table class="table table-hover table-sm">
        <thead>
        <tr>
            <th>Name</th>
            <th>Country</th>
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

<script type="text/javascript" src="/js/city.js"></script>