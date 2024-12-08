/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaficheros;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Edward
 */
public class PruebaFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Nombre del archivo binario
        String archivo = "persona.dat";

        // Crear objetos
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Persona("Juan", 30));
        empleados.add(new Persona("Maria", 25));
        empleados.add(new Trabajo("Juan", "Desarrollador", "TechCorp"));
        empleados.add(new Trabajo("Maria", "Diseñador", "CreativeWorks"));
        
         // Guardar la lista de empleados en un archivo binario
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(empleados); // Serializa la lista de empleados
            System.out.println("Empleados guardados en el archivo binario.");
        } catch (IOException e) {
            System.err.println("Error al guardar los empleados: " + e.getMessage());
        }

        // Leer los empleados desde el archivo binario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"))) {
            ArrayList<Empleado> empleadosLeidos = (ArrayList<Empleado>) ois.readObject();
            System.out.println("Empleados leídos desde el archivo binario:");
            for (Empleado empleado : empleadosLeidos) {
                empleado.mostrarInformacion(); // Llama al método específico de cada subclase
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los empleados: " + e.getMessage());
        }

    }
    
}
