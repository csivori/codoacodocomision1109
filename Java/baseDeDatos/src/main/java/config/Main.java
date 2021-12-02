package config;

import base.SysOut;
import modelo.Condicion;
import modelo.Condiciones;
import static modelo.Condicion.CondicionesCampo.*;
import modelo.ConectorCondicion;
import modelo.Valor;
import roles.Persona;

public class Main {

    public static void main(String[] args) {
        SysOut.showDebugMsgs = 7;
        BaseDeDatos bd = new BaseDeDatos();
        Persona p = new Persona(4, bd);
        p.mostrar();
        p.setNombre("Karina");
        p.setApellido("Quintana");
        p.setEdad(50);
        p.actualizar(bd);
        p.mostrar();
//        SysOut.dbglnprintln(p.getDBStmtCreateTable(), 1);
//        SysOut.dbglnprintln(p.getDBStmtSelectByPK(), 1);
//        SysOut.dbglnprintln(p.getDBStmtInsert(), 1);
//        SysOut.dbglnprintln(p.getDBStmtUpdate(), 1);
//        SysOut.dbglnprintln(p.getDBStmtDelete(), 1);
//        p.cargar();
        p.recuperar(5, bd);
        p.setNombre("Maria Sol");
        p.setApellido("Sivori");
        p.setEdad(20);
        p.actualizar(bd);
//        SysOut.dbglnprintln(p.getDBStmtSelectByPK(), 1);
        p.mostrar();
        p.recuperar(3, bd);
        p.setApellido("Diaz");
//        SysOut.dbglnprintln(p.getDBStmtSelectByPK(), 1);

// Cargo el Estudiante
//        Estudiante e = new Estudiante();
//        System.out.println("\n" + e.getDBStmtCreateTable() + "\n");
//        e.cargar(true);
// Muestro la Persona y el Estudiante
        p.mostrar();
//        bd.exInsUpdDel(p.getDBStmtInsert());
//        e.mostrar();
//        Condiciones cond = new Condiciones(null, new Condicion("id", IGUAL, new Valor(3)));
//        cond.add(ConectorCondicion.ConectorCondiciones.AND, new Condicion("nombre", IGUAL, new Valor("Barbie")));
//        SysOut.dbglnprintln(p.getDBStmtSelect(cond), 1);
        p.recuperar(12, bd);
        p.mostrar();
        SysOut.dbglnprintln(p.borrar(bd) ? "true" : "false", 1);
        p.recuperar(13, bd);
        p.mostrar();
        SysOut.dbglnprintln(p.borrar(bd) ? "true" : "false", 1);
    }
}
