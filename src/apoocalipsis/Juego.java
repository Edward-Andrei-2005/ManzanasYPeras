package apoocalipsis;

public class Juego {
    private boolean turno;
    private Casilla[][] dimension;
    
    private static final int TAM = 10;
    
    public Juego() {
        dimension = new Casilla [TAM][TAM];
    }
    
    public boolean generarAtaque(Superviviente s, boolean izq, Casilla objetivo) {
        Arma a = elegirArma(s, izq);
        // Si es null abortar
        
        Casilla origen = buscarCasillaOrigen(s);
        
        return false;
    }
    
    private Arma elegirArma(Superviviente s, boolean izq) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                Arma a = dimension[i][j].buscarArma(s, izq);
                if (a != null) return a;
            }
        }
        return null;
    }
    
    private Casilla buscarCasillaOrigen(Superviviente s) {
        for (int i=0; i<TAM; i++) {
            for (int j=0; j<TAM; j++) {
                if (dimension[i][j].estaSuperviviente(s)) return dimension[i][j];
            }
        }
    }
    
    private boolean seleccionarObjetivo(Casilla origen, Arma a, Casilla destino) {
        return a.puedeAtacar(origen.distancia(destino));
    }
    
    private int[] lanzarDados(Arma a) {
        int[] v = new int [a.getNumeroDeDados()];
        for (int i=0; i<v.length; i++) {
            v[i] = a.tirarDado();
        }
        return v;
    }
    
    private int evaluarExito(int[] v, Arma a) {
        int contador = 0;
        for (int i=0; i<v.length; i++) {
            if (a.getValorDeExito() <= v[i]) contador++;
        }
        return contador;
    }
    
    private boolean resolverAtaque() {
            
    }
    
    
    
}
