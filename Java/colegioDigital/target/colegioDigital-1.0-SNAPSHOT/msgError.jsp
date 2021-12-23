<%-- 
    Document   : msgError.jsp
    Created on : 9 Dec 2021, 15:38:50
    Author     : Fer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=request.getAttribute("TITULO")%></title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
    </head>
    <body>
        <div class="alert alert-<%=request.getAttribute("TIPO")%> mx-5 mt-3 mb-0" role="alert">
            <h3><%=request.getAttribute("TITULO")%></h3>
            <br>
            <h5><%=request.getAttribute("MENSAJE")%></h5>
        </div>
        <br>
        <a class="btn btn-primary mx-5" href="<%=request.getAttribute("PROX_PASO")%>">Continuar</a>
    </body>
</html>
