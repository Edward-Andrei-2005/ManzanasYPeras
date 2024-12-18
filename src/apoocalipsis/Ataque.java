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
            aux += z.getInfo() + "\n";
        }
        
        return aux;
    }
    
    @Override
    public String toString() {
        return ("****" + superviviente.getNombre() + " ha atacado a " + casillaDestino.numeroZombis() + " zombis:\n" 
                + zombisEliminados(zombisEliminados)) + "****\n" + superviviente.getInfo() + "\nArma usada: " + arma.getInfo();
    }
}
