<%-- 
    Document   : DoLogin
    Created on : Sep 21, 2017, 2:55:20 PM
    Author     : Vinhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged</title>
    </head>
    <body>
        <jsp:useBean id="login" class="com.bean.LoginBean" scope="session"/>
        <jsp:setProperty name="login" property="*"/>
        <h1>You have just submit</h1>
        <p>Username <jsp:getProperty name="login" property="userName" />
        <p>Password ${login.password}, <%=login.getPassword()%>
        <p> CLick <a href="Index.jsp"> here </a> to see the password
    </body>
</html>
