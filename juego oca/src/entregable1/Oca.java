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
public class Oca extends Casella {
	//Atributs

    //Consctructor
    public Oca(int numeroArg, String descripcioArg) {
        super(numeroArg, descripcioArg);
    }

    //Metodes
    @Override
    public boolean completaJugada(Jugador jugador, List<java.lang.String> messages) {
        messages.add("Estas a la casella " + this.getNumero() + " i es una oca");
        messages.add("D'Oca a Oca i tiro perquè em toca!");
        //Si hi ha una seguent oca, el jugador hi salta i torna a tirar
        if (jugador.getTauler().getSeguentOca(this.getNumero()) != null) {
            Casella seguentOca = jugador.getTauler().getSeguentOca(this.getNumero());
            jugador.mouFitxa(seguentOca.getNumero());
            messages.add("Saltes a la casella "+jugador.numeroCasellaFitxaJugador());
        }
        //Si no hi ha una seguent oca vol dir que estem a la casella 59, i per tant saltem
        //al jardi de la oca i guanyem la partida.
        else{
            messages.add("Saltes al jardí de l'Oca.");
            return true;
        }
        //El jugador torna a tirar. Si guanya es retorna true..
        boolean haGuanyat = jugador.jugarTorn();
        if (haGuanyat) {
            return haGuanyat;
        } else {
            //..Si no, es retorna el resultat de completar la jugada en la casella on s'ha caigut.
            messages.add("Has tirat un " + jugador.getDau().getValor() + " i caus a la casella " + jugador.numeroCasellaFitxaJugador());
            return jugador.getFitxa().getCasella().completaJugada(jugador, messages);
        }
        

    }
}
