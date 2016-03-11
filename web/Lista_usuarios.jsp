<%-- 
    Document   : Lista_usuarios
    Created on : 10-mar-2016, 16:12:13
    Author     : 2DAW
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado Usuarios</title>
</head>
<body>
    <%
Integer limit = 0;
if(request.getParameter("limit")==null){
    
   limit=0;
}else{
    limit=Integer.parseInt(request.getParameter("limit"));
    
}  
%>
<h1 align="center">Listado de Socios</h1>
<%

Class.forName("com.mysql.jdbc.Driver");
Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
Statement s = conexion.createStatement();
ResultSet listado = s.executeQuery ("SELECT t_usuarios.id,t_usuarios.nombre as nombre,apellido1,apellido2,t_provincias.nombre as provincia FROM t_usuarios,t_provincias WHERE t_provincias.cod=t_usuarios.prov_cod ORDER BY t_usuarios.id LIMIT "+limit+",20 ;");
Statement x = conexion.createStatement();
ResultSet Numero_p = x.executeQuery("SELECT COUNT(*)as total FROM t_usuarios");
Numero_p.next();
int total= Integer.parseInt(Numero_p.getString("total"));
out.println("<p align='center'> NUMERO DE USUARIOS : "+Numero_p.getString("total") +"</p>");
out.println("<table border='2' align='center'>");

while (listado.next()) {
out.println("<tr>");
out.println("<td>"+listado.getString("id") + "<td> " + listado.getString("nombre") + "<td> "
        + listado.getString("apellido1") +"<td>"+ listado.getString("apellido2") +"<td>"+
        listado.getString("apellido2") +"<td>"+
        listado.getString("provincia") +"<tr>");

}
out.println("</table>");
conexion.close();%>
    <%if(limit>=20){%>
    <p align="center"><a href="Lista_usuarios.jsp?limit=<%=(limit-20)%>">Atras</a>
    <%}%>
   <% if(limit+20<total){%>
   <a href="Lista_usuarios.jsp?limit=<%=(limit+20)%>">Siguiente</a></p>
       <% }%>
    
</body>
</html>

