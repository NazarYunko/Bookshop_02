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
<link rel="stylesheet" type="text/css" href="/css/publisher/publisher.css">
<div class="publisher-form">
    <h1 class="hClass">Update publisher</h1>
    <form:form action="/updatepublisher/${currentPublisher.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <input type="text" name="name" value="${currentPublisher.name}">
        <input type="file" accept="image/*" name="image" required/>
        <button>update</button>
        <br>
        <h2 style="color: red">${publisherException}</h2>
    </form:form>
</div>
