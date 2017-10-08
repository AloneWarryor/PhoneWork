<%-- 
    Document   : Product
    Created on : Sep 21, 2017, 3:46:22 PM
    Author     : Vinhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <form action="Product.jsp">
            Show <select name="txtSize" onchange="document.forms[0].submit()">
                <option value="5" <c:if test="${param.txtSize == 5}">Selected</c:if>>5</option>
                <option value="10" <c:if test="${param.txtSize == 10}">Selected</c:if>>10</option>
                <option value="15" <c:if test="${param.txtSize == 15}">Selected</c:if>>15</option>
            </select> per page
        </form>
        <jsp:useBean id="product" class="com.bean.ProductBean" scope="request"/>
        <jsp:useBean id="customer" class="com.bean.CustomerBean" scope="session"/>
        <jsp:setProperty name="product" property="page" param="page"/>
        <jsp:setProperty name="product" property="pageSize" param="txtSize"/>
        <p>
            View your shopping cart, click <a href="Cart.jsp">here</a>
        </p>
        <table border="1" cellspacing="0">
            <tr>
                <th>Product ID</th><th>Product Name</th><th>Price</th>
            </tr>
            <c:forEach var="p" items="${product.products}">
                <tr>
                    <td>${p.id}</td><td>${p.name}</td><td>${p.price}</td>
                    <td>
                        <c:url var="AddCart" value="AddCart">
                            <c:param name="id" value="${p.id}"/>
                            <c:param name="name" value="${p.name}"/>
                            <c:param name="price" value="${p.price}"/>
                        </c:url>
                        <a href="${AddCart}">Add Cart</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <c:forEach var="i" begin="1" end="${product.totalPage}">
            <a href="Product.jsp?page=${i}&txtSize=${param.txtSize}">| ${i} |</a>
            </c:forEach>
        </p>
    </body>
</html>
