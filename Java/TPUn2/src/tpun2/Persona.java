package tpun2;

import java.util.Scanner;

public class Persona {
    private String nombre, apellido;
    private int edad;

    public Persona(){}
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void cargar(){cargar(true);}
    public void cargar(Boolean mostrarTitulo){
        Scanner sn = new Scanner(System.in);        
    
        if (mostrarTitulo) System.out.println("\nIngrese los datos de la Persona\n");
        System.out.print("Nombre: ");
        nombre = sn.nextLine();
        System.out.print("Apellido: ");
        apellido = sn.nextLine();
        System.out.print("Edad: ");
        edad = sn.nextInt();
    }

    public void mostrar(){mostrar(true);}
    public void mostrar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nPerfil de la Persona\n");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
    }
}
