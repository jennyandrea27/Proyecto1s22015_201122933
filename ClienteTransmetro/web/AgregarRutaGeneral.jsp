<%-- 
    Document   : AgregarRutaGeneral
    Created on : 13-sep-2015, 20:25:17
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ruta, General</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	int idRuta = Integer.parseInt(request.getParameter("id_ruta"));
	int idEstacion = Integer.parseInt(request.getParameter("tbIdGeneral"));
        //parametros de la ruta
	java.lang.String nombre = request.getParameter("nombre_ruta");
	port.agregarRutaGeneral(idRuta, idEstacion);
        response.sendRedirect("Rutas.jsp?id_ruta="+idRuta+"&nombre_ruta="+nombre);
    } catch (Exception ex) {
	out.println(ex.getMessage());
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
