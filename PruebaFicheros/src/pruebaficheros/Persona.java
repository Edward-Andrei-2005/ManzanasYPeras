/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaficheros;

/**
 *
 * @author Edward
 */
public class Persona extends Empleado {
    //Atributos
    private int edad;
    
    //Constructores
    public Persona(String nombre, int edad) {
        super(nombre);
        this.edad = edad;
    }
    
    // Getters y Setters

    
    @Override
    public void mostrarInformacion() {
        System.out.println("Persona: " + nombre + ", Edad: " + edad);
    }
}
