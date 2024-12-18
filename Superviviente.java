package apoocalipsis;

import java.util.Arrays;
import java.util.Objects;

public class Superviviente extends EntidadActivable {
    // Atributos
    private String nombre;
    private boolean estado; // vivo = true, eliminado = false
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

    public Equipo[] getInventario() {
        return inventario;
    }
    
    public int getInvSig() {
        return siguiente;
    }

    public int getHeridas() {
        return heridas;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Sumar tamaño a la lista de zombis eliminados
    public void sumarZombisKO(int tam) {
        if (contZombisKO >= 0) this.contZombisKO += tam;
    }
    
    // Comprueba si el superviviente tiene provisión
    public boolean tieneProvision() {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] instanceof Provision) return true;
        }
        return false;
    }
    
    public Arma getArma(int id) {
        if(inventario.length == 0) {
            return null;
        } else {
            for(int i=0; i<inventario.length; i++) {
                if((inventario[i] instanceof Arma) && (((Arma) inventario[i]).getId() == id)) {
                    return (Arma) inventario[i];
                }
            }
        }
        return null;
    }
    
    public boolean eliminarEquipo() {
        if(siguiente == TAM_EQUIPO) {
            if (inventario[0].equals(manoIzq)) {
                manoIzq = null;
            } else if (inventario[0].equals(manoDer)) {
                manoDer = null;
            }
            inventario[0] = inventario[--siguiente];
            return true;
        } else {
            return false;
        }
    }
    
    public boolean estaArmaEnInventario(int id) {
        if(inventario.length == 0) {
            return false;
        } else {
            for(int i=0; i<inventario.length; i++) {
                if((inventario[i] instanceof Arma) && (((Arma) inventario[i]).getId() == id)) {
                    return true;
                }
            }
        }
        return false;
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
                    if (izq == true && (manoDer == null || !manoDer.equals(manoIzq))) {
                        manoIzq = arma;
                        return true;
                    } else if (izq == false && (manoIzq == null || !manoIzq.equals(manoDer))) {
                        manoDer = arma;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean inventarioLleno() {
        return siguiente == TAM_EQUIPO;
    }
    
    public boolean estaVivo() {
        return estado == true;
    }
    
    public boolean estaMuerto() {
        return !estaVivo();
    }
    
    public boolean estaHerido() {
        return heridas > 0;
    }
    
    // Aplica los ataques de Zombi a Superviviente
    public void recibirAtaque() { // se hace con boolean??
        if (heridas == 0) heridas++;
        else {
            ++heridas;
            setEstado(false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        
        final Superviviente s = (Superviviente) o;
        
        return nombre.equals(s.getNombre());
    }
    
    public String getInfo() {
        String salud;
        if (estaHerido()) {
            salud = "Esta herido";
        } else {
            salud = "Esta sano";
        }
        
        String armas;
        if (manoIzq==null && manoDer==null) {
            armas = "No tiene armas equipadas";
        } else if (manoIzq!=null && manoDer!=null) {
            armas = "Mano Izquierda: " + manoIzq.getInfo() + "\n\tMano Derecha: " + manoDer.getInfo();
        } else if (manoIzq!=null) {
            armas = "Mano Izquierda: " + manoIzq.getInfo();
        } else {
            armas = "Mano Derecha: " + manoDer.getInfo();
        }
        
        String provision;
        if (tieneProvision()) {
            provision = "Tiene provision";
        } else {
            provision = "No tiene provision";
        }
        return "Superviviente " + nombre + "\n\t" + salud + "\n\t" + armas + "\n\t" + provision;
    }
    
    /*@Override
    public String toString() {
        return nombre + "\n" +
                
    }*/
}
