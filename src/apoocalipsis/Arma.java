package apoocalipsis;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class Arma extends Equipo {
    private int id;
    private static int contador;
    private String nombre;
    private int potencia;
    private int alcance;
    private int numeroDeDados;
    private int valorDeExito;
    
    private static final int[] VALORES_POTENCIA = {1, 2, 3};
    private static final int MAX_ALCANCE = 5;
    private static final int[] VALORES_DADO = {1, 2, 3, 4, 5, 6};
    private static final String[] NOMBRES_MELEE = {"Cuchillo", "Maza", "Espada", "Daga"};
    private static final String[] NOMBRES_DISTANCIA = {"Arco", "Bazooka", "AK-47"};
    private static final int NUM_DADOS = 3;
    
    public Arma() {
        // Separamos las armas en cuerpo a cuerpo(2/3) y a distancia(1/3)
        if ((int) (Math.random() * 3) == 2) {
            // Generamos un arma a distancia
            nombre = NOMBRES_DISTANCIA[(int) (Math.random() * NOMBRES_DISTANCIA.length)]; // Elegimos un nombre al azar
            alcance = (int) (Math.random() * MAX_ALCANCE) + 1;  // Y un alcance al azar de 1 a 5
        } else {
            // Generamos un arma cuerpo a cuerpo
            nombre = NOMBRES_MELEE[(int) (Math.random() * NOMBRES_MELEE.length)];
            alcance = 0;
        }
        potencia = VALORES_POTENCIA[(int) (Math.random() * VALORES_POTENCIA.length)];
        numeroDeDados = (int) (Math.random() * NUM_DADOS) + 1;
        valorDeExito = VALORES_DADO[(int) (Math.random() * VALORES_DADO.length)];
        id = ++contador;
    }
    
    public Arma(String nombre, int alcance, int potencia, int numeroDeDados, int valorDeExito) {
        id = 0;
        this.nombre = nombre;
        this.alcance = alcance;
        this.potencia = potencia;
        this.numeroDeDados = numeroDeDados;
        this.valorDeExito = valorDeExito;
    }
    
    
    public String getNombre() { return nombre; }
    public int getPotencia() { return potencia; }
    public int getAlcance() { return alcance; }
    public int getNumeroDeDados() { return numeroDeDados; }
    public int getValorDeExito() { return valorDeExito; }
    public int getId() { return id; }
    
    public int [] getValoresPotencia() { return VALORES_POTENCIA; }
    public int getMaxAlcance() { return MAX_ALCANCE; }
    public int [] getValoresDado() { return VALORES_DADO; }
    public String [] getNombresArma() {
        String [] lista = new String [NOMBRES_MELEE.length + NOMBRES_DISTANCIA.length];
        for (int i=0; i<NOMBRES_MELEE.length; i++) {
            lista[i] = NOMBRES_MELEE[i];
        }
        for (int i=NOMBRES_MELEE.length; i<lista.length; i++) {
            lista[i] = NOMBRES_DISTANCIA[i-NOMBRES_MELEE.length];
        }
        return lista;
    }
    public int getValoresExito() { return NUM_DADOS; }
    
    // Dada una distancia dice si un arma puede atacar a un objetivo que esté a esa distancia
    public boolean estaDentroDelRango(int distancia) {
        return alcance >= distancia;
    }
    
    public int tirarDado() {
        return VALORES_DADO[(int) (Math.random() * VALORES_DADO.length)];
    }
    
    public String getInfo() {
        return nombre + " | Potencia: " + potencia + " | Alcance: " + alcance + " | Dados: " + numeroDeDados +" | Exito: " + valorDeExito;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Arma aux = (Arma) o;
        return id == aux.getId();
    }
    
    @Override
    public String toString() {
        return getNombre();
    }
}
