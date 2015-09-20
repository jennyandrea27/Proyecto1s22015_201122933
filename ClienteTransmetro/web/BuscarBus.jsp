<%-- 
    Document   : BuscarBus
    Created on : 18-sep-2015, 16:09:19
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estacion, BuscarBus</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	int idEstacion = Integer.parseInt(request.getParameter("id_estacion"));
	java.lang.String tipo = "";
	// TODO process result here
	java.lang.String result = port.buscarBus(idEstacion, tipo);
	out.println("Result = "+result);        
        response.sendRedirect("PClave.jsp?id_estacion="+idEstacion+"&id_bus="+result);
    } catch (Exception ex) {
	out.println(ex.getMessage());
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
