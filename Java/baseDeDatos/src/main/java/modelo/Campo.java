package modelo;

import base.Scanner2;
import base.SysOut;
import java.sql.ResultSet;
import java.sql.Timestamp;

public final class Campo extends Valor {

// TIPOS de DATO PUBLICOS
    
    public enum AccionesCampo {
        CRUD, RUD
    };
    
// ATRIBUTOS PRIVADOS

    private String etiqueta;
    private boolean esFemenino;
    private boolean permiteNulo;
    private String colDB;
    private AccionesCampo ac;

// CONSTRUCTORES

    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, Valor valor, AccionesCampo ac) {
        super(valor);
        SysOut.dbgprintln("Creé el valor " + valor.toString() + " con valor " + valor.getDBStmtValue() + " para el campo " + etiqueta, 9);
        setAtributos(etiqueta, esFemenino, permiteNulo, colDB, ac);
        SysOut.dbgprintln("Creé el campo " + etiqueta + " sin valor inicial", 9);
    }

    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, TipoValor tv, AccionesCampo ac) {
        super(tv);
        SysOut.dbgprintln("Creé el valor " + tv + " para el campo " + etiqueta + " sin valor inicial", 9);
        setAtributos(etiqueta, esFemenino, permiteNulo, colDB, ac);
        SysOut.dbgprintln("Creé el campo " + etiqueta + " sin valor inicial", 9);
    }

    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, int i, AccionesCampo ac) {
        super(i);
        SysOut.dbgprintln("Creé el valor ENT para el campo " + etiqueta + " con valor inicial: " + i, 9);
        setAtributos(etiqueta, esFemenino, permiteNulo, colDB, ac);
        SysOut.dbgprintln("Creé el campo " + etiqueta + " con valor inicial: " + i, 9);
    }

    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, String s, AccionesCampo ac) {
        super(s);
        SysOut.dbgprintln("Creé el valor STR para el campo " + etiqueta + " con valor inicial: " + s, 9);
        setAtributos(etiqueta, esFemenino, permiteNulo, colDB, ac);
        SysOut.dbgprintln("Creé el campo " + etiqueta + " con valor inicial: " + s, 9);
    }

    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, Timestamp ts, AccionesCampo ac) {
        super(ts);
        SysOut.dbgprintln("Creé el valor TS para el campo " + etiqueta + " con valor inicial: " + ts.toString(), 9);
        this.setAtributos(etiqueta, esFemenino, permiteNulo, colDB, ac);
        SysOut.dbgprintln("Creé el campo " + etiqueta + " con valor inicial: " + ts.toString(), 9);
    }

// GETTERs & SETTERs
    public String getEtiqueta() {
        return this.etiqueta;
    }

    public String getColDB() {
        return this.colDB;
    }

    public boolean setAtributos(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, AccionesCampo ac) {
        this.etiqueta = etiqueta;
        this.esFemenino = esFemenino;
        this.permiteNulo = permiteNulo;
        this.colDB = colDB;
        this.ac = ac;
        return true;
    }

// METODOS PUBLICOS
    @Override
    public String toString(){return "Campo(" + this.etiqueta + ", NULOS: " + ((this.permiteNulo)?"":"NO ") + "Permite, Tabla: " + this.colDB + " Valor: " + super.getDBStmtValue() + ")";}

    public boolean cargar(Scanner2 sn2) {
        if (this.ac == AccionesCampo.CRUD) {
            do {
                super.cargar(sn2, this.etiqueta);
            } while (!validarNulo());
            return !super.cargaAbortada();
        } else {return true;}
    }

    public void mostrar() {
        super.mostrar(etiqueta);
    }

    public String getDBStmtCreateTable() {
        return colDB + " " + getDBStmtTipoDato() + ((!permiteNulo) ? " NOT NULL" : "");
    }

    public String getDBStmtSelectCols() {
        return (((this.ac == AccionesCampo.CRUD) || (this.ac == AccionesCampo.RUD)) ? colDB : "");
    }

    public String getDBStmtInsertCols() {
        return ((this.ac == AccionesCampo.CRUD) ? ("`" + colDB + "`") : "");
    }

    public String getDBStmtInsertValues() {
        return ((this.ac == AccionesCampo.CRUD) ? getDBStmtValue() : "");
    }

    public String getDBStmtUpdate() {
        return (((this.ac == AccionesCampo.CRUD) || (this.ac == AccionesCampo.RUD)) ? getDBStmtCondicionStr("=") : "");
    }

    public String getDBStmtCondicionStr(String simbolo) {
        return this.colDB + simbolo + getDBStmtValue();
    }

    public boolean fetchDB(ResultSet rs){
        SysOut.dbgprintln("Voy a hacer fetch() del campo (" + this.etiqueta + ") con el ResultSet (" + rs.toString() + ")", 8);
        boolean bOk = super.fetchDB(rs, this.colDB);
        SysOut.dbgprintln("Resultado del fetch() del campo (" + this.etiqueta + "): " + bOk, 8);
        return bOk;
    }

// PRIVADAS
    private String getArticulo() {
        return (((esFemenino) ? "La " : "El ") + etiqueta);
    }

    private boolean validarNulo() {
        if (!permiteNulo) {
            if (esNulo) {
                SysOut.dbgprintln(getArticulo() + " NO permite NULOS", 8);
                return false;
            } else if (esVacio()) {
                SysOut.dbgprintln(getArticulo() + " NO puede ser VACIO o CERO", 8);
                return false;
            }
        }
        return true;
    }
}
