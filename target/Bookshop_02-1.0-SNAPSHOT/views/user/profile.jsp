<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 05.06.2017
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>${user.login}</h2>
<p style="font-size: 14px;">Email : ${user.email}</p>
<p style="font-size: 14px;">Name : ${user.name}</p>
<p style="font-size: 14px;">Last name :${user.lastName}</p>
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