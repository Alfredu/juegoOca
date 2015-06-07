/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aleix sanchis
 * @author marta cosano
 */
public class Controlador {

    //======Atributs====//
    private HashMap<String, Jugador> jugadors;//Mapa de jugadors identificats pel seu color de fitxa
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
    //Afegeix un jugador si el color de la seva fitxa no esta en us ja.
    public void afegeixJugador(String nomArg, String colorArg) throws ColorFitxaExisteixException {
        if (jugadors.containsKey(colorArg)) {

            throw new ColorFitxaExisteixException();
        }
        jugadors.put(colorArg, new Jugador(nomArg, colorArg, this.dau, this.tauler));

    }

    //Donat un color, elimina el jugador que el te com a clau del mapa de jugadors ( si existeix)
    public void eliminaJugador(String colorArg) throws ColorFitxaNoExisteixException {
        Jugador eliminat = jugadors.remove(colorArg);

        if (eliminat == null) {
            throw new ColorFitxaNoExisteixException();
        }
    }

    //Si ha com a minim dos jugadors, recorrre el mapa de jugadors i cada un juga el seu torn fins que algu guanya
    public void jugarPartida() throws FaltenJugadorsException {
        List<String> missatges = new ArrayList<String>();
        if (jugadors.size() < 2) {
            throw new FaltenJugadorsException();
        }

        boolean partidaAcabada = false;
        int torn = 1;
        //Situem tots els jugadors a la casella 1, i fem un reset dels torns sense tirar, perque si 
        //acabes la partida amb un jugador a la preso, començaria la seguent encara a dins.
        Iterator<Jugador> itJugador = jugadors.values().iterator();
        while (itJugador.hasNext()) {
            Jugador jugadorIterant = itJugador.next();
            tauler.situaFitxa(jugadorIterant.getFitxa(), 1);
            jugadorIterant.setTornsSenseTirar(0);
        }
        //Tornem a posar literador a la primera posicio.
        itJugador = jugadors.values().iterator();
        while (!partidaAcabada) {
            while (itJugador.hasNext() && !partidaAcabada) {
                Jugador jugadorIterant = itJugador.next();
                Fitxa fitxaJugadorIterant = jugadorIterant.getFitxa();
                this.iu.mostraPerPantalla("\nTorn numero: " + torn);
                this.iu.mostraPerPantalla("Juga el seu torn " + jugadorIterant.getNom());
                this.iu.mostraPerPantalla("Controla la fitxa de color " + fitxaJugadorIterant.getColor());
                this.iu.mostraPerPantalla("Situada a la casella " + jugadorIterant.numeroCasellaFitxaJugador()
                        + "(" + fitxaJugadorIterant.getCasella().getDescripcio() + ")");
                //Si el jugador no es a la preso, tira.
                if (jugadorIterant.PotTirar()) {
                    partidaAcabada = jugadorIterant.jugarTorn();
                    this.iu.mostraPerPantalla("Valor del dau: " + this.dau.getValor());
                    this.iu.mostraPerPantalla("Casella desti: " + jugadorIterant.numeroCasellaFitxaJugador());
                    //Si el jugador no ha guanyat tirant el dau, es crida a completaJugada.
                    if (!partidaAcabada) {
                        missatges.clear();
                        partidaAcabada = jugadorIterant.getFitxa().getCasella().completaJugada(jugadorIterant, missatges);
                        this.presentaMensajes(missatges);
                    }
                } //Si el jugador esta a la preso
                else {

                    this.iu.mostraPerPantalla("Encara no has complert suficients torns a la Presó i no pots tirar.");
                    jugadorIterant.decrementaTornsSenseTirar();
                }

                if (partidaAcabada) {
                    iu.mostraPerPantalla("El jugador " + jugadorIterant.getNom() + " guanya la partida!!!!");
                }

            }

            itJugador = jugadors.values().iterator();
            torn++;
        }
    }
    /*Metode que printa tots els missatges de una llista de missatges passada per parametre*/

    public void presentaMensajes(List<String> missatges) {
        Iterator<String> itMissatges = missatges.iterator();
        while (itMissatges.hasNext()) {
            this.iu.mostraPerPantalla(itMissatges.next());
        }
    }

}
