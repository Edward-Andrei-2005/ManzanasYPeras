package apoocalipsis;

public abstract class Zombi {
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
}
