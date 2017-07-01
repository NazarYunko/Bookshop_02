<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 09.06.2017
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<h1 style="color: #444444; text-align: center;">${author.name} ${author.lastName}</h1>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <span style="text-align: right;">
        <a style="text-decoration-line: none; color: dodgerblue" href="/updateauthor/${author.id}"> UPDATE</a></td>
        <a style="text-decoration-line: none; color: red;" href="/deleteauthor/${author.id}"> DELETE</a>
    </span>
</sec:authorize>
<p style="font-size: 14px;">Date of birth: ${author.dateOfBirth}</p>
<p style="font-size: 14px;">Country: ${author.city.country.name}</p>
<p style="font-size: 14px;">City: ${author.city.name}</p>
<p style="font-size: 14px;">Biography: ${author.biography}</p>