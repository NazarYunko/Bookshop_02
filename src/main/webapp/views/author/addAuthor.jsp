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
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<div class="author-form">
    <form action="/addauthor?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <h1>Add author</h1>
        <br>
        <div class="form-group size">
            <input type="text" class="form-control" name="name" placeholder="Author name...">
        </div>
        <div class="form-group size">
            <input type="text" class="form-control" name="lastName" placeholder="Author last name...">
            <br>
        </div>
        <div class="form-group size">
            <textarea name="biography" class="form-control" style="resize: none;" id="" cols="30" rows="10"></textarea>
        </div>
        <br>
        <div class="form-group size">
            <input type="date" class="form-control" name="dateOfBirth">
        </div>
        <br>
        <div class="form-group size" id="selects">
            <label for="countries">Country: </label>
            <select name="countryId" id="countries" class="selectpicker" data-live-search="true">

            </select>

            <label for="cities">City: </label>
            <select name="cityId" id="cities" class="selectpicker" data-live-search="true">

            </select>
        </div>
        <div class="form-group size">
            <input type="file" class="form-control" name="image" accept="image/*" />
        </div>
        <br>
        <button class="btn btn-default btn-md">Add author</button>
    </form>
    <input type="hidden" name="csrf_name"
           value="${_csrf.parameterName}"/>
    <input type="hidden" name="csrf_value"
           value="${_csrf.token}"/>
</div>
<script src="/js/author.js"></script>