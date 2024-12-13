package apoocalipsis;

public class AbominacionBerserker extends Abominacion {
    public AbominacionBerserker() {
        super();
    }
    
    public boolean esMatable(Arma a) {
        return a.getPotencia() >= getAguante() && a.getAlcance() == 0;
    }
    
    public String getInfo() {
        return "Abominacion Berserker:\n\tAguante: " + getAguante() + "\n\tActivaciones: "+ getActivaciones();
    }
}
