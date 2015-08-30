<%-- 
    Document   : index
    Created on : 27-ago-2015, 16:38:02
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link rel="stylesheet" href="CSS/style.css">
    </head>
    <body>        
        <div class="wrap">
		<div class="avatar">
                    <img src="CSS/Imagenes/transmetro.jpg"/>
		</div>

                <form action="VerificarDatos.jsp" class="login">
                    <input type="text" name="tbIdUsuario" value="" placeholder="Usuario" />
                    <input type="password" name="tbContrasena" value="" placeholder="Contraseña" />
                    <br>
                    <input type="submit" value="Ingresar" name="bIngresar" />

                </form>
	</div>
    </body>
</html>
