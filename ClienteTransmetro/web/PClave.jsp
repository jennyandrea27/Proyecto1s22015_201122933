<%-- 
    Document   : PClave
    Created on : 17-sep-2015, 21:36:40
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clave, Principal</title>
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
            <img src="CSS/Imagenes/estacionclave.png" alt="" title="">             
            </div>
            <div class="text_content">                
                <p class="green">
                    <div class="wrap">
                        <%if(request.getParameter("id_bus")!=null){%>
                            <form method="POST" action="BuscarBus.jsp?id_estacion=<%=request.getParameter("id_estacion")%>&id_bus=<%=request.getParameter("id_bus")%>" class="login">
                        <%}else{%>        
                            <form method="POST" action="BuscarBus.jsp?id_estacion=<%=request.getParameter("id_estacion")%>" class="login">
                            <%}
                                String id=request.getParameter("id_estacion");
                                out.println("<input type=\"text\" name=\"tbIdEstacion\" value=\"Estacion Clave "+id+"\" placeholder=\"Id Estacion\" disabled=\"true\" />");
                            
                            if(request.getParameter("id_bus")!=null){
                                    String id_bus=request.getParameter("id_bus"); 
                                    out.println("<input type=\"text\" name=\"tbBus\" value=\""+id_bus+"\" placeholder=\"Id Bus\" disabled=\"true\" />"); 
                            }else{
                                out.println("<input type=\"text\" name=\"tbBus\" value=\"\" placeholder=\"Bus\" disabled=\"true\"/>");
                            }
                            %>
                            <br>
                            <input type="submit" value="Siguiente" name="bSiguiente" />
                        </form>
                    </div>
                </p>
            
            </div>  
    
        </div><!--final descripcion-->
        <div id="footer"><!--inicio pie pagina-->
            <div class="copyright">
                <a href="home.html"><img src="CSS/Imagenes/ing.png" alt="" title="" border="0"></a>
            </div>
            <div class="footer_links"> 
                <a href="#">Jenny Andrea Simeon Perez</a>        
            </div><!--final pie pagina-->       
        </div>  
        
    </body>
</html>
