package apoocalipsis;

import java.util.Arrays;
import java.util.Objects;

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
    private int siguiente;
    
    // Constructores
    public Superviviente(String n) {
        if (n != null) {
            nombre = n;
            estado = true;
            inventario = new Equipo[TAM];
        }
    }
    
    // Métodos

    public String getNombre() {
        return nombre;
    }
    
    
    /* Buscar equipo en la casilla actual. Se obtiene, de forma aleatoria, una instancia de
    equipo. No se puede buscar dos veces en la misma casilla. */
    public Equipo buscar() {
        return null;
    }

    public Arma getManoDer() {
        return manoDer;
    }

    public Arma getManoIzq() {
        return manoIzq;
    }
    
    
    // // Usar un arma equipada para atacar zombis en una casilla específica.
    public void atacarArma(Arma arma, Casilla casilla) {
        
    }
    
    // Cambiar un arma activa de entre las armas que lleva en su inventario.
    public boolean elegirArma(Arma arma, boolean izq) {
        if (arma != null && inventario != null) {
            for (int i = 0; i < siguiente; i++) {
                if (arma.equals(inventario[i])) {
                    if (izq == true) {
                        manoIzq = arma;
                    } else {
                        manoDer = arma;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    // El Superviviente puede optar por no realizar ninguna acción.
    public void noHacerNada() {
    
    }

    public boolean activarse() {
        return true;
    }
    
    public boolean moverse() {
        return true;
    }
    
    public boolean atacar() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        
        final Superviviente s = (Superviviente) o;
        
        return nombre.equals(s.getNombre());
    }
}

