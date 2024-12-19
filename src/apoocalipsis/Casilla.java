package apoocalipsis;
import java.io.Serializable;
import java.util.ArrayList;

public class Casilla implements Serializable {
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
    
    public int numeroSupervivientes() {
        int num = 0;
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente) num++;
        }
        return num;
    }
    
    public ArrayList<Superviviente> todosLosSupervivientes() {
        ArrayList <Superviviente> lista = new ArrayList <> ();
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Superviviente) lista.add((Superviviente) e);
        }
        return lista;
    }
    
    // Devuelve un arrayList con todos los zombis de la casilla
    public ArrayList<Zombi> todosLosZombis() {
        ArrayList <Zombi> lista = new ArrayList <> ();
        for (EntidadActivable e : listaEntidades) {
            if (e instanceof Zombi) lista.add((Zombi) e);
        }
        return lista;
    }
    
    public String getInfo() {
        String s;
        if (quedaEquipo) {
            s = "< Queda equipo >\n\n";
        } else {
            s = "< No queda equipo >\n\n";
        }
        
        if (listaEntidades.isEmpty()) return s + "Casilla vacia";
        
        for (EntidadActivable e : listaEntidades) {
            s += e.getInfo() + "\n";
        }
        
        return s;
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
        return "(" + getX() + ", " + getY() + ")";
    }
}
