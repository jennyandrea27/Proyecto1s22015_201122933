<%-- 
    Document   : AgregarEs_Clave
    Created on : 02-sep-2015, 19:51:17
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Estacion Clave</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	int id = Integer.parseInt(request.getParameter("tbId"));
	java.lang.String nombre = request.getParameter("tbNombre");
	java.lang.String contrasena = request.getParameter("tbContrasena");
	port.agregarEstacionClave(id, nombre, contrasena);
        response.sendRedirect("EstacionClave.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
