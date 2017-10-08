<%-- 
    Document   : Customer
    Created on : Sep 28, 2017, 3:12:24 PM
    Author     : Vinhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <jsp:useBean id="customer" class="com.bean.CustomerBean" scope="request"/>
        <jsp:setProperty name="customer" property="id" param="customerID"/>
        <form action="Customer.jsp">
            Enter customer ID<input type="text" name="customerID" value=""/>
            <input type="submit" value="Search" />
        </form>
        <c:choose>
            <c:when test="${customer.getOrders().size() == 0}">
                <h1>Nothing to display</h1>
            </c:when>
            <c:otherwise>
            <table border="1" cellspacing="0">
            <tr>
                <th>Order ID</th><th>Order Date</th><th>Customer ID</th><th>Payment</th>
            </tr>
                <c:forEach var="p" items="${customer.getOrders()}">
                <tr>
                    <td>
                        <c:url var="OrderView" value="OrderView.jsp">
                            <c:param name="orderID" value="${p.orderID}"/>
                        </c:url>
                        <a href="${OrderView}">${p.orderID}</a>
                    </td>
                    <td><fmt:formatDate pattern="yyyy/MM/dd" value="${p.orderDate}"/></td><td>${p.customerID}</td><td>${p.payment}</td>
                </tr>
                </c:forEach>
            </table>
            <p>Fount ${customer.getOrders().size()} order(s) in total</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>
