package apoocalipsis;

public class CorredorBerserker extends Corredor {
    //Constructores
    public CorredorBerserker() {
        super();
    }
    
    public boolean esMatable(Arma a) {
        return (a.getPotencia() >= AGUANTE) && (a.getAlcance() == 0);
    }
}
