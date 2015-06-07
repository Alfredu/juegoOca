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
        controlador = new Controlador(this);//Crea un nou controlador i es passa a si mateix com a parametre 
        scanner = new Scanner(System.in);//Scanner per llegir inputs dusuari

    }

    //Mètodes=========//
    public void altaJugador() throws ColorFitxaExisteixException {
        String nom, color;

        System.out.println("Nom del jugador: ");//Llegeix el nom que introdueix lusuari per teclat
        nom = scanner.nextLine();

        System.out.println("Color de la fitxa:");//Igual amb el color
        color = scanner.nextLine();

        controlador.afegeixJugador(nom, color);//Crea un nou jugador i guardem el retorn 

        System.out.println("Jugador afegit correctament");

    }

    public void eliminaJugador() throws ColorFitxaNoExisteixException {
        String color;
        System.out.println("Color de la fitxa: ");
        color = scanner.nextLine();
        controlador.eliminaJugador(color);

        System.out.println("Jugador eliminat correctament.");

    }

    public void iniciarPartida() throws FaltenJugadorsException {
        this.controlador.jugarPartida();

    }

    public static void main(String[] args) {
        InterficieUsuari iu = new InterficieUsuari();
        iu.run();//Arranca el joc 
    }

    public void mostraComandes() {//Mostra les comandes vàlides
        this.mostraPerPantalla("Introdueix una de les comandes de la llista\nalta - Afegeix un nou jugador a la partida\nelimina - Elimina un dels jugadors afegits prèviament a la partida\ninicia - Inicia la partida amb els jugadors introduïts\najuda - Mostra novament les comandes vàlides per a l'aplicació\nsurt - Surt del joc de la oca");
    }

    public void mostraPerPantalla(String msgArg) {//Printa el missatge passat per parametre.
        System.out.println(msgArg);
    }

    public void run() {//Metode principal del joc
        String stringComandes = ("alta elimina inicia ajuda surt");
        //Array de Strings amb les opcions disponibles
        String[] arrayComandes = stringComandes.split(" ");
        String opcioTriada;
        boolean final_programa = false;

        this.mostraPerPantalla("Benvinguts a l'aplicació del joc de la oca de MOO");
        this.mostraComandes();

        while (!final_programa) {
            try {
                opcioTriada = scanner.nextLine();
                if (opcioTriada.equals(arrayComandes[0])) {
                    this.altaJugador();
                } else if (opcioTriada.equals(arrayComandes[1])) {
                    this.eliminaJugador();
                } else if (opcioTriada.equals(arrayComandes[2])) {
                    this.iniciarPartida();
                } else if (opcioTriada.equals(arrayComandes[3])) {
                    this.mostraComandes();
                } else if (opcioTriada.equals(arrayComandes[4])) {
                    this.mostraPerPantalla("Sortint del joc de la oca...");
                    final_programa = true;
                } else {//Si no s'introdueix cap comanda vàlida.
                    this.mostraPerPantalla("Comanda incorrecta. Necessites ajuda? escriu 'ajuda' per obtenir una llista de comandes vàlides");
                }
                //Gestio de les excepcions.
            } catch (ColorFitxaExisteixException e) {
                this.mostraPerPantalla("Ja hi ha un altre jugador controlant una fitxa d'aquest color");
            } catch (FaltenJugadorsException e) {
                this.mostraPerPantalla("No es pot iniciar la partida, afegeix com a minim 2 jugadors per jugar");
            } catch (ColorFitxaNoExisteixException e) {
                this.mostraPerPantalla("No hi ha cap jugador controlant una fitxa d'aquest color");
            }
        }

    }

}
