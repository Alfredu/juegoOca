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
public class Controlador {
    //======Atributs====//
    private TreeMap<String, Jugador> jugadors;    
    Dau dau;
    Tauler tauler;
    
    //Constructor===//
    
    public Controlador(){
        jugadors = new TreeMap();
        dau = new Dau();
        tauler = new Tauler();
        
    }
    
    //====Metodes===//
    
    
    
    
}
