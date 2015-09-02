<%-- 
    Document   : newjsp
    Created on : 30-ago-2015, 12:53:37
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador, Estacion General</title>
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
                <li><a class="current" href="EstacionGeneral.jsp" title="">Estacion General</a></li>
                <li><a href="Conductores.jsp" title="">Conductores</a></li>
                <li><a href="Buses.jsp" title="">Buses</a></li>
                <li><a href="Rutas.jsp" title="">Rutas</a></li>
                <li><a href="IniciarSesion.jsp" title="">Cerrar Sesion</a></li>
            </ul>
        </div><!--final menu-->
        
        <div class="green_box"><!--inicio descripcion-->
            <div class="clock">
                <img src="CSS/Imagenes/estaciongeneral.png" alt="" title="">             
            </div>
                 
            <div class="text_content">                
                <p class="green">
                    <div class="wrap">
                        <form action="AgregarGeneral.jsp" class="login">
                            <input type="text" name="tbId" value="" placeholder="Id Estacion" />
                            <input type="text" name="tbNombre" value="" placeholder="Nombre" />                            
                            <input type="password" name="tbContrasena" value="" placeholder="Contraseña" />
                            <br>
                            <input type="submit" value="Ingresar" name="bIngresar" />
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
