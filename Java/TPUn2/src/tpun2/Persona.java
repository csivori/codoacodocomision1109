package tpun2;

public class Persona {
    private String nombre, apellido;
    private int edad;

    public Persona(){}
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void cargar(){cargar(true);}
    public void cargar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nIngrese los datos de la Persona\n");
        Scanner2 sn2 = new Scanner2();
        this.nombre = sn2.cargarCampo("Nombre", this.nombre);
        this.apellido = sn2.cargarCampo("Apellido", this.apellido);
        this.edad = sn2.cargarCampo("Edad", this.edad);
        sn2.close();
    }

    public void mostrar(){mostrar(true);}
    public void mostrar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nPerfil de la Persona\n");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
    }
}
