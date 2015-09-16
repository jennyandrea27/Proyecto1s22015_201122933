/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import java.util.Date;

/**
 *Nodo para manejar asignaciones a conductores
 * @author Jenny Andrea Simeon Perez
 */
public class NodoConductor {
    int bus;
    Ruta ruta;
    Date hora_inicio,hora_fin;
    Date fecha;   
/**
 * 
 * @param bus int
 * @param ruta Ruta
 * @param hora_inicio Date
 * @param hora_fin Date
 * @param fecha Date
 */
    public NodoConductor(int bus, Ruta ruta, Date hora_inicio, Date hora_fin, Date fecha) {
        this.bus = bus;
        this.ruta = ruta;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha = fecha;
    }
    
}
