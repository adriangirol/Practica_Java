<%-- 
    Document   : Estadisticas_user
    Created on : 11-mar-2016, 16:20:02
    Author     : 2DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estadisticas Usuarios</title>
    </head>
    <body>
        <h1 align='center'>Estadisticas por 1er apellido</h1>
        <form action="Estadisticas" method="GET">
        <% if(request.getAttribute("provincias")!=null){
            out.println("<p align='center'>Filtrado por provincias");
            out.println(request.getAttribute("provincias"));
            out.println("<input type='submit' value='Filtrar'>"); 
            out.println("</p>");}%>
        </form>    
        <% if(request.getAttribute("total")!=null){
            out.println("<p align='center'>Numero de usuarios :"+request.getAttribute("total") );
        }%>
        <%if(request.getAttribute("tabla")!=null){
            if(request.getAttribute("provincia")==null)
            {
             out.println("<h2 align='center'>Todas las Provincias</h2>");   
            }
            else{
            out.println("<h2 align='center'>"+request.getAttribute("provincia")+"</h2>");}
            out.println("<table border='1'align='center'>");
            out.println(request.getAttribute("tabla"));   
            out.println("</table>");
        }%>
    </body>
</html>
