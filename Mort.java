/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.List;

/**
 *
 * @author aleix
 */
public class Mort extends Casella{
	public Mort(int numeroArg, String descripcioArg){
		super(numeroArg, descripcioArg);
	}
	
	@Override
	public boolean completaJugada(Jugador jugador, List<java.lang.String> messages){
		messages.add("Has caigut a la casella mort");
		jugador.mouFitxa(1);
		return false;
	}
}
