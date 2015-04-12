/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;

import java.util.TreeMap;

/**
 *
 * @author aleix
 */
public class Tauler {
    //======Atributs====//
    private TreeMap<Integer, Casella> caselles;
    
    //======Constructor===//
    public Tauler(){
        this.caselles = new TreeMap();
        
        for(int i=0; i<63; i++){
            
            caselles.put(i, new Casella(i, "Casella convencional"));
        }
    }
    
    //=====Metodes========//
    
    public void eliminaFitxes(Fitxa fitxaArg, int numeroArg){
        caselles.get(numeroArg).eliminaFitxa(fitxaArg);
    }
    
    public Casella getCasella(int numeroArg){
       return caselles.get(numeroArg);
    }
    
    public void situaFitxa(Fitxa fitxaArg, int numeroArg){
        caselles.get(numeroArg).situaFitxa(fitxaArg);
    }
}


