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
    Controlador controlador = new Controlador(this);
    //Constructor
    
    //Mètodes=========//
    public void altaJugador(){
        Scanner sc = new Scanner(System.in);
        String nom, color;
        int error;
        
              
        System.out.println("Nom del jugador: ");
        nom = sc.next();
        
        System.out.println("Color de la fitxa:");
        color = sc.next();
        
        error = controlador.afegeixJugador(nom, color);
        
        if(error==0){
            System.out.println("Jugador afegit correctament");
        }
        
        if(error==-1){
            System.out.println("Ja hi ha un altre jugador controlant una fitxa d'aquest color");
        }
        
        
        
        
    }
    
    public void eliminaJugador(){
        Scanner sc = new Scanner(System.in);
        String color;
        int error;
        
        System.out.println("Color de la fitxa: ");
        color = sc.next();
        
        error = controlador.eliminaJugador(color);
        
        if(error==0){
            System.out.println("Jugador eliminat correctament.");
        }
        
        if(error==-1){
            System.out.println("No hi ha cap jugador controlant una fitxa d'aquest color");
        }    
    }
    
    public void iniciarPartida(){
        
    }
    
    public static void main (String[] args){
        
    }
    
    public void mostraComandes(){
        System.out.println("alta - Afegeix un nou jugador a la partida\nelimina - Elimina un dels jugadors afegits prèviament a la partida\ninicia - Inicia la partida amb els jugadors introduïts\najuda - Mostra novament les comandes vàlides per a l'aplicació\nsurt - Surt del joc de la oca");
    }
    
    public void mostraPerPantalla(String msgArg){
        System.out.println(msgArg);
    }
    
    public void run(){
        
    }
    
    
    
    
    
}

