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
    
    
}
