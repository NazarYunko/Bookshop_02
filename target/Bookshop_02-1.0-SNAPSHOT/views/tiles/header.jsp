<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">BookShop</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/books">Books</a></li>
                <li><a href="/authors">Authors</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search books...">
                </div>
                <button type="button" class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/signin">Sign in</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">Profile <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="hasRole('ROLE_USER')">
                                <li><a href="/profile">Basket</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="/profile">Admin</a></li>
                            </sec:authorize>
                            <li role="separator" class="divider"></li>
                            <form:form class="navbar-form navbar-left" method="post" action="/logout">
                                <button class="btn btn-default btn-sm">Logout</button>
                            </form:form>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
