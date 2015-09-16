<%-- 
    Document   : AgregarConductor
    Created on : 15-sep-2015, 21:38:36
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin, Agregar Conductores</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	java.lang.String nombre = request.getParameter("tbNombre");
	java.lang.String apellido = request.getParameter("tbApellido");
	int id = Integer.parseInt(request.getParameter("tbId"));
	java.lang.String contrasena = request.getParameter("tbContrasena");;
	port.agregarConductor(nombre, apellido, id, contrasena);
        response.sendRedirect("Conductores.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
