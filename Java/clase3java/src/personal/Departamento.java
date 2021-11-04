/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personal;

/**
 *
 * @author Fer
 */
public class Departamento extends Personal{

    public String nombre, posicion;

    public Departamento(String nombreDepto, String posicion, String nombre, String apellido, String email, int edad, double sueldo) {
        super(nombre, apellido, email, edad, sueldo);
        this.nombre = nombreDepto;
        this.posicion = posicion;
    }
    
}
