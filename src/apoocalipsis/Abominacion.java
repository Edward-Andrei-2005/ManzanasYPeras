package apoocalipsis;

public class Abominacion extends Zombi {
    //Atributos
    private static final int AGUANTE = 3;
    private static final int ACTIVACIONES = 1;
    
    //Constructores
    public Abominacion() {
        super(AGUANTE, ACTIVACIONES);
    }
    
    public boolean esMatable(Arma a) {
        return a.getPotencia() >= AGUANTE;
    }
    
    public String getInfo() {
        return "Abominacion:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
    
    public String toString() {
        return "Abominacion";
    }
}
