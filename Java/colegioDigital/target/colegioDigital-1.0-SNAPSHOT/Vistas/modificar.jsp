<%-- 
    Document   : modificar
    Created on : 23 Nov 2021, 10:57:23
    Author     : Fer
--%>

<%@page import="modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    String titulo = (String) request.getAttribute("TITULO");
    String soloLectura = ((titulo.equals("Modificar")) ? "" : "disabled");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titulo%> Alumno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
    </head>
    <% Alumno alumno = (Alumno) request.getAttribute("ALUMNO");%>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <p class="text-end"><%=request.getAttribute("LOGGED_USR")%></p>
                <h1 class="text-center"><%=titulo%> Alumno</h1>
                <form class=""p-5 w-50" action="AlumnoController?accion=<%=titulo%>&id=<%=alumno.getId()%>" method="POST">
                    <div class="mb-3">
                        <label for="iden" class="form-label">Id</label>
                        <input type="text" class="form-control" id="iden" name="iden" value="<%=alumno.getId()%>" <%=soloLectura%>>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="<%=alumno.getNombre()%>" <%=soloLectura%>>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="<%=alumno.getApellido()%>" <%=soloLectura%>>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" name="email" value="<%=alumno.getEmail()%>" <%=soloLectura%>>
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Teléfono (Ej: +54 11 1234-5678)</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" value="<%=alumno.getTelefono()%>" <%=soloLectura%>>
                    </div>
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                    <a class="btn btn-primary" href="AlumnoController">Cancelar</a>
                </form>
            </div>
        </div>
    </body>
</html>
