<%-- 
    Document   : Home
    Created on : Oct 3, 2017, 5:14:33 PM
    Author     : Vinhc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" uri="/WEB-INF/tlds/MyTLD" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <mt:Login url="Login.jsp" message="You have to login first"/>
        <h1>Welcome ${sessionScope.LoginUsr}</h1>
        <h1>Today is <mt:MyDate pattern="MM/dd/yyyy"/></h1>
        <h1>Today is <mt:MyDate pattern="abc"/></h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>Index</th><th>Unicode Character</th>
            </tr>
            <mt:MyUnicode start="1001" end="1093">
                <tr>
                    <th>${sessionScope.i}</th><th>${sessionScope.c}</th>
                </tr>
            </mt:MyUnicode>
        </table>
        
    </body>
</html>
