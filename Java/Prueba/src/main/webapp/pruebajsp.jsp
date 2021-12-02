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
        <% String saludo="Hola"; String nombre="Carlos";%>
        <h1>Hello World!</h1>
        <p>Así <strong>&lt;%=saludo+" "+nombre%&gt;</strong> NO sobreescribe una variable a la otra: <%=saludo+" "+nombre%></p>
        <p>Así <strong>&lt;%=saludo =nombre%&gt;</strong> sobreescribe una variable a la otra: <%=saludo =nombre%></p>
        <p>Así <strong>&lt;%=saludo+" "+nombre%&gt;</strong> NO sobreescribe una variable a la otra: <%=saludo+" "+nombre%></p>
        <p>Esta es la Fecha y Hora Actual: <strong><%= new java.util.Date()%></strong></p>
    </body>
</html>
