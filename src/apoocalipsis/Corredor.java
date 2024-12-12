package apoocalipsis;

public class Corredor extends Zombi {
    //Atributos
    private static final int AGUANTE = 1;
    private static final int ACTIVACIONES = 2;
    //Constructores
    public Corredor() {
        super(AGUANTE, ACTIVACIONES);
    }
    
    public boolean esMatable(Arma a) {
        return (a.getPotencia() >= AGUANTE);
    }
}
