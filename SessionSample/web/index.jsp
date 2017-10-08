<%-- 
    Document   : index
    Created on : Sep 7, 2017, 4:58:13 PM
    Author     : Administrator PC
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="index.jsp" method="POST">
            <p>Start: <input type="text" name="txtStart" value="" />
            <p>End: <input type="text" name="txtEnd" value="" />
            <p><input type="submit" name="btnSubmit" value="Submit" />
        </form>

        <%if (request.getParameter("btnSubmit") != null) {
                //  get values of start and end
                int start = Integer.parseInt(request.getParameter("txtStart"));
                int end = Integer.parseInt(request.getParameter("txtEnd"));%>
        <table border="1">
            <tr>
                <th>Miles</th>
                <th>Kilometers</th>
            </tr>
            <%for (int i = start; i <= end; i++) {
                    double miles = i;
                    double km = 1.6 * i;%>
            <tr>
                <td><%=miles%></td>
                <td><%=String.format("%.2f", km)%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <h1>Hello World!</h1>
        <%! Date today = new Date();%>
        <h1> Today is <%=today%> </h1>
        <%for (int i = 1; i <= 6; i++) {%>
        <p><font size="<%=i%> "> Welcome to JSP</font>
            <%}%>
    </body>
</html>
