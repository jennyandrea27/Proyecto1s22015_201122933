/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author Jenny
 */
public class NodoAVL {
    int fe;
    NodoAVL  h_izq,h_der;
    public Object dato;
    
    /**
     * Constructor NodoAVL
     * @param dato 
     */
    public NodoAVL(Object dato) {
        this.dato=dato;
        this.fe=0;
        this.h_der=null;
        this.h_izq=null;
    }
    
}
