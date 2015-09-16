<%-- 
    Document   : Rutas
    Created on : 30-ago-2015, 13:07:51
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador, Rutas</title>
        <link rel="stylesheet" href="CSS/verde.css">
    </head>
    <body>
        <div id="header">
    	<div id="logo"><a href="#"><img src="CSS/Imagenes/transmetro.png" alt="" title="" border="0" /></a></div>
        
        <div id="menu"><!--inicio menu-->
            <ul>                                        
                <li><a href="PAdmin.jsp" title="">Inicio</a></li>
                <li><a href="Administrador.jsp" title="">Administrador</a></li>
                <li><a href="EstacionClave.jsp" title="">Estacion Clave</a></li>
                <li><a href="EstacionGeneral.jsp" title="">Estacion General</a></li>
                <li><a href="Conductores.jsp" title="">Conductores</a></li>
                <li><a href="Buses.jsp" title="">Buses</a></li>
                <li><a class="current" href="Rutas.jsp" title="">Rutas</a></li>
                <li><a href="AsignacionBuses.jsp" title="">Asignacion</a></li>                
                <li><a href="IniciarSesion.jsp" title="">Salir</a></li>
            </ul>
        </div><!--final menu-->
        
        <div class="green_box"><!--inicio descripcion-->
            <div class="clock">
                <img src="CSS/Imagenes/ruta.png" alt="" title="">             
            </div>
                      
            <div class="text_content">                
                <p class="green">
                    <div class="wrap">
                        <form action="AgregarRuta.jsp" class="login">                   
                            <%
                                if(request.getParameter("id_ruta")!=null){
                                    String id=request.getParameter("id_ruta");
                                    String nombre=request.getParameter("nombre_ruta");
                                    out.println("<input type=\"text\" name=\"tbIdRuta\" value=\""+id+"\" placeholder=\"Id Ruta\" />"); 
                                    out.println("<input type=\"text\" name=\"tbNombre\" value=\""+nombre+"\" placeholder=\"Nombre Ruta\" />"); 
                                }else{
                                    out.println("<input type=\"text\" name=\"tbIdRuta\" value=\"\" placeholder=\"Id Ruta\" />"); 
                                    out.println("<input type=\"text\" name=\"tbNombre\" value=\"\" placeholder=\"Nombre Ruta\" />"); 
                                }
                            %>
                            <input type="submit" value="Agregar Ruta" name="bAgregar" />
                            <br>
                        </form>
                            <form method="POST" action="AgregarRutaClave.jsp?id_ruta=<%=request.getParameter("id_ruta")%>&nombre_ruta=<%=request.getParameter("nombre_ruta")%>" class="login">                            
                            <input type="text" name="tbIdClave" value="" placeholder="Id Estación Clave" />                            
                            <input type="submit" value="Agregar Clave" name="bClave" />
                        </form>
                        <form method="POST" action="AgregarRutaGeneral.jsp?id_ruta=<%=request.getParameter("id_ruta")%>&nombre_ruta=<%=request.getParameter("nombre_ruta")%>" class="login">
                            <input type="text" name="tbIdGeneral" value="" placeholder="Id Estación General" />                            
                            <input type="submit" value="Agregar General" name="bGeneral" />
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
        
            </div>
    
        </div> <!--final pie pagina-->                   
        
        </div>
    </body>
</html>
