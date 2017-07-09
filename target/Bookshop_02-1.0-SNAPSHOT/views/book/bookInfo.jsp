<%--
  Created by IntelliJ IDEA.
  User: Study
  Date: 10.06.2017
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<div class="container-fluid">
    <div class="container-fluid">
        <div class="col-md-3 col-lg-3">
            <image class="img-rounded" src="/${book.pathImage}" width="250" height="325"></image>
        </div>
        <div class="col-md-9 col-lg-9" style="margin-top: -2%">
            <h2 style="color: #444444; text-align: left;">${book.name}</h2>
            <div class="text-size">Genre: ${book.genre.name}</div>
            <div class="text-size">Count of pages: ${book.countOfPages}</div>
            <div class="text-size">Author: ${book.author.name} ${book.author.lastName}</div>
            <div class="text-size">Publisher: ${book.publisher.name}</div>
            <div class="text-size">Price: ${book.price}</div>
            <div class="text-size">Quantity: ${book.quantity}</div>
            <sec:authorize access="hasRole('ROLE_USER')">
                <form:form action="/books/${book.id}/" method="post">
                    <input type="number" name="quantity" onkeypress="return false" min="1" max="${book.quantity}"
                           value="1"/>
                    <button class="btn btn-success btn-md">Add to basket</button>
                </form:form>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div style="margin-top: -20%">
                    <div class="col-md-8 col-lg-8">

                    </div>
                    <div class="col-md-4 col-lg-4">
                        <div class="container-fluid">
                            <div class="col-md-6 col-lg-6">
                                <form action="/updatebook/${book.id}" method="get">
                                    <button class="btn btn-success btn-md">UPDATE</button>
                                </form>
                            </div>
                            <div class="col-md-6 col-lg-6">
                                <form action="/deletebook/${book.id}?${_csrf.parameterName}=${_csrf.token}"
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
        <div class="col-md-12 col-lg-12" style="font-size: 18px; font-weight: bold">Description:</div>
        <div class="col-md-12 col-lg-12">${book.description}</div>
    </div>
</div>