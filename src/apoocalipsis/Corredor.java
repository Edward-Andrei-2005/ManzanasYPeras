package apoocalipsis;

public class Corredor extends Zombi {
    //Atributos
    protected static final int AGUANTE = 1;
    protected static final int ACTIVACIONES = 2;
    //Constructores
    public Corredor() {
        super(AGUANTE, ACTIVACIONES);
    }
    
    public boolean esMatable(Arma a) {
        return (a.getPotencia() >= AGUANTE);
    }
}
