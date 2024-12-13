package apoocalipsis;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ListaJuego {
    //Atributos
    private ArrayList<Juego> listaJuegos;
    
    //Constructores
    public ListaJuego() {
        listaJuegos = new ArrayList<>();
    }
    
    //Métodos
    public void guardarJuego(Juego j) {
        listaJuegos.add(j);
        guardarFichero();
    }
    
    public void guardarFichero() {
        // Nombre del archivo binario
        String archivo = "APOOCalipsis.dat";
        
        // Guardar la lista de empleados en un archivo binario
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listaJuegos); // Serializa la lista de empleados
            System.out.println("\n***Tablero guardado correctamente***\n");
        } catch (IOException e) {
            System.err.println("Error al guardar el tablero: " + e.getMessage());
        }
    }
    
    public void leerFichero() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("APOOCalipsis.dat"))) {
            
            listaJuegos = (ArrayList<Juego>) ois.readObject();
            System.out.println("\n***Tablero leido correctamente***\n");
            listaJuegos.get(listaJuegos.size() - 1).dibujarTableroConNumeros(); //Imprime el ultimo juego guardado
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el tablero: " + e.getMessage());
        }
    }
}
