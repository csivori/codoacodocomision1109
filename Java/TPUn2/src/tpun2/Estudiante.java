package tpun2;

public class Estudiante extends Persona{
    private String hobbie, edCodigoPreferido, SO;    

    public Estudiante() {super();}
    public Estudiante(String hobbie, String edCodigoPreferido, String SO, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.hobbie = hobbie;
        this.edCodigoPreferido = edCodigoPreferido;
        this.SO = SO;
    }

    public void cargar(){cargar(true);}
    public void cargar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nIngrese los datos del Estudiante\n");
        super.cargar(false);
        Scanner2 sn2 = new Scanner2();
        hobbie = sn2.cargarCampo("Hobbie", hobbie);
        edCodigoPreferido = sn2.cargarCampo("Editor de Texto Preferido", edCodigoPreferido);
        SO = sn2.cargarCampo("Sistema Operativo", SO);
        sn2.close();
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