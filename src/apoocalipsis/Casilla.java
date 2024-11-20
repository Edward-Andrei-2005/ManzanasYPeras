package apoocalipsis;
import java.util.ArrayList;

public class Casilla {
    // Atributos
    private int x;
    private int y;
    private ArrayList <EntidadActivable> listaEntidades;
    
    // Constructores
    public Casilla(int x, int y) {
        if (x > 0 && y > 0) { // Los valores de x e y solo pueden ser positivos
            this.x = x;
            this.y = y;
            listaEntidades = new ArrayList <> ();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    // Devuelve el arma del superviviente. Devuelve null si da error
    // Hacer try catch
    public Arma buscarArma(Superviviente s, boolean izq) {
        if (estaSuperviviente(s)) {
            int i = listaEntidades.indexOf(s);
            Superviviente sup = (Superviviente) listaEntidades.get(i);
            if (izq) {
                return sup.getManoIzq();
            } else {
                return sup.getManoDer();
            }
        } else {
            return null;
        }
    }
    
    public boolean estaSuperviviente(Superviviente s) {
        return listaEntidades.contains(s);
    }
    
    public int distancia(Casilla c) {
        return (int) Math.sqrt(Math.pow(x-c.getX(), 2) + Math.pow(y-c.getY(), 2));
    }
}
