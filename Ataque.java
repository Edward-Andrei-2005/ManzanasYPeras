/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoocalipsis;

import java.io.Serializable;

/**
 *
 * @author anass
 */
public class Ataque implements Serializable {
   
    private Superviviente superviviente;
    private Arma arma;
    private int numeroDeDados[];
    private int numeroExito;
    private Casilla casillaDestino;
    
    public Ataque(Superviviente s, Arma a, int numeroDeDados[], int numeroExito, Casilla dest) {
        superviviente = s;
        arma = a;
        this.numeroDeDados = numeroDeDados;
        this.numeroExito = numeroExito;
        casillaDestino = dest;
    }
}