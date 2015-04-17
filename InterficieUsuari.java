/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.Scanner;

/**
 *
 * @author aleix
 */

public class InterficieUsuari {

    //Atributs=======//
    private Controlador controlador;
    private Scanner scanner;

    //Constructor
    public InterficieUsuari() {
        controlador = new Controlador(this);
        scanner = new Scanner(System.in);

    }

    //Mètodes=========//
    public void altaJugador() {
        String nom, color;
        int error;

        System.out.println("Nom del jugador: ");
        nom = scanner.nextLine();

        System.out.println("Color de la fitxa:");
        color = scanner.nextLine();

        error = controlador.afegeixJugador(nom, color);

        if (error == 0) {
            System.out.println("Jugador afegit correctament");
        }

        if (error == -1) {
            System.out.println("Ja hi ha un altre jugador controlant una fitxa d'aquest color");
        }

    }

    public void eliminaJugador() {
        String color;
        int error;

        System.out.println("Color de la fitxa: ");
        color = scanner.next();
        error = controlador.eliminaJugador(color);

        if (error == 0) {
            System.out.println("Jugador eliminat correctament.");
        }

        if (error == -1) {
            System.out.println("No hi ha cap jugador controlant una fitxa d'aquest color");
        }
    }

    public void iniciarPartida() {
        int status = this.controlador.jugarPartida();

        if(status<0){
            this.mostraPerPantalla("No es pot iniciar la partida, afegeix com a minim 2 jugadors per jugar");
            
        }
    }

    public static void main(String[] args) {
        InterficieUsuari iu = new InterficieUsuari();
        iu.run();
    }

    public void mostraComandes() {
        this.mostraPerPantalla("Introdueix una de les comandes de la llista\nalta - Afegeix un nou jugador a la partida\nelimina - Elimina un dels jugadors afegits prèviament a la partida\ninicia - Inicia la partida amb els jugadors introduïts\najuda - Mostra novament les comandes vàlides per a l'aplicació\nsurt - Surt del joc de la oca");
    }

    public void mostraPerPantalla(String msgArg) {
        System.out.println(msgArg);
    }

    public void run() {
        String stringComandes = ("alta elimina inicia ajuda surt");
        String[] arrayComandes = stringComandes.split(" ");
        String opcioTriada;
        boolean final_programa=false;
        
        this.mostraPerPantalla("Benvinguts a l'aplicació del joc de la oca de MOO");
        this.mostraComandes();
        
        
        while(!final_programa){
            opcioTriada = scanner.nextLine();
            if(opcioTriada.equals(arrayComandes[0])){
                this.altaJugador();
            }
            else if(opcioTriada.equals(arrayComandes[1])){
                this.eliminaJugador();
            }
            else if(opcioTriada.equals(arrayComandes[2])){
                this.iniciarPartida();
            }
            else if(opcioTriada.equals(arrayComandes[3])){
                this.mostraComandes();
            }
            else if(opcioTriada.equals(arrayComandes[4])){
                this.mostraPerPantalla("Sortint del joc de la oca...");
                final_programa=true;
                
            }
            else{
                this.mostraPerPantalla("Comanda incorrecta. Necessites ajuda? escriu 'ajuda' per obtenir una llista de comandes vàlides");
            }
        }
        
    }

}
