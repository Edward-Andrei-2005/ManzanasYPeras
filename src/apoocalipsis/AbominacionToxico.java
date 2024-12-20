package apoocalipsis;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class AbominacionToxico extends Abominacion {
    public AbominacionToxico() {
        super();
    }
    
    public String getInfo() {
        return "Abominacion Toxico:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
    
    public String toString() {
        return "Abominacion Toxico";
    }
}
