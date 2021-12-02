package modelo;

import base.Scanner2;
import base.SysOut;
import java.sql.ResultSet;
import java.util.ArrayList;
import static modelo.Condicion.CondicionesCampo.IGUAL;

public class Campos {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private ArrayList<Campo> campos;

// CONSTRUCTORES
    public Campos() {
//  this.campos = new ArrayList<Campo>();
        this.campos = new ArrayList<>();
    }

// GETTERs & SETTERs
    public Campo getCampo(String colDB) {
        for (Campo campo : this.campos) {
            if (campo.getColDB().equals(colDB)) {
                return campo;
            }
        }
        return null;
    }

    public boolean setCamposValorNulo() {
        for (Campo campo : this.campos) {
            if (!campo.setValorNulo()) {
                return false;
            }
        }
        return true;
    }

    public boolean setCampo(String colDB, int valor) {
        Campo campo = getCampo(colDB);
        return (campo == null) ? false : campo.setValor(valor);
    }

    public boolean setCampo(String colDB, String valor) {
        Campo campo = getCampo(colDB);
        return (campo == null) ? false : campo.setValor(valor);
    }

// OVERRIDES
    @Override
    public String toString() {
        String msg = "Campos(" + campos.size() + ", [";
        for (Campo campo : this.campos) {
            msg += campo.getEtiqueta() + "/";
        }
        return msg.substring(0, (msg.length() - 1)) + "])";
    }

//@Override
//public boolean equals(Campos objeto){
//    Codificar !!
//    return this == objeto;}
// METODOS PUBLICOS
    public void addCampo(Campo campo) {
        this.campos.add(campo);
    }

    public boolean cargar(Scanner2 sn2) {
        for (Campo campo : this.campos) {
            if (!campo.cargar(sn2)) {
                return false;
            }
        }
        return true;
    }

    public void mostrar() {
        for (Campo campo : this.campos) {
            campo.mostrar();
        }
    }

    public int cantCampos() {
        return this.campos.size();
    }

    public String getDBStmtCreateTableSoloCampos() {
        if (tieneAlgunCampo()) {
            String stmt = "";
            for (Campo campo : this.campos) {
                stmt += campo.getDBStmtCreateTable() + ", ";
            }
            return stmt.substring(0, (stmt.length() - 2));
        } else {
            SysOut.dbgprintln("No se puede crear el DDL:CREATE con las columnas de una tabla, xq no tiene columnas definidas", 8);
            return "";
        }
    }

    public String getDBStmtSelectCols() {
        if (tieneAlgunCampo()) {
            String sAux = "";
            String stmt = "";
            for (Campo campo : this.campos) {
                SysOut.dbgprintln("Cargando Campos PK... stmt: " + stmt + " / sAux: " + sAux, 8);
                sAux = campo.getDBStmtSelectCols();
                if (sAux != "") {
                    stmt += sAux + ", ";
                }
            }
            SysOut.dbgprintln("Campos Cargados. stmt: " + stmt, 8);
            return stmt;
        } else {
            SysOut.dbgprintln("No se puede crear el DDL:SELECT de una tabla, xq no tiene columnas", 8);
            return "";
        }
    }

    public String getDBStmtInsertCols() {
        String stmt = "";
        String sAux = "";
        for (Campo campo : this.campos) {
            SysOut.dbgprintln("stmt: " + stmt + " / sAux: " + sAux, 8);
            sAux = campo.getDBStmtInsertCols();
            if (sAux != "") {
                stmt += sAux + ", ";
            }
        }
        return stmt;
    }

    public String getDBStmtInsertValues() {
        String stmt = "";
        String sAux = "";
        for (Campo campo : this.campos) {
            SysOut.dbgprintln("stmt: " + stmt + " / sAux: " + sAux, 8);
            sAux = campo.getDBStmtInsertValues();
            if (sAux != "") {
                stmt += sAux + ", ";
            }
        }
        return stmt;
    }

    public String getDBStmtUpdate() {
        String stmt = "";
        String sAux = "";
        for (Campo campo : this.campos) {
            SysOut.dbgprintln("stmt: " + stmt + " / sAux: " + sAux, 8);
            sAux = campo.getDBStmtUpdate();
            if (sAux != "") {
                stmt += sAux + ", ";
            }
        }
        return stmt;
    }

    public Condiciones getDBStmtCondicionesPK(){
        Condiciones con = new Condiciones();        
        for (Campo campo : this.campos){con.add(ConectorCondicion.ConectorCondiciones.AND, new Condicion(campo, IGUAL));}
        return con;
    }

    public boolean fetchDB(ResultSet rs) {
        for (Campo campo : this.campos) {
            SysOut.dbgprintln("Voy a hacer fetch() del campo (" + campo.toString() + ") con el ResultSet (" + rs.toString() + ")", 8);
            if (!campo.fetchDB(rs)) {
                SysOut.dbgprintln("Al hacer fetch() del campo (" + campo.toString() + ") el resultado es FALSE y corto el for", 8);
                return false;
            }
        }
        SysOut.dbgprintln("fetch() Terminado para todos los " + this.campos.size() + " campos", 8);
        return true;
    }

    public boolean tieneAlgunCampo() {
        return (this.campos.size() > 0);
    }

    public int size() {
        return this.campos.size();
    }

// METODOS PRIVADOS

}
