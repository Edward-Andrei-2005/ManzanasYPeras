package apoocalipsis;

public abstract class Zombi extends EntidadActivable {
    //Atributos
    private static int contador = 1;
    private int identificador;
    private int aguante, activaciones;
    private String reaccionAnteAtaques;
    
    //Constructores
    public Zombi (int aguante, int activaciones) {
        if((aguante>=1) && (aguante<=3) && (activaciones>=1) && (activaciones<=2)) {
            identificador = contador++;
            this.aguante = aguante;
            this.activaciones = activaciones;
        } else {
            identificador = -1;
        }
    }

    // Métodos
    public boolean activar() {
        return true;
    }
    
    public boolean reaccionar() {
        return true;
    }
    
    public boolean activarse() {
        return true;
    }
    
    public boolean moverse() {
        return true;
    }
    
    public boolean atacar() {
        return true;
    }
    
    public boolean esMatable(Arma a) {
        // Verifica si el zombi es de tipo CaminanteBerserker, CorredorBerserker o AbominacionBerserker
        if((this instanceof CaminanteBerserker) || (this instanceof CorredorBerserker
                || this instanceof AbominacionBerserker)) {
            /*Si es un zombi Berserker, debe cumplir dos condiciones:
            1. El arma debe tener suficiente potencia para eliminar al zombi (potencia >= aguante)
            2. El arma debe ser cuerpo a cuerpo (alcance == 0), ya que los zombis Berserker son inmunes a ataques a distancia.*/
            return (a.getPotencia() >= aguante) && (a.getAlcance() == 0);
        } else {
            // Si el zombi no es un Berserker, solo se verifica que el arma tenga suficiente potencia.
            return (a.getPotencia() >= aguante);
        }
    }
}
