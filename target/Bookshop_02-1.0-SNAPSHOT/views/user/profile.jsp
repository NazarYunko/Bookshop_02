<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/jQuery/jQuery3.1.1.js"></script>
<h2>${user.login}</h2>
<p style="font-size: 14px;">Email : ${user.email}</p>
<hr>

<c:forEach var="ordersBook" items="${order.ordersBooks}">
        <span>
            <h3>Book name: ${ordersBook.book.name} Price: ${ordersBook.book.price} Quantity: ${ordersBook.quantityBooksToBuy}</h3>
            <a style="text-decoration-line: none; color: red;"
               href="/profile/removebook/${ordersBook.orders.id}/${ordersBook.book.id}"> Remove</a>
        </span>
</c:forEach>
<h3>SUM: ${order.sum}</h3>
<form:form action="/profile/buy/${order.id}" method="post">
    <button>BUY</button>
</form:form>
<hr>
<form:form action="/logout" method="post">
    <button>Log out</button>
</form:form>