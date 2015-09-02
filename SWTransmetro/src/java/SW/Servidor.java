/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import EDD.*;

/**
 *
 * @author Jenny
 */
@WebService(serviceName = "Servidor")
public class Servidor {
public ArbolAVL avl=new ArbolAVL();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "metodo1")
    public String metodo(@WebParam(name = "name") String txt) {
        return "Hola, buenos dias " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IniciarSesion")
    public String IniciarSesion(@WebParam(name = "id") String id, @WebParam(name = "contrasena") String contrasena) {
        //TODO write your implementation code here:
        if(id.equals("admin")&&contrasena.equals("admin")){    
            //administrador       
            return "1";
        }else{
            
        }
        return "-1";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarAdministrador")
    public String AgregarAdministrador(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
        //TODO write your implementation code here:
        Objeto o=new Objeto(correo, contrasena, "admin");
        avl.Insertar(o);        
        return avl.GraficarAdmin();
    }
    
}
