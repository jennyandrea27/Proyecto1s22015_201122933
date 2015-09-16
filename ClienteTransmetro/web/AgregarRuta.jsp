<%-- 
    Document   : AgregarRuta
    Created on : 13-sep-2015, 20:23:34
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin, Agregar Ruta</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	int id = Integer.parseInt(request.getParameter("tbIdRuta"));
	java.lang.String nombre = request.getParameter("tbNombre");
	port.agregarRuta(id, nombre);
        response.sendRedirect("Rutas.jsp?id_ruta="+id+"&nombre_ruta="+nombre);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
