/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;
import java.util.*;

/**
 *
 * @author aleix
 */
public class Preso extends Casella {
	public static final int TORNS_SENSE_TIRAR = 3;
	private HashMap<Fitxa,java.lang.Integer> empresonades;
	public Preso(int numeroArg, String descripcioArg){
		super(numeroArg, descripcioArg);
	}
	@Override 
	public boolean completaJugada(Jugador jugador, List<java.lang.String> messages){
            //El jugador es queda sense tirar 3 torns, i és notificat.
		jugador.setTornsSenseTirar(TORNS_SENSE_TIRAR);
		messages.add("Has caigut a la casella Preso. Estaràs 3 torns sense tirar.");
		return false;
	}
}
