package apoocalipsis;

public class CorredorToxico extends Corredor {
    //Constructores
    public CorredorToxico() {
        super();
    }
    
    public String getInfo() {
        return "Corredor:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
}
