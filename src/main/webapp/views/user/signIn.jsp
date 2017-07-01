<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 05.06.2017
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" type="text/css" href="/css/user/signin.css">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<form:form action="/login" method="post">
    <div class="form-group">
        <div class="title">Sign in</div>
        <h5 style="color: red; text-align: center">${userException}</h5>
        <br>
        <input name="username" class="form-control" type="text" placeholder="Login or email">
        <br>
        <input name="password" class="form-control" type="password" placeholder="Password">
        <br>
        <center>
            <button style="text-align: center" class="btn btn-default btn-md">Log In</button>
        </center>
    </div>
    <div style="text-align: center;">
        <p class="message">Not registered? <a class="message" href="/signup">Create an account</a></p>
    </div>
</form:form>