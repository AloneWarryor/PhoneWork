<%-- 
    Document   : Route
    Created on : Sep 12, 2017, 5:02:52 PM
    Author     : Vinhc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.entity.Route"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RouteController">
            <p>Enter Route name</p><input type="text" name="txtRouteName" value="" />
            <input type="submit" value="Search" name="btnSearch" />
        </form>
        <h1>Information of all Routes</h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>Route ID</th> <th>Route Name</th>
            </tr>
            <%--<%
                List<Route> routes = (List<Route>)request.getAttribute("Routes");
                for (Route x : routes) {
                        int id = x.getRouteID();
                        String name = x.getRouteName();
            %>    
            <tr>
                <td><%=id%></td>
                <td><a href="TrainController?RouteID=<%=id%>"> <%=name%></a></td>
            </tr>
            <%}%> --%>
            <c:forEach var="r" items="${Routes}">
                <tr>
                    <c:url var="u" value="TrainController">
                        <c:param name = "id" value="${r.routeID}"/>
                        <c:param name = "name" value="${r.routeName}"/>
                    </c:url>
                    <td>${r.routeID}</td>
                    <td><a href="${u}"> ${r.routeName} </a></td>
                    <td>
                        <c:url var="update" value="RouteController">
                            <c:param name="RouteID" value="${r.routeID}"/>
                            <c:param name="action" value="update"/>
                        </c:url>
                    </td>
                    <td>
                        <c:url var="delete" value="RouteController">
                            <c:param name="RouteID" value="${r.routeID}"/>
                            <c:param name="action" value="delete"/>
                        </c:url>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
            This list has ${Routes.size()} Route(s) in total
        </p>
        <form action="TrainController">
            <p>Select a route <select name="id">
                    <c:forEach var="r" items="${Routes}">
                        <option value="${r.routeID}">${r.routeName}</option>
                    </c:forEach>
                </select>
            <p> Enter train code <input type="text" name="txtTrainCode" value="" />
            <p> <input type="submit" value="Save" name="btnSave" />
        </form>
        
        <p>
            <a href="AddRoute.jsp">Add new</a>
        </p>
        <p>
            <input type="button" value="Add new"/>
        </p>
        <p>
            <input type="button" value="Add new" onclick="window.location='AddRoute.jsp'"/>
        </p>
<!--        <table>
            <td><th>
            <form action="RouteController" method="POST">
            <p>Route ID: </p><input type="text" name="RouteID" value="" />
            <p>Route Name: </p><input type="text" name="Route Name" value="" />
            </th>
            <th><input type="submit" value="Add" name="btnSummit" /></th>
            </form>
            </td>
        </table>
        <table>
            <td><th>
            <form action="RouteController" method="POST">
            <p>Route ID: </p><input type="text" name="RouteID" value="" />
            <p>Route Name: </p><input type="text" name="Route Name" value="" />
            </th>
            <th><input type="submit" value="Remove" name="btnSummit" /></th>
            </form>
            </td>
        </table>
        <table>
            <td><th>
            <form action="RouteController" method="POST">
            <p>Route ID: </p><input type="text" name="RouteID" value="" />
            <p>Route Name: </p><input type="text" name="Route Name" value="" />
            </th>
            <th><input type="submit" value="Update" name="btnSummit" /></th>
            </form>
            </td>
        </table>-->
    </body>
</html>
