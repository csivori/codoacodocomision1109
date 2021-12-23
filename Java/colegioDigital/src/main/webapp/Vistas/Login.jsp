<%-- 
    Document   : Login
    Created on : 16 Dec 2021, 13:43:47
    Author     : Fer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Alumnos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center">Ingreso a Sistema de Alumnos</h1>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <form class=""p-5 w-50" action="AlumnoController?accion=ingresar" method="POST">
                    <div class="mb-3">
                        <label for="usuario" class="form-label">Usuario</label>
                        <input type="text" class="form-control" id="usuario" name="usuario"/>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Ingresar</button>
<%--                <a class="btn btn-warning" href="AlumnoController">Cancelar</a>  --%>
                    <a class="btn btn-warning" href="../#">Cancelar</a>
                </form>
            </div>
        </div>
    </body>
</html>




