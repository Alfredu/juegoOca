/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

/**
 *
 * @author aleix
 */
public class Fitxa {
    //Atributs========//
    private String color;
    private Casella casellaActual;
    private Jugador jugador;
    
    
    //Constructor=======//
    public Fitxa(String colorArg, Jugador jugadorArg, Casella casellaArg){
        this.color = colorArg;
        this.casellaActual = casellaArg;
        this.jugador = jugadorArg;     
    }
    
    //Metodes=======//   
    public Casella getCasella() {
        return this.casellaActual;
    }
    
    public String getColor(){
        return this.color;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    public void setCasella(Casella casellaArg) {
        this.casellaActual = casellaArg;
    }
    
    
}
