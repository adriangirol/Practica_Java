<%-- 
    Document   : Calculadora.jsp
    Created on : 04-mar-2016, 16:12:41
    Author     : 2DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
<% HttpSession sesion1=request.getSession();%>
<% if(sesion1.getAttribute("usuarioValido")== null || !sesion1.getAttribute("usuarioValido").equals("SI")){%>
<%@ include file="index.jsp" %>
<%}else{%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
        <% 
            String resultado;
            String operando1;
            String operando2;
            String operacion;
            if (request.getAttribute("resultado")!=null) {
        resultado = (String)request.getAttribute("resultado");
        operando1 = (String)request.getAttribute("operando1");
        operando2 = (String)request.getAttribute("operando2");
        operacion = (String)request.getAttribute("operacion");
            //Mostramos por pantalla.
             out.println("<h1> ¡Resultado!</h1>");
             out.println("<p>"+operando1+" "+operacion+" "+operando2+"  =  "+resultado+ " </p>");}
        %>
        <% if(request.getAttribute("error")!=null){
            String error=(String) request.getAttribute("error");
           out.println("<h1 style='color:red;'> ¡Error!</h1>"); 
           out.println(error);
        }
        %>
        
        
        <h1>Mi calculadora</h1>
        <form action="Calculadora" method="POST">
            <table>
                <tr>
                    <td>Operando 1:<input type="text" name="oper1"></td>
                
                <tr>
                    <td>Operando 2:<input type="text" name="oper2"></td>
                <tr>
                    <td>Operacion :
                        <select name="Operacion">
                            <option value="+">Suma</option>
                            <option value="-">Resta</option>
                            <option value="*">Multiplicación</option>
                            <option value="/">Division</option>
                        </select>
                <tr>
                    <td><input type="submit" name="enviar" value="Calcular"></td>
                 
            </table>
        </form>
    </body>
</html>
<%} %>