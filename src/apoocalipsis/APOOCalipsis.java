package apoocalipsis;

import java.io.File;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class APOOCalipsis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        J_InterfazGrafica.main();
        
        // En caso de error al leer o escribir del fichero que impida ejecutar el programa, descomentar la linea de abajo y comentar la de arriba
        //ListaJuego.vaciarFichero();
    }
}
