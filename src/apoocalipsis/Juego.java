package apoocalipsis;

public class Juego {
    // Atributos
    private boolean turno;
    private Casilla[][] dimension;
    
    private static final int TAM = 10;
    
    // Constructores
    public Juego() {
        dimension = new Casilla [TAM][TAM];
    }
    
    // Métodos
    private Arma elegirArma(Superviviente superviviente, boolean izq) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                Iterator<EntidadActivable> it = dimension[i][j]..iterator();
            }
        }
        
        return null;
    }
    
    private boolean seleccionarObjetivo() {
        return false;
    }
    
    private boolean lanzarDados() {
        return false;
    }
    
    private boolean evaluarExito() {
        return false;
    }
    
    private boolean resolverAtaque() {
        return false;
    }
    
    public boolean generarAtaque() {
        return false;
    }
    
}
