/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entregable1;
import java.util.Random;
/**
 *
 * @author aleix sanchis
 * @author marta cosano
 */
public class Dau {
    //Atributs==============//
    private int valor;
    
    //Constructor=======//
    public Dau(){
        this.valor = 1;
    }
    
    //Mètodes==============//
    public int getValor(){
        return this.valor;
    }
    
    public void tirar(){
        this.valor = (int)(System.nanoTime() % 6) + 1;
    }      
}
