<%-- 
    Document   : menu
    Created on : 09-mar-2016, 11:31:36
    Author     : Adrián
--%>
<% HttpSession sesion=request.getSession();%>
<% if(sesion.getAttribute("usuarioValido")== null){%>
<%@ include file="index.jsp" %>
<%}else{%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Menu Practica </h1>
                <ul><a href="Calculadora.jsp">Calculadora</a></ul>
                <ul><a href="Tablas.jsp">Tablas</a></ul>
                <ul><a href="Cerrar.jsp">Cerrar</a></ul>
    </body>
</html>
<%}
    %>