package apoocalipsis;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class Caminante extends Zombi {
    //Atributos
    private static final int AGUANTE = 1;
    private static final int ACTIVACIONES = 1;
    //Constructores
    public Caminante() {
        super(AGUANTE, ACTIVACIONES);
    }
    
    public boolean esMatable(Arma a) {
        return a.getPotencia() >= AGUANTE;
    }
    
    public String getInfo() {
        return "Caminante:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
    
    public String toString() {
        return "Caminante";
    }
}
