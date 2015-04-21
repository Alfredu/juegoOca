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
public class Tauler {

    //======Atributs====//
    private Casella[] caselles;

    //======Constructor===//
    public Tauler() {
        this.caselles = new Casella[63];
        for (int i = 0; i < 63; i++) {

            caselles[i] = new Casella(i, "Casella convencional");
        }
    }

    //=====Metodes========//
    //-1 perque la casella 1 es el array[0]
    public void eliminaFitxes(Fitxa fitxaArg, int numeroArg) {
        caselles[numeroArg - 1].eliminaFitxa(fitxaArg);
    }

    //-1 perque la casella 1 es el array[0]

    public Casella getCasella(int numeroArg) {
        return caselles[numeroArg - 1];
    }

    //-1 perque la casella 1 es el array[0]

    public void situaFitxa(Fitxa fitxaArg, int numeroArg) {
        caselles[numeroArg - 1].situaFitxa(fitxaArg);
    }
}
