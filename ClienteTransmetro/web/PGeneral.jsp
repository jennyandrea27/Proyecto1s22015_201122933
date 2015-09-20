<%-- 
    Document   : PGeneral
    Created on : 19-sep-2015, 21:07:25
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>General, Principal</title>
        <link rel="stylesheet" href="CSS/verde.css">
    </head>
    <body>
        
        <div id="header">
    	<div id="logo"><a href="#"><img src="CSS/Imagenes/transmetro.png" alt="" title="" border="0" /></a></div>
        
        <div id="menu"><!--inicio menu-->
            <ul>                                                                       
                <li><a href="IniciarSesion.jsp" title="">Salir</a></li>
            </ul>
        </div><!--final menu-->
        
        <div class="green_box"><!--inicio descripcion-->
            <div class="clock">
            <img src="CSS/Imagenes/estaciongeneral.png" alt="" title="">             
            </div>
            <div class="text_content">                
                <p class="green">
                    <div class="wrap">
                        <!--recorrer avl de estaciones generales para generar forms en los 
                        que se visualizan todas las estaciones-->
                        <%-- start web service invocation --%><hr/>
                        <%
                        try {
                            SW.Servidor_Service service = new SW.Servidor_Service();
                            SW.Servidor port = service.getServidorPort();
                            // TODO process result here
                            java.lang.String result = port.formGenerales();
                            out.println(result);
                        } catch (Exception ex) {
                            // TODO handle custom exceptions here
                        }
                        %>
                        <%-- end web service invocation --%><hr/>
                    </div>
                </p>
            
            </div>  
    
        </div><!--final descripcion-->
        
    
    </body>
</html>
