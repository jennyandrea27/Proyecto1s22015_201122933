<%-- 
    Document   : Asignar
    Created on : 16-sep-2015, 15:35:56
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin, Asignar</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	int idBus = Integer.parseInt(request.getParameter("tbIdBus"));
	int idRuta = Integer.parseInt(request.getParameter("tbIdRuta"));
	int idConductor = Integer.parseInt(request.getParameter("tbIdConductor"));
	java.lang.String hInicio = request.getParameter("tbInicio");
	java.lang.String fecha = request.getParameter("tbFecha");
	java.lang.String hFinal = request.getParameter("tbFinal");
	port.asignar(idBus, idRuta, idConductor, hInicio, fecha, hFinal);
        response.sendRedirect("AsignacionBuses.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
