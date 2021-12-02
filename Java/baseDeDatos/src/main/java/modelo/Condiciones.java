package modelo;

import base.SysOut;
import java.util.ArrayList;
import modelo.ConectorCondicion.ConectorCondiciones;

public class Condiciones {
    private ArrayList<Condicion> condiciones;
    private ArrayList<ConectorCondicion> conectores;

// CONSTRUCTORES
    
    public Condiciones() {
        this.condiciones = new ArrayList<>();
        this.conectores = new ArrayList<>();
    }
    public Condiciones(ConectorCondiciones conector, Condicion condicion) {
        this();
        add(conector, condicion);
    }

// METODOS PUBLICOS
    
    public void add(ConectorCondiciones conector, Condicion condicion){
        conectores.add(new ConectorCondicion(conector));
        condiciones.add(condicion);
    }
    
    public String getDBStmtWhere(){
        String sAux = "";
        String stmt = "";
        int pos = 0;
        for (Condicion condicion : condiciones){
            SysOut.dbgprintln("sAux: " + sAux, 7);
            sAux = condicion.getDBStmtWhere();
            if (sAux != "") {stmt += ((pos > 0) ? conectores.get(pos).toString() : "") + sAux;}
            pos++;
        }
        return stmt;
    }

// METODOS PRIVADOS.
    
}
