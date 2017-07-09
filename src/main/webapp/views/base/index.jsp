<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 04.06.2017
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>

<div class="container-fluid">
    <div class="container">
        <h1 class="h1">New books</h1>
    </div>
    <div class="container-fluid">
        <div class="col-md-3" id="div1"></div>
        <div class="col-md-3" id="div2"></div>
        <div class="col-md-3" id="div3"></div>
        <div class="col-md-3" id="div4"></div>
    </div>
    <div class="container-fluid">
        <div class="col-md-3" id="div5"></div>
        <div class="col-md-3" id="div6"></div>
        <div class="col-md-3" id="div7"></div>
        <div class="col-md-3" id="div8"></div>
    </div>
    <div class="container-fluid">
        <div class="col-md-3" id="div9"></div>
        <div class="col-md-3" id="div10"></div>
        <div class="col-md-3" id="div11"></div>
        <div class="col-md-3" id="div12"></div>
    </div>
    <div class="container-fluid">
        <div class="col-md-3" id="div13"></div>
        <div class="col-md-3" id="div14"></div>
        <div class="col-md-3" id="div15"></div>
        <div class="col-md-3" id="div16"></div>
    </div>
    <div class="container-fluid">
        <div class="col-md-3" id="div17"></div>
        <div class="col-md-3" id="div18"></div>
        <div class="col-md-3" id="div19"></div>
        <div class="col-md-3" id="div20"></div>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

<script src="/js/homePage.js"></script>

