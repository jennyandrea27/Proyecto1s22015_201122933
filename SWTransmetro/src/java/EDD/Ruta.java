/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author Jenny Andrea Simeon Perez
 */
public class Ruta {
    public String nombre;
    public int id;
    public ListaD listaEstaciones;

    /**
     * Constructor Ruta
     * @param nombre
     * @param id
     * @param listaEstaciones 
     */
    public Ruta(String nombre, int id, ListaD listaEstaciones) {
        this.nombre = nombre;
        this.id = id;
        this.listaEstaciones = listaEstaciones;
    }

    public Ruta(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.listaEstaciones=new ListaD();
    }
    
    
}
