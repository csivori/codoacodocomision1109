package tpun2;

public class TPUn2 {

    public static void main(String[] args) {
// Cargo la Persona
        Persona p = new Persona();
        p.cargar();
// Cargo el Estudiante
        Estudiante e = new Estudiante();
        e.cargar();
// Muestro la Persona y el Estudiante
        p.mostrar();
        e.mostrar();
    }
}
