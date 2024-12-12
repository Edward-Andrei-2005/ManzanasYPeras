package apoocalipsis;

public class AbominacionBerserker extends Abominacion {
    public AbominacionBerserker() {
        super();
    }
    
    public boolean esMatable(Arma a) {
        return a.getPotencia() >= getAguante() && a.getAlcance() == 0;
    }
}
