package apoocalipsis;

public abstract class Zombi extends EntidadActivable {
    //Atributos
    private static int contador = 1;
    private int identificador;
    private int aguante, activaciones;
    private String reaccionAnteAtaques;
    
    private static final int MIN_AGUANTE = 1;
    private static final int MAX_AGUANTE = 3;
    private static final int MIN_ACTIVACIONES = 1;
    private static final int MAX_ACTIVACIONES = 2;

    //Constructores
    public Zombi (int aguante, int activaciones) {
        if((aguante>=MIN_AGUANTE) && (aguante<=MAX_AGUANTE) && (activaciones>=MIN_ACTIVACIONES) && (activaciones<=MAX_ACTIVACIONES)) {
            identificador = contador++;
            this.aguante = aguante;
            this.activaciones = activaciones;
        } else {
            identificador = -1;
        }
    }
    
    // Métodos
    
    public int getAguante() {
        return aguante;
    }

    public boolean reaccionar() {
        return true;
    }

    public int getActivaciones() {
        return activaciones;
    }
    
    public void quitarActivacionesZombi() {
        --this.activaciones;
    }
    
    /*public boolean esMatable(Arma a) {
        // Verifica si el zombi es de tipo CaminanteBerserker, CorredorBerserker o AbominacionBerserker
        if((this instanceof CaminanteBerserker) || (this instanceof CorredorBerserker) || (this instanceof AbominacionBerserker)) {
            /*Si es un zombi Berserker, debe cumplir dos condiciones:
            1. El arma debe tener suficiente potencia para eliminar al zombi (potencia >= aguante)
            2. El arma debe ser cuerpo a cuerpo (alcance == 0), ya que los zombis Berserker son inmunes a ataques a distancia.
            return (a.getPotencia() >= aguante) && (a.getAlcance() == 0);
        } else {
            // Si el zombi no es un Berserker, solo se verifica que el arma tenga suficiente potencia y que tenga suficiente alcance.
            return (a.getPotencia() >= aguante);
        }
    }*/
    
    @Override
    public String toString() {
        return "Id Zombi: " +identificador;
    }
}
