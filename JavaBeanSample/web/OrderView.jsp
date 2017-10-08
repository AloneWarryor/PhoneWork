<%-- 
    Document   : OrderView
    Created on : Sep 28, 2017, 3:47:31 PM
    Author     : Vinhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <jsp:useBean id="customer" class="com.bean.CustomerBean" scope="request"/>
        <jsp:setProperty name="customer" property="pid" param="orderID"/>
        <p>Information of Order ID = ${customer.pid}</p>
            <table border="1" cellspacing="0">
            <tr>
                <th>Order ID</th><th>Product ID</th><th>Quantity</th><th>Price</th>
            </tr>
            <c:forEach var="o" items="${customer.ordersPD}">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.pdid}</td><td>${o.quantity}</td><td>${o.price}</td>
                </tr>
                </c:forEach>
            </table>
            <p>Fount ${customer.getOrdersPD().size()} order(s) in total</p>
    </body>
</html>
