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
<link rel="stylesheet" href="/css/author/allauthors.css">
<br>
<div class="container-fluid">
    <div class="container-fluid">
        <div class="col-md-3 col-lg-3">
            <image class="img-rounded" src="/${author.pathImage}" width="250" height="325"></image>
        </div>
        <div class="col-md-9 col-lg-9" style="margin-top: -2%">
            <h2 style="color: #444444; text-align: left;">${author.name} ${author.lastName}</h2>
            <div class="text-size">Date of birth: ${author.dateOfBirth}</div>
            <div class="text-size">Country: ${author.city.country.name}</div>
            <div class="text-size">City: ${author.city.name}</div>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div style="margin-top: -12%">
                    <div class="col-md-8 col-lg-8">

                    </div>
                    <div class="col-md-4 col-lg-4">
                        <div class="container-fluid">
                            <div class="col-md-6 col-lg-6">
                                <form action="/updateauthor/${author.id}" method="get">
                                    <button class="btn btn-success btn-md">UPDATE</button>
                                </form>
                            </div>
                            <div class="col-md-6 col-lg-6">
                                <form action="/deleteauthor/${author.id}?${_csrf.parameterName}=${_csrf.token}"
                                      method="post">
                                    <button class="btn btn-danger btn-md">DELETE</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </sec:authorize></div>
    </div>
    <br>
    <div class="container-fluid">
        <div class="col-md-12 col-lg-12" style="font-size: 18px; font-weight: bold">Biography:</div>
        <div class="col-md-12 col-lg-12">${author.biography}</div>
    </div>
</div>