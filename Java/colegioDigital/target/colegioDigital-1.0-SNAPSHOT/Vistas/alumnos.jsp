<%-- 
    Document   : alumnos
    Created on : 23 Nov 2021, 10:56:55
    Author     : Fer
--%>

<%@page import="modelo.AlumnoDAO"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Alumnos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <a class="text-end" href="AlumnoController?accion=reingresar"><%=request.getAttribute("LOGGED_USR")%></a>
                <h1 class="text-center">Listado de Alumnos</h1>
                <a class="btn btn-primary col-md-4 my-4" 
                   href="AlumnoController?accion=nuevo">Agregar Alumno</a>
                <table class = "table table-primary table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                            <th>Teléfono</th>
                            <th>Modificar</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
<%
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    List<Alumno> losAlumnos = alumnoDAO.listarAlumnos();
    for(int i=0; i < losAlumnos.size(); i++) {
        String rutaM = "AlumnoController?accion=modificar&id="+losAlumnos.get(i).getId();
        String rutaD = "AlumnoController?accion=eliminar&id="+losAlumnos.get(i).getId();
        Alumno alumno = losAlumnos.get(i);
%>
                        <tr>
                            <td><%=alumno.getId()%></td>
                            <td><%=alumno.getNombre()%></td>
                            <td><%=alumno.getApellido()%></td>
                            <td><%=alumno.getEmail()%></td>
                            <td><%=alumno.getTelefono()%></td>
                            <td>
                                <a class="btn btn-warning" href=<%=rutaM%>>Modificar</a>
                            </td>
                            <td>
                                <a class="btn btn-danger" href=<%=rutaD%>>Eliminar</a>
                            </td>
                        </tr>
<% }
%>                        
                    </tbody>
                </table>
            </div>

        </div>

    </body>
</html>
