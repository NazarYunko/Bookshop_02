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

<div class="form-group">
    <div style="height: 300px; width:269px; margin-top:4.5%; margin-left: 39.5%">
        <div class="title">Sign up</div>
        <center>
            <h5 id="error" style="color: red; text-align: center"></h5>
        </center>
        <input class="form-control" id="login" name="name" type="text" placeholder="Login" required>
        <br>
        <input class="form-control" id="email" name="email" type="email" placeholder="Email" required>
        <br>
        <input class="form-control" id="password" name="password" type="password" placeholder="Password" required>
        <br>
        <button id="signUp" class="btn btn-primary btn-block">Sign up</button>
        <br>
        <div style="text-align: center;">
            <p class="message">Already registered? <a class="message" href="/signin">Sign
                in</a></p>
        </div>
    </div>
</div>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>


<script type="text/javascript" src="/js/user/user.js"></script>