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
import java.util.Date;

/**
 *
 * @author Jenny
 */
@WebService(serviceName = "Servidor")
public class Servidor {
public ArbolAVL avlAdmin=new ArbolAVL();
public ArbolAVL avlEs_Clave=new ArbolAVL();
public ArbolAVL avlEs_General=new ArbolAVL();
public ArbolAVL avlConductores=new ArbolAVL();
public ListaD listaBuses=new ListaD();
public ListaD listaRutas=new ListaD();
    /**
     * This is a sample web service operation
     */
    

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
            NodoAVL nodo=avlAdmin.BuscarAdmin(id);
            Objeto admin=null;
            try{
                admin=(Objeto)nodo.dato;
            }catch(Exception er){
                
            }
            if(admin.contrasena.equals(contrasena)){
                return "1";
            }
        }
        return "-1";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarAdministrador")
    public void AgregarAdministrador(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
        //TODO write your implementation code here:
        Objeto o=new Objeto(correo, contrasena, "admin");
        avlAdmin.Insertar(o);        
        avlAdmin.GraficarAdmin();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarEstacionClave")
    public void AgregarClave(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "contrasena") String contrasena) {        
        //crear estacion
        Objeto o=new Objeto(nombre, contrasena, "es_clave", id);
        //insertar a AVL de estaciones clave
        avlEs_Clave.Insertar(o);        
        //generar imagen del AVL
        avlEs_Clave.GraficarClave();
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarEstacionGeneral")
    public void AgregarGeneral(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "contrasena") String contrasena) {        
        //crear estacion
        Objeto o=new Objeto(nombre, contrasena, "es_clave", id);
        //insertar en AVL
        avlEs_General.Insertar(o);        
        //generar imagen AVL
        avlEs_General.GraficarGeneral();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarBus")
    public void AgregarBus(@WebParam(name = "id") int id) {              
        //insertar a lista
        listaBuses.InsertarBus(id);        
        //generar imagen de lista
        listaBuses.GraficarBus();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarRuta")
    public void AgregarRuta(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre) {                
        //crear ruta, no tiene estaciones agregadas
        Ruta ruta=new Ruta(nombre,id);
        listaRutas.InsertarRuta(ruta);
        listaRutas.GraficarRuta();
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarRutaClave")
    public void AgregarRutaClave(@WebParam(name = "id_ruta") int id_ruta, @WebParam(name = "id_estacion") int id_estacion) {        
        Ruta ruta=(Ruta)listaRutas.BuscarRuta(id_ruta);
        Objeto estacion=(Objeto)avlEs_Clave.Buscar(id_estacion);
        ruta.listaEstaciones.InsertarFinal(estacion);
        listaRutas.GraficarRuta();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarRutaGeneral")
    public void AgregarRutaGeneral(@WebParam(name = "id_ruta") int id_ruta, @WebParam(name = "id_estacion") int id_estacion) {
        Ruta ruta=(Ruta)listaRutas.BuscarRuta(id_ruta);
        Objeto estacion=(Objeto)avlEs_General.Buscar(id_estacion);
        ruta.listaEstaciones.InsertarFinal(estacion);
        listaRutas.GraficarRuta();
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarConductor")
    public void AgregarConductor(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "id") int id, @WebParam(name = "contrasena") String contrasena) {
        Objeto conductor=new Objeto(nombre, apellido, contrasena,"conductor", id);
        avlConductores.Insertar(conductor);
        avlConductores.GraficarConductor();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Asignar")
    public void Asignar(@WebParam(name = "id_bus") int id_bus, @WebParam(name = "id_ruta") int id_ruta, @WebParam(name = "id_conductor") int id_conductor, @WebParam(name = "h_inicio") String h_inicio, @WebParam(name = "fecha") String fecha, @WebParam(name = "h_final") String h_final) {
        Objeto conductor=(Objeto)avlConductores.Buscar(id_conductor);
        Ruta ruta=(Ruta)listaRutas.BuscarRuta(id_ruta);
        Date hora_inicio=new Date(h_inicio);
        Date hora_final=new Date(h_final);
        Date fecha_=new Date(fecha);
        NodoConductor nodo=new NodoConductor(id_bus, ruta, hora_inicio, hora_final, fecha_);
        conductor.listabuses.InsertarFinal(nodo);
        conductor.listabuses.GraficarAsignacion();
    }
    
}
