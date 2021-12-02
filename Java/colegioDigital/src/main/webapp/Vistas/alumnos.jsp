<%-- 
    Document   : alumnos
    Created on : 23 Nov 2021, 10:56:55
    Author     : Fer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Alumnos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center">Listado de Alumnos</h1>
        <div class="container">
            <div class="row">
                <a class="btn btn-primary col-md-4 m-4" 
                   href="AlumnosController?accion=nuevo">Agregar Alumno</a>
                <table class = "table table-primary">
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
                        <tr>
                            <td>Cell1</td>
                            <td>Cell2</td>
                        </tr>
                        <tr>
                            <td>Cell3</td>
                            <td>Cell4</td>
                        </tr>
                </table>
            </div>

        </div>

    </body>
</html>
