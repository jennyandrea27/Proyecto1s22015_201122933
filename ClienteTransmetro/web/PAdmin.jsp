<%-- 
    Document   : PAdmin
    Created on : 27-ago-2015, 19:14:00
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal Administrador</title>
        <link rel="stylesheet" href="CSS/verde.css">
    </head>
    <body>        
        <div id="header">
    	<div id="logo"><a href="#"><img src="CSS/Imagenes/transmetro.png" alt="" title="" border="0" /></a></div>
        
        <div id="menu"><!--inicio menu-->
            <ul>                                        
                <li><a class="current" href="PAdmin.jsp" title="">Inicio</a></li>
                <li><a href="Administrador.jsp" title="">Administrador</a></li>
                <li><a href="EstacionClave.jsp" title="">Estacion Clave</a></li>
                <li><a href="EstacionGeneral.jsp" title="">Estacion General</a></li>
                <li><a href="Conductores.jsp" title="">Conductores</a></li>
                <li><a href="Buses.jsp" title="">Buses</a></li>
                <li><a href="Rutas.jsp" title="">Rutas</a></li>
                <li><a href="AsignacionBusees.jsp" title="">Asignacion</a></li>                
                <li><a href="IniciarSesion.jsp" title="">Salir</a></li>
            </ul>
        </div><!--final menu-->
        
        <div class="green_box"><!--inicio descripcion-->
            <div class="clock">
            <img src="CSS/Imagenes/admin.png" alt="" title="">             
            </div>
            <div class="text_content">
                <h1>Tareas designadas al administrador</h1>
                <p class="green">
                "El administrador es el encargado del manejo de 
                la asignación de los buses, la agregación de 
                los conductores y los usuarios de las estaciones." 
                </p>
            <div class="read_more"><a href="CargarArchivo.jsp">Cargar Archivo</a></div>
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

        
        
        
    </div>
    

    </body>
</html>
