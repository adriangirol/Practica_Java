<%-- 
    Document   : index
    Created on : 09-mar-2016, 11:53:17
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Registrese </h1>
        
        
        <form action="Control" method="POST">
            <p>usuario : <input type="text" name="usuario"></p>
            <p>Password : <input type="password" name="pass"></p>
            <p><input type="submit" value="Entrar" name="Entrar"></p>
        </form>
                <% if(request.getAttribute("error")!=null){
            String error=(String) request.getAttribute("error");
           out.println("<h1 style='color:red;'> ¡Error!</h1>"); 
           out.println(error);
        }
        %>
         
    </body>
</html>

