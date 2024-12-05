package apoocalipsis;

public class CaminanteBerserker extends Caminante {
    //Constructores
    public CaminanteBerserker() {
        super();
    }
    
    public boolean esMatable(Arma a) {
        return (a.getPotencia() >= AGUANTE) && (a.getAlcance() == 0);
    }
}
