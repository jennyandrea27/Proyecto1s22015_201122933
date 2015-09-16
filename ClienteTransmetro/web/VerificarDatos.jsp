<%-- 
    Document   : PagInicio
    Created on : 27-ago-2015, 11:09:58
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicio</title>
        
    </head>
    <body>
        <h1>Verificar Datos</h1>
    <%--metodo iniciar sesion
    <%-- start web service invocation --%><hr/>
    <%
    try {
        String tbId=request.getParameter("tbIdUsuario");
        String tbContr=request.getParameter("tbContrasena");
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	java.lang.String id = tbId;
	java.lang.String contrasena = tbContr;
	// TODO process result here
	java.lang.String result = port.iniciarSesion(id, contrasena);
        if(result.equals("1")){//administrador
            response.sendRedirect("PAdmin.jsp");
        }else{
            response.sendRedirect("IniciarSesion.jsp");
        }
	
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
