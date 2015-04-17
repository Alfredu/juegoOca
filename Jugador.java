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
    public Jugador(String nomArg, String colorArg, Dau dauArg, Tauler taulerArg){
        this.nom = nomArg;
        this.fitxa = new Fitxa(colorArg, this, new Casella(1, "Casella convencional") );
        this.dau = dauArg;
        this.tauler = taulerArg;
        
    }
    
    //==Metodes===// 
    
    public Dau getDau(){
        return this.dau;
    }
    
    public Fitxa getFitxa(){
        return this.fitxa;
    }
    
    String getNom(){
        return this.nom;
    }
    
    public boolean jugarTorn(){
        int casellaOrigen = this.numeroCasellaFitxaJugador();
        int numeroDau = this.tiraDau();
        
        if(casellaOrigen + this.tiraDau()>63){
            this.mouFitxa(63-(casellaOrigen + numeroDau -63));
        }
        
        else{            
            this.mouFitxa(casellaOrigen + numeroDau);
        }
        
        
        return this.numeroCasellaFitxaJugador()==63;
    }
    
    public void mouFitxa(int numCasellaDestiArg){

        this.tauler.eliminaFitxes(this.fitxa, this.numeroCasellaFitxaJugador());
        this.tauler.situaFitxa(this.fitxa, numCasellaDestiArg);
    }
    
    public int numeroCasellaFitxaJugador(){
        return this.fitxa.getCasella().getNumero();
    }
    
    public int tiraDau(){
        this.dau.tirar();
        return this.dau.getValor();
    }
    
        
}
