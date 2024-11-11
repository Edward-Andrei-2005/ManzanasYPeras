package apoocalipsis;

public class Provision extends Equipo {
    private String nombre;
    private int valorEnergetico;
    private int caducidad;
    
    private static final String[] NOMBRES = {"Espaguetis", "Caviar", "Mixto", "Empanada", "Manzana"};
    private static final int KCAL_MIN = 50;
    private static final int KCAL_MAX = 200;
    private static final int CADUCIDAD_MIN = 2;
    private static final int CADUCIDAD_MAX = 15;
    
    public Provision() {
        nombre = NOMBRES[(int) (Math.random() * NOMBRES.length)];
        valorEnergetico = (int) (Math.random() * (KCAL_MAX-KCAL_MIN)) + KCAL_MIN;
        caducidad = (int) (Math.random() * (CADUCIDAD_MAX-CADUCIDAD_MIN)) + CADUCIDAD_MIN;
    }
}
