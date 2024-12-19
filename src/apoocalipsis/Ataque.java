package apoocalipsis;
import java.io.Serializable;
import java.util.ArrayList;

public class Ataque implements Serializable {
   
    private Superviviente superviviente;
    private Arma arma;
    private int numeroDeDados[];
    private int numeroExito;
    private Casilla casillaDestino;
    private ArrayList<Zombi> zombisEliminados;
    
    public Ataque(Superviviente s, Arma a, int numeroDeDados[], int numeroExito, Casilla dest, ArrayList<Zombi> zEliminados) {
        superviviente = s;
        arma = a;
        this.numeroDeDados = numeroDeDados;
        this.numeroExito = numeroExito;
        casillaDestino = dest;
        this.zombisEliminados = zEliminados;
    }
    
    private String zombisEliminados(ArrayList<Zombi> zombisEliminados) {
        String aux = "";
        
        for(Zombi z: zombisEliminados) {
            aux += "\t" + z.toString() + "\n";
        }
        
        return aux;
    }
    
    private String numeroDados(int [] numeroDados) {
        String aux = "[";
        
        for (int i=0; i<numeroDados.length-1; i++) {
            aux += numeroDados[i] + ", ";
        }
        aux += numeroDados[numeroDados.length-1] + "]";
        
        return aux;
    }
    
    @Override
    public String toString() {
        return ("****" + superviviente.getNombre() + " ha atacado a " + " zombis:\n" 
                + zombisEliminados(zombisEliminados)) + "\tArma usada: " + arma.getInfo() + "\n\tDados obtenidos: " + numeroDados(numeroDeDados)
                + "\n\tExitos obtenidos: " + numeroExito;
    }
}
