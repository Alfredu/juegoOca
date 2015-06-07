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
//Excepcio que es llança quan s'intenta eliminar un jugador indicant el seu color de fitxa i aquest
//no existeix
public class ColorFitxaNoExisteixException extends Exception {

    /**
     * Creates a new instance of <code>ColorFitxaNoExisteixException</code>
     * without detail message.
     */
    public ColorFitxaNoExisteixException() {
    }

    /**
     * Constructs an instance of <code>ColorFitxaNoExisteixException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ColorFitxaNoExisteixException(String msg) {
        super(msg);
    }
}
