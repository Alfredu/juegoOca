/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author aleix
 */
public class Controlador {
    //======Atributs====//
    private TreeMap<String, Jugador> jugadors;    
    Dau dau;
    Tauler tauler;
    
    //Constructor===//
    
    public Controlador(InterficieUsuari iu){
        jugadors = new TreeMap();
        dau = new Dau();
        tauler = new Tauler();
        
    }
    
    //====Metodes===//
    
    public int afegeixJugador(String nomArg, String colorArg){
        Iterator<String> it = jugadors.keySet().iterator();
        int coincidencia = 0;
   
        while(it.hasNext() && coincidencia == 0){
            String colorIterador = it.next();
            
            if(colorIterador.equalsIgnoreCase(colorArg)){                
                coincidencia = -1;         
            }
        }
        
        switch (coincidencia){
     
                case    0 : 
                    jugadors.put(colorArg, new Jugador(nomArg, colorArg, this.dau, this.tauler));
                    return coincidencia;
                default : return coincidencia;
                    
            }
        
    }
    
    
    
    
}
