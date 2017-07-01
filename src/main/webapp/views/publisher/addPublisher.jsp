<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 08.06.2017
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/css/publisher/publisher.css">
<div class="publisher-form">
    <form:form action="/addpublisher?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <h1 class="hClass">Add publisher</h1>
        <input type="text" name="name" placeholder="Publisher name...">
        <input type="file" accept="image/*" name="image" required/>
        <button>add</button>
        <br>
        <h2 style="color: red">${publisherException}</h2>
    </form:form>
</div>