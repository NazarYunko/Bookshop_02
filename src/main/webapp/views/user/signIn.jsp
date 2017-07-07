<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 05.06.2017
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" type="text/css" href="/css/user/user.css">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<form:form action="/login" id="form" method="post">
    <div class="form-group">
        <div class="title">Sign in</div>
        <center>
            <h4 class="hClass">${userException}</h4>
        </center>
        <input name="username" id="userName" class="form-control" type="text" placeholder="Login or email" oninput="checkField('#userName')">
        <br>
        <input name="password" id="password" class="form-control" type="password" min="3" placeholder="Password" oninput="checkField('#password')">
        <br>
        <button style="text-align: center" class="btn btn-primary btn-block">Sign in</button>
    </div>
    <div style="text-align: center;">
        <p class="message">Not registered? <a class="message" href="/signup">Create an account</a></p>
    </div>
</form:form>

<script src="/js/user.js"></script>