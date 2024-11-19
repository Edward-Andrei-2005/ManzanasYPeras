package apoocalipsis;

public abstract class Corredor extends Zombi {
    //Atributos
    private static final int AGUANTE = 1;
    private static final int ACTIVACIONES = 2;
    //Constructores
    public Corredor() {
        super(AGUANTE, ACTIVACIONES);
    }
}
