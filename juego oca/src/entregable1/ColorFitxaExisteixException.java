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
//Excepcio que es llança quan s'intenta afegir un jugador indicant el seu color de fitxa i aquest
//ja existeix
public class ColorFitxaExisteixException extends Exception {

    /**
     * Creates a new instance of <code>ColorFitxaExisteixException</code>
     * without detail message.
     */
    public ColorFitxaExisteixException() {
    }

    /**
     * Constructs an instance of <code>ColorFitxaExisteixException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ColorFitxaExisteixException(String msg) {
        super(msg);
    }
}
