/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author jenny
 */
public class ListaD {
    public Nodo pinicio,pfinal;
    int cantidad=0;
    
    public ListaD(){
        pinicio=null;
        pfinal=null;
    }
    public boolean Vacia(){
        if(pinicio==null && pfinal==null){
            return true;
        }
        return false;
    }
    
    public void InsertarFinal(Object nuevo){
        Nodo nodo=new Nodo(nuevo);
        if(!Vacia()){
            pfinal.siguiente=nodo;
            nodo.anterior=pfinal;
            pfinal=nodo;
            cantidad++;
        }else{
            pinicio=pfinal=nodo;
            cantidad++;
        }        
    }
    public Object EliminarFinal(){
        if(!Vacia()){
            Object temp=pfinal.dato;            
            if(pinicio==pfinal){
                pinicio=null;
                pfinal=null;
                cantidad--;
                System.out.println("Elemento eliminado");
                return temp;
            }
            
            pfinal=pfinal.anterior;
            pfinal.siguiente.anterior=null;
            pfinal.siguiente=null;
            cantidad--;
            System.out.println("Elemento eliminado");
            return temp;
        }else{
            return null;
        }
    }
    
    private void InsertarInicio(Object nuevo){
        Nodo nodo=new Nodo(nuevo);
        if(!Vacia()){
            pinicio.anterior=nodo;
            nodo.siguiente=pinicio;
            pinicio=nodo;
            cantidad++;
        }else{
            pinicio=pfinal=nodo;
            cantidad++;
        }
    }
    public void InsertarRuta(Object nuevo){
        Ruta ruta=(Ruta)nuevo;
        if(BuscarRuta(ruta.id)==null){
            InsertarFinal(nuevo);
        }
    }
    public void InsertarBus(Object nuevo){
        int bus=(int)nuevo;
        if(BuscarBus(bus)==null){
            InsertarFinal(nuevo);
        }
    }
    public Object EliminarInicio(){
        if(!Vacia()){
            Object temp=pinicio.dato;
            if(pinicio==pfinal){
                pinicio=null;
                pfinal=null;
                cantidad--;
                System.out.println("Elemento eliminado");
                return temp;
            }
            pinicio=pinicio.siguiente;
            pinicio.anterior.siguiente=null;
            pinicio.anterior=null;
            cantidad--;
            System.out.println("Elemento eliminado");
            return temp;
        }else{
            return null;
        }
    }
    public void Imprimir(){
        if(!Vacia()){
            Nodo temp=pinicio;
            while(temp!=null){
                System.out.println("Nodo:"+temp.dato);
                temp=temp.siguiente;
        }            
        }else{
            System.out.println("Lista Vacia");
        }
    }
    public int getCantidad(){
        return cantidad;
    }
    public Nodo BuscarRuta(int id){
        Nodo temp=pinicio;        
        while(temp!=null){
            Ruta ruta=(Ruta)temp.dato;
            if (ruta.id==id){
                return temp;
            }
            temp=temp.siguiente;
        }
        return null;
    }
    public Nodo BuscarBus(int id){
        Nodo temp=pinicio;        
        while(temp!=null){
            int bus=(int)temp.dato;
            if (bus==id){
                return temp;
            }
            temp=temp.siguiente;
        }
        return null;
    }
    public Nodo BuscarElemento(int pos){
        Nodo temp=pinicio;
        int num=0;
        while(temp!=null){
            if (num==pos){
                return temp;
            }else{
                num++;
            }
            temp=temp.siguiente;
        }
        return null;
    }
    public Nodo Eliminar(int pos){
        Nodo temp=BuscarElemento(pos);
        if(temp!=null){
            if(temp==pinicio ){//primer elemento
                if(temp==pfinal){//unico elemento en la lista
                    pinicio=null;
                    pfinal=null;
                    cantidad--;
                    System.out.println("Elemento eliminado");
                    return temp;
                }else{
                    Nodo siguiente=temp.siguiente;
                    siguiente.anterior=null;
                    temp.siguiente=null;
                    pinicio=siguiente;
                    cantidad--;
                    System.out.println("Elemento eliminado");
                    return temp;
                }
                
            }else if(temp==pfinal){//ultimo elemento
                Nodo anterior=temp.anterior;
                anterior.siguiente=null;
                temp.anterior=null;
                pfinal=anterior;
                cantidad--;
                System.out.println("Elemento eliminado");
                return temp;
            }else{//en medio
                Nodo anterior=temp.anterior;
                anterior.siguiente=temp.siguiente;
                temp.siguiente.anterior=anterior;
                temp.anterior=null;            
                temp.siguiente=null;
                cantidad--;
                System.out.println("Elemento eliminado");                
                return temp;
            }                        
        }else{
            System.out.println("Elemento no encontrado");
        }        
        return temp;
    }
    public void Reemplazar(int pos,Object dato){
        Nodo temp=BuscarElemento(pos);
        if(temp!=null){
            //reemplaza el dato del nodo encontrado
           temp.dato=dato;
            System.out.println("Nodo reemplazado");
        }else{
            System.out.println("no se reemplazo objeto");
        }
        
    }
    public void GenerarLista(JPanel panel){
        
    }
    public String ResumenObjetos(){
        String s="";
        return s;
    }
    public void GraficarBus(){
        String s="";
        s+="digraph G{\n";
        s+="subgraph cluster1{\n";
        s+="node [shape=parallelogram,style=filled,color=forestgreen];\n";
        s+="style=filled;\n";
        s+="color=green;\n";
        s+="edge [arrowhead=diamond,arrowtail=diamond,dir=both];\n";
        s+="label=\"LISTA DOBLEMENTE ENLAZADA\nBUSES\";\n";
        Nodo temp=pinicio;
        int cont=0;
        while(temp!=null){
            //declaracion de nodos
            int id=(int)temp.dato;
            s+="nodo"+cont+"[label=\"Id: "+id+"\"];\n";
            //enlaces
            if(temp.siguiente!=null){
                s+="nodo"+cont+"->"+"nodo"+(cont+1)+";\n";
            }
            cont++;
            temp=temp.siguiente;
        }
        s+="}\n}";
        //generar archivo .dot
        GenerarDot(s);
    }
    public void GraficarRuta(){
        String s="";
        s+="digraph G{\n";
        s+="subgraph cluster9999{\n";
        s+="node [shape=parallelogram,style=filled,color=greenyellow];\n";
        s+="style=filled;\n";
        s+="color=lightblue;\n";
        s+="edge [arrowhead=diamond,arrowtail=diamond,dir=both];\n";
        s+="label=\"LISTA DOBLEMENTE ENLAZADA\nRUTAS\";\n";
        Nodo temp=pinicio;
        int cont=0;
        while(temp!=null){
            //declaracion de nodos
            Ruta ruta=(Ruta)temp.dato;
            s+="nodo"+cont+"[label=\"Id: "+ruta.id+"\n";
            s+="Nombre: "+ruta.nombre+"\"];\n";
            //enlaces
            if(temp.siguiente!=null){
                s+="nodo"+cont+"->nodo"+(cont+1)+";\n";
            }
            //generar lista de estaciones  
            try{
                Nodo e=ruta.listaEstaciones.pinicio;                
                if(e!=null){                    
                    Objeto estacion=(Objeto)e.dato;
                    s+="nodo"+cont+"->node"+cont+estacion.id+";\n";
                    s+="subgraph cluster"+ruta.id+"{\n";
                    s+="node [style=filled,color=lightgray];\n";
                    s+="style=filled;\n";
                    s+="color=white;\n";
                    s+="label=\"Estaciones ruta "+ruta.id+"\";\n";
                    while(e!=null){
                        estacion=(Objeto)e.dato;   
                        //declaracion nodos
                        s+="node"+cont+estacion.id+"[label=\"Estacion: "+estacion.id+"\n";
                        s+="Nombre: "+estacion.nombre+"\n";
                        s+="Tipo: "+estacion.tipo+"\"];\n";
                        //enlaces
                        if(e.siguiente!=null){
                            Objeto estacion_sig=(Objeto)e.siguiente.dato;
                            s+="node"+cont+estacion.id+"->node"+cont+estacion_sig.id+";\n";
                        }
                        e=e.siguiente;
                    }
                    s+="}\n";                    
                }
            }catch(Exception e){
                
            }
            
            
            cont++;
            temp=temp.siguiente;
        }
        s+="}\n}";
        //generar archivo .dot
        GenerarDot(s);
    }
    private void GenerarDot(String s){
        FileWriter dir=null;
        PrintWriter print=null;
        try{
            dir=new FileWriter("C:\\Users\\Jenny\\Desktop\\grafica.dot");
            print=new PrintWriter(dir);
            print.println(s);
            print.close();
            dir.close();            
            GenerarPNG();
        }catch(Exception er){
            
        }            
    }
    private void GenerarPNG(){
        try{
            ProcessBuilder proceso=new ProcessBuilder("C:\\Program Files\\Graphviz2.38\\bin\\dot.exe","-Tpng","-o","C:\\Users\\Jenny\\Desktop\\grafica.png","C:\\Users\\Jenny\\Desktop\\grafica.dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        }catch(Exception er){
            System.out.println(er.getMessage());    
        }
    }
}
