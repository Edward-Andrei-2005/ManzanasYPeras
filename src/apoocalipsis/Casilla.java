package apoocalipsis;
import java.util.ArrayList;

public class Casilla {
    // Atributos
    private int x; // Coordenada x de la casilla
    private int y; // Coordenada y de la casilla
    private ArrayList<EntidadActivable> listaEntidades; // Lista de entidades activables dentro de la casilla
    private boolean quedaEquipo; // true = se puede buscar, false = no se puede buscar
    
    // Constructores
    public Casilla(int x, int y) {
        if (x >= 0 && y >= 0) { // Los valores de x e y solo pueden ser positivos
            this.x = x; // Inicializa el valor de x
            this.y = y; // Inicializa el valor de y
            listaEntidades = new ArrayList<>(); // Inicializa la lista de entidades como una lista vacía
            quedaEquipo = true;
        }
    }

    public int getX() {
        return x; // Devuelve el valor de la coordenada x
    }

    public int getY() {
        return y; // Devuelve el valor de la coordenada y
    }

    public ArrayList<EntidadActivable> getListaEntidades() {
        return listaEntidades;
    }
    
    // Busca el arma del superviviente en función de la mano seleccionada (izquierda o derecha)
    // Devuelve null si el superviviente no está en la casilla
    public Arma buscarArma(Superviviente s, boolean izq) {
        if (estaEntidad(s)) { // Verifica si el superviviente está en la lista de entidades
            int i = listaEntidades.indexOf(s); // Obtiene el índice del superviviente en la lista
            Superviviente sup = (Superviviente) listaEntidades.get(i); // Recupera el objeto Superviviente
            if (izq) { // Devuelve el arma de la mano izquierda si 'izq' es true
                return sup.getManoIzq();
            } else { // Devuelve el arma de la mano derecha si 'izq' es false
                return sup.getManoDer();
            }
        } else {
            return null; // Devuelve null si el superviviente no está en la lista
        }
    }
    
    public String imprimirAguanteZombis() {
        int aux = 0;
        for(EntidadActivable e : listaEntidades) {
            if((e instanceof Zombi) && (((Zombi) e).getAguante() > 0)) {
                return "El zombi " +(++aux) + " tiene potencia " +((Zombi) e).getAguante();
            }
        }
        return null;
    }
    
    // Devuelve una lista de zombis eliminables usando un arma dada y un número de éxitos disponible
    /*public boolean eliminarZombis(Arma a, int exitos, Superviviente s) {
        ArrayList<EntidadActivable> zombisAEliminar = new ArrayList<>(); // Lista para almacenar los zombis eliminables
        
        for (EntidadActivable e : listaEntidades) { // Itera por las entidades de la casilla
            if (exitos == 0) { // Si no quedan éxitos, detiene el proceso
                break;
            } else if (e instanceof Zombi) { // Verifica si la entidad es un Zombi
                if (((Zombi) e).esMatable(a)) { // Comprueba si el zombi puede ser eliminado con el arma
                    // Si el zombi a matar es toxico se hiere a todos los supervivientes de una casilla
                    if (((Zombi) e) instanceof CaminanteToxico ||
                            ((Zombi) e) instanceof AbominacionToxico ||
                            ((Zombi) e) instanceof CorredorToxico) {
                        herirSupervivientes();
                    }
                    zombisAEliminar.add(e); // Añade el zombi a la lista de eliminables
                    exitos--;
                }
            }
        }
        
        eliminarEntidad(zombisAEliminar);
        
        // Actualizamos la lista de zombis eliminados por el superviviente
        s.sumarZombisKO(zombisAEliminar.size());
        
        return !zombisAEliminar.isEmpty();
    }
    
    public boolean esMatable(Arma a, Zombi z, Superviviente s) {
        // Verifica si el zombi es de tipo CaminanteBerserker, CorredorBerserker o AbominacionBerserker
        Casilla casillaSuperviviente = buscarCasillaOrigen(s);
        if((z instanceof CaminanteBerserker) || (z instanceof CorredorBerserker) || (z instanceof AbominacionBerserker)) {
            /*Si es un zombi Berserker, debe cumplir dos condiciones:
            1. El arma debe tener suficiente potencia para eliminar al zombi (potencia >= aguante)
            2. El arma debe ser cuerpo a cuerpo (alcance == 0), ya que los zombis Berserker son inmunes a ataques a distancia.
            return (a.getPotencia() >= z.getAguante()) && (a.getAlcance() == 0) && ;
        } else {
            // Si el zombi no es un Berserker, solo se verifica que el arma tenga suficiente potencia y que tenga suficiente alcance.
            return (a.getPotencia() >= aguante);
        }
    }*/
    
    public boolean herirSupervivientes() {
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente) ((Superviviente) e).recibirAtaque();
        }
        return true;
    }
    
    public boolean esAdyacente(Casilla c) {
        return Math.abs(x-c.getX()) <= 1 && Math.abs(y-c.getY()) <= 1;
    }
    
    // Elimina las entidades de la lista que se encuentran en la lista proporcionada como argumento
    public void eliminarEntidad(ArrayList<EntidadActivable> l) {
        for (EntidadActivable e : l) { // Itera por cada entidad en la lista proporcionada
            listaEntidades.remove(e); // Elimina la entidad de la lista de la casilla
        }
    }
    
    
    public void eliminarEntidad(EntidadActivable e) {
        listaEntidades.remove(e);
    }
    
    public void anadirEntidad(EntidadActivable e) {
        listaEntidades.add(e);
    }
    
    // Comprueba si una entidad está presente en la lista de la casilla
    public boolean estaEntidad(EntidadActivable e) {
        return listaEntidades.contains(e); // Devuelve true si la lista contiene a la entidad, false en caso contrario
    }
    
    // Calcula la distancia entre esta casilla y otra casilla dada usando la fórmula de pitágoras
    public int distancia(Casilla c) {
        return (int) Math.sqrt(Math.pow(x - c.getX(), 2) + Math.pow(y - c.getY(), 2)); // Devuelve la distancia como entero
    }
    
    /* Buscar equipo en la casilla actual. Se obtiene, de forma aleatoria, una instancia de
    equipo. No se puede buscar dos veces en la misma casilla. */
    public Equipo buscarEquipo(Superviviente s) {
        if (!quedaEquipo || !this.estaEntidad(s)) return null;
        quedaEquipo = false;
        int i = listaEntidades.indexOf(s);
        Superviviente superviviente = (Superviviente) listaEntidades.get(i);
        
        if (superviviente.inventarioLleno()) superviviente.eliminarEquipo();
        
        if ((int) (Math.random() * 2) == 1) { // si aleatoriamente se elige Arma
            Arma a = new Arma();
            superviviente.agregarEquipo(a);
            return a;
        } else { // si aleatoriamente se elige Provision
            Provision p = new Provision();
            superviviente.agregarEquipo(p);
            return p;
        }
    }
    
    public boolean hayAlgunSupervivienteMuerto() {
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente && ((Superviviente) e).estaMuerto()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hayAlgunSupervivienteVivo() {
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente && ((Superviviente) e).estaVivo()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hayAlgunSuperviviente() {
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente) return true; 
        }
        return false;
    }
    
    public boolean hayAlgunZombi() {
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Zombi) return true; 
        }
        return false;
    }
    
    public boolean estaSuperviviente(String nombre) {
        for(EntidadActivable e: listaEntidades) {
            if ((e instanceof Superviviente) && (((Superviviente) e).getNombre().equals(nombre))) return true;
        }
        return false;
    }
    
    public boolean estaSupervivienteVivo(String nombre) {
        for(EntidadActivable e: listaEntidades) {
            if ((e instanceof Superviviente) && (((Superviviente) e).getNombre().equals(nombre)) 
                    && ((Superviviente) e).estaVivo()) return true;
        }
        return false;
    }
    
    public Superviviente getSuperviviente(String nombre) {
        for (EntidadActivable e : listaEntidades) {
            if ((e instanceof Superviviente) && (((Superviviente) e).getNombre().equals(nombre))) return (Superviviente) e;
        }
        return null;
    }
    
    // Devuelve false si hay algún superviviente que no tenga provisión
    public boolean noTieneProvisionSuperviviente() {
        for (EntidadActivable e: listaEntidades) {
            if (e instanceof Superviviente && !(((Superviviente) e).tieneProvision())) return true;
        }
        return false;
    }
    
    public int numeroZombis() {
        int num = 0;
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Zombi) num++;
        }
        return num;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Casilla aux = (Casilla) o;
        return x == aux.getX() && y == aux.getY();
    }
    
    @Override
    public String toString() {
        return "Coordenada X: " + getX() + " Coordenada Y: " + getY();
    }
}
