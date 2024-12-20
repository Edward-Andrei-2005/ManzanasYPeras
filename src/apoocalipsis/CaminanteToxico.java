package apoocalipsis;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class CaminanteToxico extends Caminante {
    //Constructores
    public CaminanteToxico() {
        super();
    }
    
    public String getInfo() {
        return "Caminante Toxico:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
    
    public String toString() {
        return "Caminante Toxico";
    }
}
