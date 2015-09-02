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
public class ArbolAVL {
    NodoAVL raiz;

    public ArbolAVL() {
        this.raiz=null;
    }
//rotaciones para la insercion
    private NodoAVL RotacionII(NodoAVL n,NodoAVL n1){
        n.h_izq=n1.h_der;
        n1.h_der=n;
        //modificar fe
        if(n1.fe==-1){
            n.fe=0;
            n1.fe=0;
        }else{
            n.fe=-1;
            n1.fe=1;
        }
        return n1;
    }
    private NodoAVL RotacionDD(NodoAVL n,NodoAVL n1){
        n.h_der=n1.h_izq;
        n1.h_izq=n;
        //modificar fe
        if(n1.fe==1){
            n.fe=0;
            n1.fe=0;
        }else{
            n.fe=1;
            n1.fe=-1;
        }
        return n1;
    }
    private NodoAVL RotacionID(NodoAVL n,NodoAVL n1){
        NodoAVL n2=n1.h_der;
        n.h_izq=n2.h_der;
        n2.h_der=n;
        n1.h_der=n2.h_izq;
        n2.h_izq=n1;
        //modificar fe
        if(n2.fe==1){
            n1.fe=-1;
        }else{
            n1.fe=0;            
        }
        if(n2.fe==-1){
            n.fe=1;
        }else{
            n.fe=0;
        }
        n2.fe=0;
        return n2;
    }
    private NodoAVL RotacionDI(NodoAVL n,NodoAVL n1){
        NodoAVL n2=n1.h_izq;
        n.h_der=n2.h_izq;
        n2.h_izq=n;
        n1.h_izq=n2.h_der;
        n2.h_der=n1;
        //modificar fe
        if(n2.fe==1){
            n.fe=-1;           
        }else{
            n.fe=0;
        }
        if(n2.fe==-1){
            n1.fe=1;
        }else{
            n1.fe=0;    
        }
        n2.fe=0;
        return n2;
    }
    public void Insertar(Object dato){
        VariableBool b=new VariableBool(false);
        raiz=Insertar(raiz,dato,b);
    }
    private NodoAVL Insertar(NodoAVL raiz,Object dato,VariableBool b){
        NodoAVL n1;
        if(raiz==null){
            raiz=new NodoAVL(dato);
            b.setB(true);
        }else {
            //convertir los datos a Objeto, para poder comparar la clave de equilibrio
            Objeto d=(Objeto)dato;
            Objeto r=(Objeto)raiz.dato;
            switch(d.getTipo()){
                case 1://Arbol Administradores
                    if((r.correo.compareTo(d.correo))>0){
                        raiz.h_izq=Insertar(raiz.h_izq,dato,b);
                        //regresar por el camino donde inicio
                        if(b.getb()){
                            //se decrementa fe por aumentar la rama izquierda
                            switch(raiz.fe){
                                case 1:
                                    raiz.fe=0;
                                    b.setB(false);
                                    break;
                                case 0:
                                    raiz.fe=-1;
                                    break;
                                case -1://rotacion a la izquierda
                                    n1=raiz.h_izq;
                                    if(n1.fe==-1){//Izquierda-Izquierda
                                        raiz=RotacionII(raiz, n1);
                                    }else{//Izquierda-Derecha
                                        raiz=RotacionID(raiz, n1);
                                    }
                                b.setB(false);
                                default:
                            }
                        }
                    }else if((r.correo.compareTo(d.correo))<0){
                        raiz.h_der=Insertar(raiz.h_der,dato,b);
                        //regresar por el camino donde inicio
                        if(b.getb()){
                            //se decrementa fe por aumentar la rama derecha
                            switch(raiz.fe){
                                case 1://rotacion derecha
                                    n1=raiz.h_der;
                                    if(n1.fe==1){//Derecha-Derecha
                                        raiz=RotacionDD(raiz, n1);
                                    }else{//Derecha=Izquierda
                                        raiz=RotacionDI(raiz, n1);
                                    }
                                    b.setB(false);
                                    break;
                                case 0:
                                    raiz.fe=1;
                                    break;
                                case -1:
                                    raiz.fe=0;
                                    b.setB(false);
                                default:
                            }
                        }
                    }else{
                        System.out.println("Correo duplicado");
                    }                    
                    break;                    
                default:
            }
        }
        return raiz;                    
    }
    public String PostOrden(){
        String s="";
        s+=PostOrden(raiz);
        return s;
    }
    //metodo recursivo para recorrer arbol
    private String PostOrden(NodoAVL raiz){
        String s="";
        if(raiz!=null){
            s+="h_izq "+PostOrden(raiz.h_izq)+",";
            s+="h_der "+PostOrden(raiz.h_der)+",";
            Objeto o=(Objeto)raiz.dato;
            s+=o.correo +" "+o.contrasena+".";            
        }
        return s;
    }
    public String GraficarAdmin(){
        String s="";
        s+=GraficarAdmin(raiz);
        return s;
    }

    public NodoAVL BuscarAdmin(String correo){    
	return BuscarAdmin(raiz,correo);
    }

    public NodoAVL BuscarAdmin(NodoAVL raiz,String correo){   
        if(raiz!=null){
            Objeto o=(Objeto)raiz.dato;
            if(o.correo==correo){
                return raiz;
            
            }else if((o.correo.compareTo(correo))<0){
                    return BuscarAdmin(raiz.h_izq,correo);

            }else if((o.correo.compareTo(correo))>0){
                return BuscarAdmin(raiz.h_der,correo);
            }            
        }
        return null;      
}
    private String PreOrdenGraficarAdmin(NodoAVL nodo){    
            String s="";    
            int cont=0;
            if(nodo!=null){
                Objeto o=(Objeto)nodo.dato;
                s+="nodo"+o.correo+"[label=\"";                
                s+="Correo: "+o.correo+"\n";
                s+="Contraseña: "+o.contrasena+"\"];\n";                
                String izq= PreOrdenGraficarAdmin(nodo.h_izq);
                if(izq!=""){
                    s+=izq;
                    s+="nodo"+o.correo+" -> nodo"+o.correo+"h_izq"+";\n";
                }
                String der=PreOrdenGraficarAdmin(nodo.h_der);
                if(der!=""){
                    s+=der;
                    s+="nodo"+o.correo+" -> nodo"+o.correo+"h_der"+";\n";
                }
            }
            return s;
    }
    
    private String GraficarAdmin(NodoAVL raiz){
        String s="digraph G{\n";
        s+="subgraph cluster999 {\n";
        s+="style=filled;\n";
        s+="color=skyblue;\n";
        s+="node [shape=box,style=filled,color=coral];\n";
        s+="edge [arrowhead=none,arrowtail=none];\n";   
        s+="label=\"AVL Administradores\";\n";
        s+=PreOrdenGraficarAdmin(raiz);
        s+="}\n}\n";
        return s;
    }
}
