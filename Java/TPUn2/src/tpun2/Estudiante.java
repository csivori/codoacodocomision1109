package tpun2;

import java.util.Scanner;

public class Estudiante extends Persona{
    private String hobbie, edCodigoPreferido, SO;    

    public Estudiante() {}
    public Estudiante(String hobbie, String edCodigoPreferido, String SO, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.hobbie = hobbie;
        this.edCodigoPreferido = edCodigoPreferido;
        this.SO = SO;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public String getEdCodigoPreferido() {
        return edCodigoPreferido;
    }

    public void setEdCodigoPreferido(String edCodigoPreferido) {
        this.edCodigoPreferido = edCodigoPreferido;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }
    
    public void cargar(){cargar(true);}
    public void cargar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nIngrese los datos del Estudiante\n");
        super.cargar(false);
        Scanner sn = new Scanner(System.in);            
        System.out.print("Hobbie: ");
        hobbie = sn.nextLine();
        System.out.print("Editor de Texto Preferido: ");
        edCodigoPreferido = sn.nextLine();
        System.out.print("Sistema Operativo: ");
        SO = sn.nextLine();
    }

    public void mostrar(){mostrar(true);}
    public void mostrar(Boolean mostrarTitulo){
        if (mostrarTitulo) {System.out.println("\nPerfil del Estudiante\n");}    
        super.mostrar(false);
        System.out.println("Hobbie: " + hobbie);
        System.out.println("Editor de Texto Preferido: " + edCodigoPreferido);
        System.out.println("Sistema Operativo: " + SO);
    }
}
