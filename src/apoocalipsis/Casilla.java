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
        if (x > 0 && y > 0) { // Los valores de x e y solo pueden ser positivos
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
    
    // Devuelve una lista de zombis eliminables usando un arma dada y un número de éxitos disponible
    public boolean eliminarZombis(Arma a, int exitos) {
        ArrayList<EntidadActivable> zombisAEliminar = new ArrayList<>(); // Lista para almacenar los zombis eliminables
        
        for (EntidadActivable e : listaEntidades) { // Itera por las entidades de la casilla
            if (exitos == 0) { // Si no quedan éxitos, detiene el proceso
                break;
            } else if (e instanceof Zombi) { // Verifica si la entidad es un Zombi
                if (((Zombi) e).esMatable(a)) { // Comprueba si el zombi puede ser eliminado con el arma
                    zombisAEliminar.add(e); // Añade el zombi a la lista de eliminables
                    exitos--;
                }
            }
        }
        
        eliminarEntidad(zombisAEliminar); 
        
        return zombisAEliminar.size() != 0;
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
    public boolean buscarEquipo(Superviviente s) {
        if (!quedaEquipo || !this.estaEntidad(s)) return false;
        
        int i = listaEntidades.indexOf(s);
        Superviviente superviviente = (Superviviente) listaEntidades.get(i);
        
        if (superviviente.inventarioLleno()) superviviente.eliminarEquipo();
        
        if ((int) (Math.random() * 2) == 1) { // si aleatoriamente se elige Arma
            superviviente.agregarEquipo(new Arma());
        } else { // si aleatoriamente se elige Provision
            superviviente.agregarEquipo(new Provision());
        }
        
        quedaEquipo = false;
        
        return true;
    }
    
    public boolean hayAlgunSupervivienteMuerto() {
        boolean v = false;
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente){
                v = ((Superviviente) e).estaMuerto();
            } 
        }
        return v;
    }
    
    public boolean hayAlgunSuperviviente() {
        boolean v = false;
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente) v = true; 
        }
        return v;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Casilla aux = (Casilla) o;
        return x == aux.getX() && y == aux.getY();
    }
}

