<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 08.06.2017
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<link rel="stylesheet" href="/css/publisher/publisher.css">
<div class="publisher-form">

    <div class="form-group"></div>
    <h1 id="title" class="hClass">Add publisher</h1>
    <input class="form-control" type="text" style="width: 450px" name="name" id="publisherName"
           oninput="checkField('#publisherName')"
           placeholder="Publisher name...">
    <br>
    <div id="button">
        <button class="btn btn-default btn-md" id="savePublisherBtn">Add publisher</button>
    </div>
    <p style="color: red; font-size: 16px;" id="error"></p>

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
<script src="/js/publisher.js"></script>