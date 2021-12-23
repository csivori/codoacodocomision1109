<%-- 
    Document   : ListaProductos
    Created on : 6 Dec 2021, 11:57:55
    Author     : Fer
--%>
<%@page import="java.util.*" %>
<%@page import="productos.Producto"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
    
        List<Producto> losProductos = (List<Producto>) request.getAttribute("LISTAPRODUCTOS"); 
    
    %>
    
    <body>
        <h1>Lista de Productos</h1>
        <!<!--  <%= losProductos%> -->
        <table>
            <tr>
                <th>Código</th>
                <th>Sección</th>
                <th>Artículo</th>
                <th>Fecha</th>
                <th>Precio</th>
                <th>Importado</th>
                <th>Origen</th>
                <th>Foto</th>
                <th>TS</th>
            </tr>
            <% for (Producto producto: losProductos) {%>
            <tr>
                <td><%=producto.getcArt()%></td>
                <td><%=producto.getSeccion()%></td>
                <td><%=producto.getnArt()%></td>
                <td><%=producto.getFecha()%></td>
                <td><%=producto.getPrecio()%></td>
                <td><%=producto.getImportado()%></td>
                <td><%=producto.getOrigen()%></td>
                <td><%=producto.getFoto()%></td>
                <td><%=producto.getTs()%></td>
            </tr>
            <% }%>
                        
            
        </table>
    </body>
</html>
