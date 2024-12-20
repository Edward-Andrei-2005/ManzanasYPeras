package apoocalipsis;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class ListaJuego {
    //Atributos
    private ArrayList<Juego> listaJuegos;
    private static final String ARCHIVO = "APOOCalipsis.dat"; // Nombre del archivo binario
    
    //Constructores
    public ListaJuego() {
        listaJuegos = new ArrayList<>();
    }
    
    //Métodos
    public void guardarJuego(Juego j) {
        listaJuegos.add(j);
        guardarFichero();
    }
    
    public static void vaciarFichero() {
        try (FileWriter escritor = new FileWriter(ARCHIVO, false)) {
            System.out.println("Fichero vaciado");
        } catch (IOException e) {
            
        }
    }
    
    public Juego getUltimo() {
        if (listaJuegos.isEmpty()) return null;
        
        return listaJuegos.get(listaJuegos.size()-1);
    }
    
    public void borrar(Juego juego) {
        listaJuegos.remove(juego);
    }
    
    public ArrayList<Juego> getListaJuegos() {
        return listaJuegos;
    }
    
    public void guardarFichero() {
        // Guardar la lista de empleados en un archivo binario
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(listaJuegos); // Serializa 
            System.out.println("\n***Tablero guardado correctamente***\n");
        } catch (IOException e) {
            System.err.println("Error al guardar el tablero: " + e.getMessage());
        }
    }
    
    public void leerFichero() {
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            listaJuegos = (ArrayList<Juego>) ois.readObject();
            //System.out.println("\n***Tablero leido correctamente***\n");
            //listaJuegos.get(listaJuegos.size() - 1).dibujarTableroConNumeros(); //Imprime el ultimo juego guardado
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            String base = System.getProperty("file.separator");
            try (FileOutputStream oos = new FileOutputStream(ARCHIVO)) {
                
                System.out.println("Archivo .dat creado correctamente.");
            } catch (IOException e2) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Archivo vacio");
        } catch (IOException e) {
            System.err.println("Error al leer el tablero: " + e.getMessage());
        }
    }

}
