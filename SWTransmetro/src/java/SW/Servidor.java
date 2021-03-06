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
import java.text.SimpleDateFormat;
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
        Objeto estacion_nueva=estacion.Duplicar();
        ruta.listaEstaciones.InsertarFinal(estacion_nueva);
        listaRutas.GraficarRuta();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarRutaGeneral")
    public void AgregarRutaGeneral(@WebParam(name = "id_ruta") int id_ruta, @WebParam(name = "id_estacion") int id_estacion) {
        Ruta ruta=(Ruta)listaRutas.BuscarRuta(id_ruta);
        Objeto estacion=(Objeto)avlEs_General.Buscar(id_estacion);
        Objeto estacion_nueva=estacion.Duplicar();
        ruta.listaEstaciones.InsertarFinal(estacion_nueva);
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
        //crear nueva ruta para asignarla al conductor
        Ruta ruta_nueva=new Ruta(ruta);
        Date hora_inicio=new Date();
        Date hora_final=new Date();
        Date fecha_=new Date();
        NodoConductor nodo=new NodoConductor(id_bus, ruta_nueva, hora_inicio, hora_final, fecha_);
        conductor.listabuses.InsertarFinal(nodo);
        conductor.listabuses.GraficarAsignacion();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IniciarSesion")
    public String IniciarSesion(@WebParam(name = "id") String id, @WebParam(name = "contrasena") String contrasena, @WebParam(name = "tipo") String tipo) {
        if(id.equals("admin")&&contrasena.equals("admin")){    
            //administrador       
            return "1";
        }else{
            NodoAVL nodo=null;
            switch(tipo){
                case "administrador":
                    nodo=avlAdmin.BuscarAdmin(id);
                    if(nodo!=null){
                        Objeto admin=(Objeto)nodo.dato;
                        if(admin.contrasena.equals(contrasena)){
                            return "1";
                        }else{                        
                            return "Usuario admin y contraseña incorrectos";
                        }
                    }                    
                    break;
                case "clave":
                    Objeto clave=(Objeto)avlEs_Clave.Buscar(Integer.parseInt(id));                   
                    if(clave!=null){                        
                        if(clave.contrasena.equals(contrasena)){
                            return "2";
                        }else{                        
                            return "Usuario Estacion Clave y contraseña incorrectos";
                        }
                    }              
                    break;
                case "general":
                    Objeto general=(Objeto)avlEs_General.Buscar(Integer.parseInt(id));                   
                    if(general!=null){                        
                        if(general.contrasena.equals(contrasena)){
                            return "3";
                        }else{                        
                            return "Usuario Estacion General y contraseña incorrectos";
                        }
                    }              
                    break; 
                case "conductor":
                    Objeto conductor=(Objeto)avlConductores.Buscar(Integer.parseInt(id));                   
                    if(conductor!=null){                        
                        if(conductor.contrasena.equals(contrasena)){
                            return "4";
                        }else{                        
                            return "Usuario Conductor y contraseña incorrectos";
                        }
                    }              
                    break;                    
                default:
            }            
        }
        return "-1";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarBus")
    public String BuscarBus(@WebParam(name = "id_estacion") int id_estacion, @WebParam(name = "tipo") String tipo) {
        String bus="No hay buses en cola";
        NodoConductor asignacion=(NodoConductor)avlConductores.BuscarBus(id_estacion);
        if(asignacion!=null){            
            bus=""+asignacion.bus;
            //agregar bus a listabuses de la estacion para registrar los buses que han ingressado a ella
            Date fecha=new Date();
            SimpleDateFormat formato=new SimpleDateFormat("dd:MM:yyyy hh:mm:ss");
            String fecha_hora=formato.format(fecha);
            Ruta registro=new Ruta(fecha_hora, Integer.parseInt(bus));
            asignacion.lista_horas.InsertarFinal(registro);
            asignacion.lista_horas.GraficarHoras();
        }
        bus+="";
        return bus;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "FormGenerales")
    public String FormGenerales() {        
        return avlEs_General.FormGenerales();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Graficar")
    public void Graficar(@WebParam(name = "tipo") String tipo) {
        switch(tipo){
            case "administrador":
                avlAdmin.GraficarAdmin();
                break;
            case "clave":
                    avlEs_Clave.GraficarClave();
                    break;
                case "general":
                    avlEs_General.GraficarGeneral();
                    break; 
                case "conductor":
                    avlConductores.GraficarConductor();
                    break;                    
            default:
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GraficarAsignacion_Horario")
    public void GraficarAsignacion_Horario(@WebParam(name = "id_conductor") String id_conductor, @WebParam(name = "id_bus") String id_bus, @WebParam(name = "tipo") String tipo) {
        int idconductor=Integer.parseInt(id_conductor);
        int idbus=Integer.parseInt(id_conductor);
        Objeto conductor=(Objeto)avlConductores.Buscar(idconductor);
        switch(tipo){
            case "asignacion":                        
                conductor.listabuses.GraficarAsignacion();
                break;
            case"horario":                                
                conductor.listabuses.GraficarHoras();
                break;
            default:
        }
    }


    
}
