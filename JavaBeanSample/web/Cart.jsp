<%-- 
    Document   : Cart
    Created on : Sep 21, 2017, 4:34:14 PM
    Author     : Vinhc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
    <c:choose>
            <c:when test="${empty sessionScope.Cart}">
                <h1>Your shopping cart is empty, nothing to show</h1>
                Continue buying click <a href="Product.jsp"> here </a>
            </c:when>
            <c:otherwise>
        <p>
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
        <p>
            Continue buying click <a href="Product.jsp"> here </a>
        <p>
            Check out your shopping cart click <a href="Pay.jsp"> here </a>
        </c:otherwise>
    </c:choose>
    </body>
</html>
