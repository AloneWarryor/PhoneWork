<%-- 
    Document   : Login
    Created on : Oct 5, 2017, 3:20:13 PM
    Author     : Vinhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login The System</h1>
        <form action="DoLogin" method="POST">
            <p>Username <input type="text" name="txtName" value="${param.txtName}"/></p>
            <p>Password <input type="password" name="txtPassword"/></p>
            <p><input type="submit" value="Sign in" name="btnSignIn"/></p>
        </form>
            <p syle="color:red;font-style:italic;">
                ${sessionScope.LoginError}
            </p>
    </body>
</html>
