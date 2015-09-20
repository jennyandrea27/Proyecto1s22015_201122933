<%-- 
    Document   : GraficarAsignacion_Horario
    Created on : 20-sep-2015, 14:31:08
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Asignacion Horario</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	java.lang.String idConductor = request.getParameter("tbIdConductor");
	java.lang.String idBus = request.getParameter("tbIdBus");
	java.lang.String tipo = request.getParameter("tbTipo");
	port.graficarAsignacionHorario(idConductor, idBus, tipo);
        response.sendRedirect("Imagen.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
