/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aleix
 */
public class Casella {

    //Atributs=============//

    private int numero;
    private String descripcio;
   
    //Mapa de fitxes identificada cada una pel seu atribut unic color
    private HashMap<String, Fitxa> fitxes;

    //Constructor============//
    public Casella(int numeroArg, String descripcioArg) {
        this.numero = numeroArg;
        this.descripcio = descripcioArg;
        this.fitxes = new HashMap();
    }

    //Metodes===============//   
    public void eliminaFitxa(Fitxa fitxaArg) {
        fitxes.remove(fitxaArg.getColor());
        //fitxaArg.setCasella(null);???
    }
    //Retorna la descripcio de la casella
    public String getDescripcio() {
        return this.descripcio;
    }
    //retorna la fitxa del mapa que te com a clau el color pasat per parametre
    public Fitxa getFitxa(String color) {
        return this.fitxes.get(color);
    }

    //Retorna el numero de la casella (+1 perque l'array de caselles va de 0 a 62);
    public int getNumero() {
        return this.numero + 1;
    }
    //Donada una fitxa la situa al mapa de fitxes de la casella i actualitza la casella actual de la fitxa a la casella des d'on sinvoca el metode
    public void situaFitxa(Fitxa fitxa) {
        fitxes.put(fitxa.getColor(), fitxa);
        fitxa.setCasella(this);
    }
	
	public boolean completaJugada(Jugador jugador, List<java.lang.String> messages){
		messages.add("Has caigut en una casella convencional");
		return false;
	}

}
