/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaficheros;
import java.io.*;
/**
 *
 * @author Edward
 */
public abstract class Empleado implements Serializable {
    //Atributos
    String nombre;
    
    //Constructor
    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    public abstract void mostrarInformacion();
}
