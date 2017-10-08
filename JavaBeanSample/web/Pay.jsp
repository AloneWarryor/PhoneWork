<%--
    Document   : pay
    Created on : Sep 21, 2017, 5:11:31 PM
    Author     : Vinhc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <jsp:useBean id="customer" class="com.bean.CustomerBean" scope="page"/>
        <c:choose>
            <c:when test="${empty sessionScope.Cart}">
                <h1>Your shopping cart is empty, nothing to show</h1>
                Continue buying click <a href="Product.jsp"> here </a>
            </c:when>
            <c:otherwise>
        <p>
        <h1>Your Shopping Card</h1>
        <form action="PayCheck" method="POST">
            <p>Customer: <select name="Customer">
                    <c:forEach var="r" items="${customer.customers}">
                        <option value="${r.id}">${r.name}</option>
                    </c:forEach>
        </select>
        <p>Payment Method:<input type="text" name="txtPayMethod" value="" />
        <table border="1" cellspaceing="0">
            <tr>
                <th>Product ID</th><th>Product Name</th><th>Unit Price</th>
                <th>Quantity</th><th>Amount</th>
            </tr>
            <c:forEach var="p" items="${sessionScope.Cart.items}">
                <tr>
                    <td>${p.id}</td><td>${p.name}</td><td>${p.price}</td>
                    <td>${p.quantity}</td><td>${p.amount}</td>
                </tr>
            </c:forEach>
        </table>
        <p>
            This cart has ${sessionScope.Cart.items.size()} item(s),
            total amount is ${sessionScope.Cart.amount}
        </p>
        <input type="submit" value="Confirm" name="btnConfirm" />
        </form>
        </c:otherwise>
    </c:choose>
    </body>
</html>
