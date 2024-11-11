package apoocalipsis;

public class Casilla {
    // Atributos
    private int x;
    private int y;
    
    // Constructores
    public Casilla(int x, int y) {
        if (x > 0 && y > 0) { // Los valores de x e y solo pueden ser positivos
            this.x = x;
            this.y = y;
        }
    }
}
