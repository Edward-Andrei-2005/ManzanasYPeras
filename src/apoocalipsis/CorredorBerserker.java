package apoocalipsis;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class CorredorBerserker extends Corredor {
    //Constructores
    public CorredorBerserker() {
        super();
    }
    
    public boolean esMatable(Arma a) {
        return (a.getPotencia() >= getAguante()) && (a.getAlcance() == 0);
    }
    
    public String getInfo() {
        return "Corredor Berserker:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
    
    public String toString() {
        return "Corredor Berserker";
    }
}
