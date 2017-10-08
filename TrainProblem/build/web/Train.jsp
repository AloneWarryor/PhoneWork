<%-- 
    Document   : train
    Created on : Sep 14, 2017, 1:34:40 PM
    Author     : Vinhc
--%>

<%@page import="com.entity.Train"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Information of all Trains</h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>Route ID</th> <th>Train Name</th>
            </tr>
            <%
                List<Train> trains = (List<Train>)request.getAttribute("TrainCodes");
                for (Train x : trains) {
                        String id = x.getRouteID();
                        String name = x.getTrainCode();
            %>    
            <tr>
                <td><%=id%></td>
                <td><%=name%></td>
            </tr>
            <%}%>
        </table>
        <p>
            This list has <%=trains.size()%> Trains(s) in total
        </p>
    </body>
</html>
