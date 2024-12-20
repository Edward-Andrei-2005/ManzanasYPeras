package apoocalipsis;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class CorredorToxico extends Corredor {
    //Constructores
    public CorredorToxico() {
        super();
    }
    
    public String getInfo() {
        return "Corredor:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
    
    public String toString() {
        return "Corredor Berserker";
    }
}
