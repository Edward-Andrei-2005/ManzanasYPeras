package apoocalipsis;

public class Abominacion extends Zombi {
    //Atributos
    protected static final int AGUANTE = 3;
    protected static final int ACTIVACIONES = 1;
    
    //Constructores
    public Abominacion() {
        super(AGUANTE, ACTIVACIONES);
    }
    
    public boolean esMatable(Arma a) {
        return a.getPotencia() >= AGUANTE;
    }
}
