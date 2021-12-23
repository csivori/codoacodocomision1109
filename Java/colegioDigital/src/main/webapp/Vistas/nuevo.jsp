<%-- 
    Document   : nuevo
    Created on : 23 Nov 2021, 10:57:40
    Author     : Fer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Alumno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <p class="text-end"><%=request.getAttribute("LOGGED_USR")%></p>
                <h1 class="text-center">Agregar Alumno</h1>
                <form class=""p-5 w-50" action="AlumnoController?accion=insertar" method="POST">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre"/>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido"/>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" name="email"/>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Teléfono (Ej: +54 11 1234-5678)</label>
                        <input type="text" class="form-control" id="telefono" name="telefono"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Agregar</button>
                    <a class="btn btn-warning" href="/colegioDigital/AlumnoController">Cancelar</a>
                </form>
            </div>
        </div>
    </body>
</html>
