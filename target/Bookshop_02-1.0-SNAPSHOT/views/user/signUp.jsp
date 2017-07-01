<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 05.06.2017
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<link rel="stylesheet" type="text/css" href="/css/user/signup.css">

<form:form>
    <div class="form-group">
        <div class="title">Registration</div>
        <h5 style="color: red; text-align: center">${userException}</h5>
        <br>
        <input class="form-control" name="name" type="text" placeholder="Login">
        <br>
        <input class="form-control" name="email" type="email" placeholder="Email">
        <br>
        <input class="form-control" name="password" type="password" placeholder="Password">
        <br>
        <center>
            <button class="btn btn-default btn-md">Register</button>
        </center>
    </div>
    <div style="text-align: center;">
        <p class="message">Already registered? <a class="message" href="/signin">Sign
            in</a></p>
    </div>
</form:form>
