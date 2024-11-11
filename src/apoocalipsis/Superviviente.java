/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoocalipsis;

import java.util.ArrayList;

public class Superviviente {
    // Atributos
    private String nombre;
    private boolean estado; // vivo = true, eliminado = false
    private static final int accionesPorTurno = 3;
    private int contZombisKO;
    private int heridas; // Un Superviviente es eliminado al recibir 2 heridas o mordeduras.
    private Arma manoIzq;
    private Arma manoDer;
    
    private static final int TAM = 5; // Tamaño máximo de Equipo [0..5]
    private Equipo inventario[];
    
    // Constructores
    public Superviviente(String n) {
        nombre = n;
        estado = true;
        inventario = new Equipo[TAM];
    }
    
    // Métodos
    
    /* Buscar equipo en la casilla actual. Se obtiene, de forma aleatoria, una instancia de
    equipo. No se puede buscar dos veces en la misma casilla. */
    public Equipo buscar() {
        
    }
    
    // // Usar un arma equipada para atacar zombis en una casilla específica.
    public void atacarArma(Arma arma, Casilla casilla) {
        
    }
    
    // Cambiar un arma activa de entre las armas que lleva en su inventario.
    public void elegirArma(boolean izq) {
        
    }
    
    // El Superviviente puede optar por no realizar ninguna acción.
    public void noHacerNada() {
        
    }
}
