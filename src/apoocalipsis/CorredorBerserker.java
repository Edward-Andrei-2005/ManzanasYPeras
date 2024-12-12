package apoocalipsis;

public class CorredorBerserker extends Corredor {
    //Constructores
    public CorredorBerserker() {
        super();
    }
    
    public boolean esMatable(Arma a) {
        return (a.getPotencia() >= getAguante()) && (a.getAlcance() == 0);
    }
}
