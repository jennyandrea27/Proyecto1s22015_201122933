/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Nodo para manejar asignaciones a conductores
 * @author Jenny Andrea Simeon Perez
 */
public class NodoConductor {
    public int bus;
    public Ruta ruta;
    public Date hora_inicio,hora_fin;
    public Date fecha;   
    SimpleDateFormat formato_hora=new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat formato_fecha=new SimpleDateFormat("dd:MM:yyyy");
    public ListaD lista_horas;
    
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
        this.lista_horas=new ListaD();
    }
    public String getHora(Date hora){
        return formato_hora.format(hora);
    }
    public String getFecha(Date fecha){
        return formato_fecha.format(fecha);
    }
    
}
