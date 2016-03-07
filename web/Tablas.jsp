<%-- 
    Document   : Tablas
    Created on : 04-mar-2016, 17:44:33
    Author     : 2DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tablas de Multiplicar</title>
    </head>
    <body>
        <%@ include file="index.html" %>
        <h1>Tablas de multiplicar</h1>
        <table>
            <form action="Tablas" method="GET">
                <tr>
                    <td>Tabla del <input type="text" name="tabla"></td>
                <tr>
                    <td><input type="submit" name="enviar" value="Mostrar"></td>
                    <td><a href="Tablas1a10">Tablas del 1 al 10</a></td>
            </form>
        </table>   
     <% if(request.getAttribute("tabla")!=null)
    {
        int Tabla=(Integer) request.getAttribute("tabla");
        out.println("<div name='tabla'>");
        out.println("<h3> Tabla del :" +Tabla+"</h3>");
        for(int i=1;i<=10;i++){
           
            out.println(Tabla+" X "+i +" = "+ (Tabla*i));
            out.println("<br>");
        }
        out.println("</div>");
    }
    %>
    <% if(request.getAttribute("Resultado")!=null){
        String resultado= (String) request.getAttribute("Resultado");
        out.println(resultado);
    } %>      
    </body>
    <% if(request.getAttribute("error")!=null){
            String error=(String) request.getAttribute("error");
           out.println("<h1 style='color:red;'> ¡Error!</h1>"); 
           out.println(error);
        }
        %>
    
</html>
