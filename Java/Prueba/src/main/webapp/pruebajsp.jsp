<%-- 
    Document   : pruebajsp
    Created on : 9 Nov 2021, 11:25:53
    Author     : Fer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String saludo="Hola";
            String nombre="Carlos";
        %>
        <h1>Hello World!</h1>
        <p><%=saludo+" "+nombre%></p>
        <p><%=saludo =nombre%></p>
        <p><%= new java.util.Date()%></p>
    </body>
</html>
