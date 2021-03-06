/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author jenny
 */
public class Objeto {
    public String nombre,apellido,correo,contrasena,tipo;
    public int id;
    public ListaD listabuses;
    public boolean visita=false;
    /**
     * Constructor conductor
     * @param nombre
     * @param apellido
     * @param contrasena
     * @param tipo
     * @param id 
     */
    public Objeto(String nombre, String apellido, String contrasena, String tipo, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.tipo = tipo;
        this.id = id;
        this.listabuses=new ListaD();
        this.visita=false;        
    }
    /**
     * Constructor admin
     * @param correo
     * @param contrasena
     * @param tipo 
     */
    public Objeto(String correo, String contrasena, String tipo) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }
    /**
     * Constructor Estaciones
     * es_clave
     * es_general
     * @param nombre
     * @param contrasena
     * @param tipo
     * @param id 
     */
    public Objeto(String nombre, String contrasena, String tipo, int id) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tipo = tipo;
        this.id = id;
    }
    /**
     * Constructor para duplicar objeto
     * es_clave
     * es_general
     * @param nombre
     * @param contrasena
     * @param tipo
     * @param id 
     */
    public Objeto Duplicar(){
        Objeto o= new Objeto("", "", "", 0);
        o.nombre=this.nombre;
        o.apellido=this.apellido;
        o.correo=this.correo;
        o.contrasena=this.contrasena;
        o.tipo=this.tipo;
        o.id=this.id;
        o.visita=false;
        return o;
    }        
           
    void Imprimir(){
        System.out.println("Objeto "+this.tipo+" "+this.nombre);
    }
    public int getTipo(){
        if(tipo.equals("admin")){
            return 1;
        }else if(tipo.equals("es_clave")){
            return 2;
        }else if(tipo.equals("es_general")){
            return 3;
        }else if(tipo.equals("conductor")){
            return 4;
        }else if(tipo.equals("bus")){
            return 5;
        }else if(tipo.equals("ruta")){
            return 6;
        }
    return -1;
    }
}
