package apoocalipsis;

public class CaminanteToxico extends Caminante {
    //Constructores
    public CaminanteToxico() {
        super();
    }
    
    public String getInfo() {
        return "Caminante Toxico:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
}
