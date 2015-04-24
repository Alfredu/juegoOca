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
public class Jugador {

    //====Atributs=====//

    private String nom;
    private Dau dau;
    private Fitxa fitxa;
    private Tauler tauler;

    //====Constructor===// 
    //Instanciem els atributs del Jugador i li asignem una fitxa nova situada a la casella 1;
    public Jugador(String nomArg, String colorArg, Dau dauArg, Tauler taulerArg) {
        this.nom = nomArg;
        this.tauler = taulerArg;
        this.dau = dauArg;
        this.fitxa = new Fitxa(colorArg, this, this.tauler.getCasella(1));
        
        

    }

    //==Metodes===// 
    //Retorna el dau del Jugador
    public Dau getDau() {
        return this.dau;
    }
    //Retorna la fitxa del Jugador
    public Fitxa getFitxa() {
        return this.fitxa;
    }
    //Retorna el nom del Jugador
    String getNom() {
        return this.nom;
    }
    //Juga el torn del Jugador
    public boolean jugarTorn() {
        int casellaOrigen = this.numeroCasellaFitxaJugador();
        int numeroDau = this.tiraDau();

        if (casellaOrigen + numeroDau > 63) {
            this.mouFitxa(63 - (casellaOrigen + numeroDau - 63));
        } else {
            this.mouFitxa(casellaOrigen + numeroDau);
        }

        return this.numeroCasellaFitxaJugador() == 63;
    }
    //Elimina la fitxa de la casella on esta i la coloca a una altra posicio indicada
    public void mouFitxa(int numCasellaDestiArg) {

        this.tauler.eliminaFitxes(this.fitxa, this.numeroCasellaFitxaJugador());
        this.tauler.situaFitxa(this.fitxa, numCasellaDestiArg);
    }
    //Retorna el numero de la casella on esta la fitxa del jugador.
    public int numeroCasellaFitxaJugador() {
        return this.fitxa.getCasella().getNumero();
    }
    //Metode que tira el dau del jugador i en retorna el valor aleatori que surt.
    public int tiraDau() {
        this.dau.tirar();
        return this.dau.getValor();
    }

}
