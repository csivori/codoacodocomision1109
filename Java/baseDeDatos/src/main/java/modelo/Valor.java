package modelo;

import base.Scanner2;
import base.SysOut;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Valor {
// ATRIBUTOS PUBLICOS
    public enum TipoValor {
        ENT, STR, FECHA, TS
    };
    public int cargaEntAbortada = -99;
    public String cargaStrAbortada = "salir";            
// ATRIBUTOS PRIVADOS
    protected Boolean esNulo;
    private String s;
    private int i;
    private Timestamp ts;
    private final TipoValor tv;

// CONSTRUCTORES
    public Valor(Valor v) {
        this.tv = v.tv;
        this.esNulo = v.esNulo;
        this.i = v.i;
        this.s = v.s;
        this.ts = v.ts;
    }

    public Valor(TipoValor tv) {
        this.tv = tv;
        this.esNulo = true;
    }

    public Valor(int i) {
        this.esNulo = false;
        this.i = i;
        this.tv = TipoValor.ENT;
    }

    public Valor(String s) {
        this.esNulo = false;
        this.s = s;
        this.tv = TipoValor.STR;
    }

    public Valor(Timestamp ts) {
        SysOut.dbgprintln("Voy a crear un valor tipo Timestamp", 10);
        this.esNulo = false;
        this.ts = ts;
        this.tv = TipoValor.TS;
    }

// GETTER's
    public String getValorS() {
        if (tv == TipoValor.STR) {
            return (this.esNulo) ? null : s;
        } else {/*Levantar la Excepción!!*/ return "";
        }
    }

    public int getValorI() {
        if (tv == TipoValor.ENT) {
            return (this.esNulo) ? null : i;
        } else {
            /*Levantar la Excepción!!*/ return 0;
        }
    }

    public Timestamp getValorTS() {
        if (tv == TipoValor.TS) {
            return (this.esNulo) ? null : ts;
        } else {
            /*Levantar la Excepción!!*/ return null;
        }
    }

// SETTER's
    public boolean setValorNulo() {
        this.esNulo = true;
        return true;
    }

    public boolean setValor(String s) {
        SysOut.dbgprintln("Voy a setear el valor STR actual: " + this.s + " con el nuevo valor: " + s, 10);
        if (tv == TipoValor.STR) {
            this.esNulo = false;
            this.s = s;
            return true;
        } else {
            return false;
        }
    }

    public boolean setValor(int i) {
        SysOut.dbgprintln("Voy a setear el valor ENT actual: " + this.i + " con el nuevo valor: " + i, 10);
        if (tv == TipoValor.ENT) {
            this.esNulo = false;
            this.i = i;
            return true;
        } else {
            return false;
        }
    }

    public boolean setValor(Timestamp ts) {
        SysOut.dbgprintln("Voy a setear el valor TS actual: " + ((this.ts == null) ? "null" : this.ts.toString()) + " con el nuevo valor: " + ts.toString(), 10);
        if (tv == TipoValor.TS) {
            this.esNulo = false;
            this.ts = ts;
            return true;
        } else {
            return false;
        }
    }

// ACCIONES
    public void cargar(Scanner2 sn2, String etiqueta) {
        SysOut.dbgprintln("Voy a cargar un campo tipo " + this.tv + " con etiqueta " + etiqueta, 10);
        switch (this.tv) {
            case ENT:
                setValor(sn2.cargarCampo(etiqueta, this.i));
                break;
            case STR:
                setValor(sn2.cargarCampo(etiqueta, this.s));
                break;
            case TS:
                break;
            default:
                /*Levantar la Excepción!!*/
                break;
        }
        SysOut.dbgprintln("Cargé un campo tipo " + this.tv + " con etiqueta " + etiqueta, 10);
    }

    public void mostrar(String etiqueta) {
        switch (this.tv) {
            case ENT:
                System.out.println(etiqueta + ": " + ((this.esNulo) ? "" : this.i));
                break;
            case STR:
                System.out.println(etiqueta + ": " + ((this.esNulo) ? "" : this.s));
                break;
            case TS:
                System.out.println(etiqueta + ": " + ((this.esNulo) ? "" : this.ts.toString()));
                break;
            default:
                /*Levantar la Excepción!!*/
                break;
        }
    }

    public boolean esVacio() {
        switch (this.tv) {
            case ENT:
                return (this.esNulo || this.i == 0);
            case STR:
                return (this.esNulo || this.s == "");
            default:
                /*Levantar la Excepción!!*/
                return false;
        }
    }

    public boolean cargaAbortada() {
        switch (this.tv) {
            case ENT:
                return (!this.esNulo || this.i == cargaEntAbortada);
            case STR:
                return (!this.esNulo || this.s == cargaStrAbortada);
            default:
                /*Levantar la Excepción!!*/
                return false;
        }
    }

// METODOS PUBLICOS para DB SQL
    public String getDBStmtTipoDato() {
        switch (this.tv) {
            case ENT:
                return "INT";
            case STR:
                return "VARCHAR(255)";
            case TS:
                return "TIMESTAMP";
            default:
                /*Levantar la Excepción!!*/
                return "** ERROR de TIPO de DATO **";
        }
    }

    public String getDBStmtValue() {
        switch (this.tv) {
            case ENT:
                return Integer.toString(i);
            case STR:
                return "\'" + s + "\'";
            case TS:
                return "\'" + ts + "\'";
            default:
                /*Levantar la Excepción!!*/
                return "** ERROR de TIPO de DATO **";
        }
    }

    public boolean fetchDB(ResultSet rs, String colDB) {
        boolean bOk = true;
        SysOut.dbgprintln("Voy a hacer fetch() del campo (" + colDB + ") con el ResultSet (" + rs.toString() + ")", 10);
        try {
            switch (this.tv) {
                case ENT:
                    bOk = setValor(rs.getInt(colDB));
                    break;
                case STR:
                    bOk = setValor(rs.getString(colDB));
                    break;
                case TS:
                    bOk = setValor(rs.getTimestamp(colDB));
                    break;
                case FECHA:
                    break;
                default:
                    throw new AssertionError(this.tv.name());

            }
        } catch (SQLException e) {
            bOk = false;
        }
        SysOut.dbgprintln("Resultado del setValor(fetch()) del campo (" + colDB + "): " + bOk, 8);
        return bOk;
    }

}
