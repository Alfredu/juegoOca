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
        if(jugadors.containsKey(colorArg)){
            return -1;
        }
              
        else{
           jugadors.put(colorArg, new Jugador(nomArg, colorArg, this.dau, this.tauler));
            return 0;
        }
    }
    
    public int eliminaJugador(String colorArg){
       Jugador eliminat =  jugadors.remove(colorArg);
       
       if(eliminat==null){
           return -1;
       }
       
       else{
           return 0;
       }
    }
    
    
    
    
}
