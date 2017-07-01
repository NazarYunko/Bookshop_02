<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 10.06.2017
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 style="text-align: center; color: #444444">${publisher.name}</h1>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a style="text-decoration-line: none; color: dodgerblue" href="/updatepublisher/${publisher.id}"> UPDATE</a>
    <a style="text-decoration-line: none; color: red;" href="/deletepublisher/${publisher.id}"> DELETE</a>
</sec:authorize>