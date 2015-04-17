/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author aleix
 */
public class Controlador {

    //======Atributs====//
    private HashMap<String, Jugador> jugadors;
    private Dau dau;
    private Tauler tauler;
    private InterficieUsuari iu;

    //Constructor===//
    public Controlador(InterficieUsuari iuArg) {
        jugadors = new HashMap();
        dau = new Dau();
        tauler = new Tauler();
        this.iu = iuArg;

    }

    //====Metodes===//
    public int afegeixJugador(String nomArg, String colorArg) {
        if (jugadors.containsKey(colorArg)) {
            return -1;
        } else {
            jugadors.put(colorArg, new Jugador(nomArg, colorArg, this.dau, this.tauler));
            return 0;
        }
    }

    public int eliminaJugador(String colorArg) {
        Jugador eliminat = jugadors.remove(colorArg);

        if (eliminat == null) {
            return -1;
        } else {
            return 0;
        }
    }

    public int jugarPartida() {
        if (jugadors.size() < 2) return -1;
        
        Iterator<Jugador> it_jugador = jugadors.values().iterator();
        boolean partida_acabada = false;
        int torn = 1;

        if (jugadors.size() < 2) {
            return -1;
        }

        while (it_jugador.hasNext()) {
            Jugador jugador_iterar = it_jugador.next();
            tauler.situaFitxa(jugador_iterar.getFitxa(), 1);
        }
        it_jugador = jugadors.values().iterator();
        Jugador jugador_iterant = it_jugador.next();
        Fitxa fitxa_jugador_iterant = jugador_iterant.getFitxa();

        while (!partida_acabada){
            this.iu.mostraPerPantalla("\nTorn numero: " + torn);
            this.iu.mostraPerPantalla("Juga el seu torn " + jugador_iterant.getNom());
            this.iu.mostraPerPantalla("Controla la fitxa de color " + fitxa_jugador_iterant.getColor());
            this.iu.mostraPerPantalla("Situada a la casella " + jugador_iterant.numeroCasellaFitxaJugador()
                    + "(" + fitxa_jugador_iterant.getCasella().getDescripcio() + ")");

            partida_acabada = jugador_iterant.jugarTorn();
            this.iu.mostraPerPantalla("Valor del dau: " + this.dau.getValor());
            this.iu.mostraPerPantalla("Casella desti: " + jugador_iterant.numeroCasellaFitxaJugador());
            
            if(partida_acabada) iu.mostraPerPantalla("El jugador "+ jugador_iterant.getNom()+" guanya la partida!!!!");
            
            if (it_jugador.hasNext()) {
                jugador_iterant = it_jugador.next();
                fitxa_jugador_iterant = jugador_iterant.getFitxa();
            } else {
                it_jugador = jugadors.values().iterator();
                jugador_iterant = it_jugador.next();
                fitxa_jugador_iterant = jugador_iterant.getFitxa();
                torn++;
            }
            
        }
        return 0;
    }
}
