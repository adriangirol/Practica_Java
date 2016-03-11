<%-- 
    Document   : Cerrar
    Created on : 09-mar-2016, 18:58:35
    Author     : 2DAW
--%>

<% HttpSession sesion=request.getSession();%>
<% if(sesion.getAttribute("usuarioValido")== null){%>
<%@ include file="index.jsp" %>
<%}else{%>

<%
    sesion.invalidate();
    response.sendRedirect("index.jsp");%>
<%}
%>
