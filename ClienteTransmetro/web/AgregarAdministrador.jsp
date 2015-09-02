<%-- 
    Document   : AgregarAdministrador
    Created on : 31-ago-2015, 19:27:04
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Administrador</title>
    </head>
    <body>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
        String correo=request.getParameter("tbIdUsuario");
        String contrasena=request.getParameter("tbContrasena");
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	
	// TODO process result here
	java.lang.String result = port.agregarAdministrador(correo, contrasena);
	out.println("PostOrden = "+result);
        %><a href="Administrador.jsp">Administrador.jsp</a> <%
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
