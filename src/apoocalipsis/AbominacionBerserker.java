package apoocalipsis;

public class AbominacionBerserker extends Abominacion {
    public AbominacionBerserker() {
        super();
    }
    
    public boolean esMatable(Arma a) {
        return a.getPotencia() >= AGUANTE && a.getAlcance() == 0;
    }
}
