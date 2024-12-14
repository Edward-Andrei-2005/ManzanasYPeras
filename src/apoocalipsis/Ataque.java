package apoocalipsis;

import java.io.Serializable;

public class Ataque implements Serializable {
   
    private Superviviente superviviente;
    private Arma arma;
    private int numeroDeDados[];
    private int numeroExito;
    private Casilla casillaDestino;
    
    public Ataque(Superviviente s, Arma a, int numeroDeDados[], int numeroExito, Casilla dest) {
        superviviente = s;
        arma = a;
        this.numeroDeDados = numeroDeDados;
        this.numeroExito = numeroExito;
        casillaDestino = dest;
    }
}
