/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.TreeMap;

/**
 *
 * @author aleix
 */
public class Casella {
    //Atributs=============//
    private int numero;
    private String descripcio;
    
    private TreeMap<String, Fitxa> fitxes;

    //Constructor============//
    public Casella(int numeroArg, String descripcioArg) {
        this.numero = numeroArg;
        this.descripcio = descripcioArg;
        this.fitxes = new TreeMap();    
    }
   
    //Metodes===============//   
    
    public void eliminaFitxa(Fitxa fitxaArg){
        fitxes.remove(fitxaArg.getColor());
    }
    
    public String getDescripcio( ){
        return this.descripcio;
    }
    
    public Fitxa getFitxa(String color){
        return this.fitxes.get(color);
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void situaFitxa(Fitxa fitxa){
        fitxes.put(fitxa.getColor(), fitxa);
    }
    
    
    
}
