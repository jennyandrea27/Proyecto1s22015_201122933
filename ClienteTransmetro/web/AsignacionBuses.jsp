<%-- 
    Document   : Asignacion
    Created on : 15-sep-2015, 22:21:22
    Author     : Jenny Andrea Simeon Perez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin, Asignacion</title>
        <link rel="stylesheet" href="CSS/verde.css">
    </head>
    <body>
        <div id="header">
    	<div id="logo"><a href="#"><img src="CSS/Imagenes/transmetro.png" alt="" title="" border="0" /></a></div>
        
        <div id="menu"><!--inicio menu-->
            <ul>                                        
                <li><a href="PAdmin.jsp" title="">Inicio</a></li>
                <li><a title="">Administrador</a></li>
                <li><a href="EstacionClave.jsp" title="">Estacion Clave</a></li>
                <li><a href="EstacionGeneral.jsp" title="">Estacion General</a></li>
                <li><a href="Conductores.jsp" title="">Conductores</a></li>
                <li><a href="Buses.jsp" title="">Buses</a></li>
                <li><a href="Rutas.jsp" title="">Rutas</a></li>
                <li><a class="current" href="Asignacion.jsp" href="AsignacionBuses.jsp" title="">Asignacion</a></li>                
                <li><a href="IniciarSesion.jsp" title="">Salir</a></li>
            </ul>
        </div><!--final menu-->
        
        <div class="green_box"><!--inicio descripcion-->
            <div class="clock">
                <img src="CSS/Imagenes/admin.png" alt="" title="">             
            </div>
            <div class="text_content">                
                <p class="green">
                    <div class="wrap">
                        <form action="Asignar.jsp" class="login">
                            <input type="text" name="tbIdBus" value="" placeholder="Id Bus" />
                            <input type="text" name="tbIdRuta" value="" placeholder="Id Ruta" />
                            <input type="text" name="tbIdConductor" value="" placeholder="Id Conductor" />
                             
                            <input type="time" name="tbFinal" value="" placeholder="Hora Fin" />
                            <input type="date" name="tbFecha" value="" placeholder="Fecha" />
                            <br>
                            <input type="submit" value="Asignar" name="bAsignarr" />
                        </form>
                        <form method="POST" action="GraficarAsignacion_Horario.jsp" class="login">                            
                            <input type="text" name="tbIdConductor" value="" placeholder="Id Conductor" />
                            <input type="text" name="tbIdBus" value="0" placeholder="Id Bus" />
                            <input type="text" name="tbTipo" value="0" placeholder="Id Tipo" />
                            <input type="submit" value="Garficar" name="bIngresar" />
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
