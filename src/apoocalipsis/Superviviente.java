package apoocalipsis;

import java.util.Arrays;
import java.util.Objects;

public class Superviviente extends EntidadActivable {
    // Atributos
    private String nombre;
    private boolean estado; // vivo = true, eliminado = false
    private int accionesPorTurno;
    private int contZombisKO;
    private int heridas; // Un Superviviente es eliminado al recibir 2 heridas o mordeduras.
    private Arma manoIzq, manoDer;
    
    private static final int TAM_EQUIPO = 5; // Tamaño máximo de Equipo [0..5]
    private Equipo inventario[];
    private int siguiente;
    
    // Constructores
    public Superviviente(String n) {
        if (n != null) {
            nombre = n;
            estado = true;
            inventario = new Equipo[TAM_EQUIPO];
        }
    }
    
    // Métodos
    public String getNombre() {
        return nombre;
    }
    
    public Arma getManoDer() {
        return manoDer;
    }

    public Arma getManoIzq() {
        return manoIzq;
    }
    
    public boolean eliminarEquipo() {
        if (siguiente == 0) return false;
        else {
            if (inventario[0].equals(manoIzq)) {
                manoIzq = null;
            } else if (inventario[0].equals(manoDer)) {
                manoDer = null;
            }
            
            inventario[0] = inventario[--siguiente];
            return true;
        }
    }
    
    public boolean agregarEquipo(Equipo eq) {
        if (siguiente == TAM_EQUIPO) eliminarEquipo();
        inventario[siguiente++] = eq;
        return true;
    }
    
    // Cambiar un arma activa de entre las armas que lleva en su inventario.
    public boolean elegirArma(Arma arma, boolean izq) {
        if (arma != null && inventario != null) {
            for (int i = 0; i < siguiente; i++) {
                if (arma.equals(inventario[i])) {
                    if (izq == true && !manoDer.equals(manoIzq)) {
                        manoIzq = arma;
                        return true;
                    } else if (izq == false && !manoIzq.equals(manoDer)) {
                        manoDer = arma;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean inventarioLleno() {
        return inventario.length == TAM_EQUIPO;
    }
    
    // El Superviviente puede optar por no realizar ninguna acción.
    public void noHacerNada() {
        accionesPorTurno--;
    }

    public boolean activarse() {
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

