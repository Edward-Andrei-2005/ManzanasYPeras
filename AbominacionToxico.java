package apoocalipsis;

public class AbominacionToxico extends Abominacion {
    public AbominacionToxico() {
        super();
    }
    
    public String getInfo() {
        return "Abominacion Toxico:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
}
