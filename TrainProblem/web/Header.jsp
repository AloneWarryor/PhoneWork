<%-- 
    Document   : Header
    Created on : Sep 19, 2017, 4:32:48 PM
    Author     : Vinhc
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table{border: none; border-collapse: collapse; width: 100%;}
            th{background-color: activecaption; text-align: center; color: white;
            border-left: solid 1px white; text-transform: uppercase; padding: 5px;}
            tr{border-bottom: solid 1px gray;}
            td{text-align: left;}
            a{text-decoration: none; color: white;}
        </style>
    </head>
    <body>
        <img src="img/logo.jpg"/>
        <table>
            <tr>
                <th>
                    <a href="#">Home</a>
                </th>
                <th>
                    <a href="#">Routes</a>
                </th>
                <th>
                    <a href="#">Railway station</a>
                </th>
                <th>
                    <a href="#">Train</a>
                </th>
            </tr>
        </table>
        <%!Date today = new Date();%>
    </body>
</html>
