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
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	SW.Servidor_Service service = new SW.Servidor_Service();
	SW.Servidor port = service.getServidorPort();
	 // TODO initialize WS operation arguments here
	java.lang.String id = request.getParameter("tbIdUsuario");
	java.lang.String contrasena = request.getParameter("tbContrasena");
	java.lang.String tipo = request.getParameter("tbTipo");
	// TODO process result here
	java.lang.String result = port.iniciarSesion(id, contrasena, tipo);
	if(result.equals("1")){//administrador
            response.sendRedirect("PAdmin.jsp");
        }else if(result.equals("2")){
            response.sendRedirect("PClave.jsp?id_estacion="+id);
        }else if(result.equals("3")){
            response.sendRedirect("PGeneral.jsp");
        }else if(result.equals("4")){
            response.sendRedirect("PConductor.jsp");
        }else{
            response.sendRedirect("IniciarSesion.jsp");
        }
    } catch (Exception ex) {	
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
