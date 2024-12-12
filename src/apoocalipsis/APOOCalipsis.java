package apoocalipsis;

public class APOOCalipsis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego miJuego = new Juego();
        String[] s = {"Edward", "Manu"};
        miJuego.asignarSupervivientesPosicionInicial(s);
        System.out.println(miJuego.getSuperviviente("Edward").getManoDer());
        
        //miJuego.leerPartida();
        //String [] nombres = {"Edward", "Anass", "Manuel", "Robert", "Paco"};
        //miJuego.hacerPartida(nombres);
        
    }
}
