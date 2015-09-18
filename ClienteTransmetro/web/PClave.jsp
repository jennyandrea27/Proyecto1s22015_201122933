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
        
        <div class="green_box"><!--inicio descripcion-->
            <div class="clock">
            <img src="CSS/Imagenes/admin.png" alt="" title="">             
            </div>
            <div class="text_content">                
                <p class="green">
                    <div class="wrap">
                        <form action="AgregarBus.jsp" class="login">
                            <input type="text" name="tbId" value="" placeholder="Id Bus" />                            
                            <br>
                            <input type="submit" value="Ingresar" name="bIngresar" />
                        </form>
                    </div>
                </p>
            
            </div>  
    
        </div><!--final descripcion-->
        
    </body>
</html>
