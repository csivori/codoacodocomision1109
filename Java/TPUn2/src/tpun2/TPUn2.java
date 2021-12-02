package tpun2;

public class TPUn2 {

    public static void main(String[] args) {
// Cargo la Persona
//        Persona p = new Persona();
//        p.cargar();
// Cargo la Persona 2
        Persona2 p2 = new Persona2();
        System.out.println("\n" + p2.getDBStmtCreateTable() + "\n");
        p2.cargar();
// Cargo el Estudiante
//        Estudiante e = new Estudiante();
//        e.cargar(true);
// Cargo el Estudiante2
        Estudiante2 e2 = new Estudiante2();
        System.out.println("\n" + e2.getDBStmtCreateTable() + "\n");
        e2.cargar(true);
// Muestro la Persona y el Estudiante
//        p.mostrar();
//        p2.mostrar();
//        e.mostrar();
//        e2.mostrar();
    }
}
