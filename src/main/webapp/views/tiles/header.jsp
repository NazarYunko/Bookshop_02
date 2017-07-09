<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><label:message code="label.book_shop"/> </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/books"><label:message code="label.books"/></a></li>
                <li><a href="/authors"><label:message code="label.authors"/></a></li>
            </ul>
            <form action="/search?${_csrf.parameterName}=${_csrf.token}" class="navbar-form navbar-left" id="searchForm" method="post">
                <div class="form-group">
                    <input type="text" name="search" id="search" class="form-control" placeholder="Search books...">
                    <input type="hidden" name="csrf_name"
                           value="${_csrf.parameterName}"/>
                    <input type="hidden" name="csrf_value"
                           value="${_csrf.token}"/>
                </div>
                <button class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-search"></span><label:message code="label.search"/>
                </button>
            </form>
            <ul class="nav navbar-nav">
                <li><a href="?lang=ua">UA</a></li>
                <li><a href="?lang=en">EN</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/signin"><label:message code="label.sign_in"/></a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><label:message code="label.profile"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="hasRole('ROLE_USER')">
                                <li><a href="/profile"><label:message code="label.basket"/></a></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="/profile"><label:message code="label.admin"/></a></li>
                            </sec:authorize>
                            <li role="separator" class="divider"></li>
                            <form:form class="navbar-form navbar-left" method="post" action="/logout">
                                <button class="btn btn-default btn-sm"><label:message code="label.logout"/></button>
                            </form:form>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<script src="/js/header.js"></script>
