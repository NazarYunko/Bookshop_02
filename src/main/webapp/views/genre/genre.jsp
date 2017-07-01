<%--
  Created by IntelliJ IDEA.
  User: Study
  Date: 07.06.2017
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="/css/genre/genre.css">
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<div class="country-form">
    <h1 id="title">Add genre</h1>
    <div class="form-group">
        <input class="form-control" style="width: 450px" type="text" id="genreName" name="name"
               oninput="checkField('#genreName')"
               placeholder="Genre name...">
        <br>
        <div id="button">
            <button class="btn btn-default btn-md" id="saveGenreBtn">Add genre</button>
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

<script type="text/javascript" src="/js/genre/genre.js"></script>