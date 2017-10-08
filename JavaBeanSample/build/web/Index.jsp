<%-- 
    Document   : Index
    Created on : Sep 21, 2017, 3:06:11 PM
    Author     : Vinhc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="login" class="com.bean.LoginBean" scope="session"/>
        <h1>You have just submit</h1>
        <p>Password ${login.password}, <%=login.getPassword()%>
    </body>
</html>
