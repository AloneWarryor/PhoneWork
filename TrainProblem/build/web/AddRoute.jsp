<%-- 
    Document   : AddRoute
    Created on : Sep 19, 2017, 4:28:48 PM
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
        <%if(button is clicked) then {%>
        <jsp:forward page="Dispatcher">
            <jsp:param name="id" value="100"/>
            <jsp:param name="name" value="An An"/>
        </jsp:forward>
        <%}%>
        <%@include file="Header.jsp"%>
        <p>
            Today is <%=today%>
        </p>
        <form action="" onsubmit="return checkForm()">
            <p>Enter Route ID <input type="text" name="routeID"/></p>
            <p>Enter Route Name <input type="text" name="routeName"/></p>
            <p><input type="submit" value="Save" name="btnSave"/></p>
        </form>
        
        <jsp:include page="Footer.html" />
    </body>
</html>
<script type="text/javascript">
    function checkForm(){
        var id = document.getElementsByName("routeID")[0];
        var name = document.getElementsByName("routeName")[0];
        if (id.value.trim() === "" || isNaN(id.value)) {
            window.alert("Route ID cannot be empty . . .");
            id.focus();
            return false;
        }
        if (name.value.trim() === "" || !isNaN(name.value)) {
            window.alert("Route name cannot be empty . . .");
            name.focus();
            return false;
        }
        return true;
    }
</script>