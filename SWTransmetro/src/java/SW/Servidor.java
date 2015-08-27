/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jenny
 */
@WebService(serviceName = "Servidor")
public class Servidor {

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
        return "Inicio de Sesion terminado";
    }
    
}
