package apoocalipsis;

public class Caminante extends Zombi {
    //Atributos
    protected static final int AGUANTE = 1;
    protected static final int ACTIVACIONES = 1;
    //Constructores
    public Caminante() {
        super(AGUANTE, ACTIVACIONES);
    }
    
    public boolean esMatable(Arma a) {
        return a.getPotencia() >= AGUANTE;
    }
}
