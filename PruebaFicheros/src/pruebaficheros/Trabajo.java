/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaficheros;

/**
 *
 * @author Edward
 */
public class Trabajo extends Empleado {
    String puesto;
    String empresa;

    public Trabajo(String nombre, String puesto, String empresa) {
        super(nombre);
        this.puesto = puesto;
        this.empresa = empresa;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Trabajo: " + nombre + ", Puesto: " + puesto + ", Empresa: " + empresa);
    }
}
