package modelo;

import base.Scanner2;
import base.SysOut;
import config.BaseDeDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import modelo.Campo.AccionesCampo;
import static modelo.Condicion.CondicionesCampo.IGUAL;

public class GrpCampos {
// ATRIBUTOS PRIVADOS
    private final String etiquetaTimeStamp = "TS"; 
    private final String colTimeStamp = "ts"; 
    private String rol, tblDB;
    private boolean esFemenino; // Sirve para decidir "El" o "La"
    private boolean controlaTS; // Sirve para controlar concurrencia x TimeStamp
    private Valor TS; // Guarda el último valor de TS recuperado de la tabla
    private Campos camposPK;
    private Campos campos;

// CONSTRUCTORES
    public GrpCampos(String rol, boolean esFemenino, String tblDB) {this(rol, esFemenino, tblDB, false);}
    public GrpCampos(String rol, boolean esFemenino, String tblDB, boolean controlaTS) {this(rol, esFemenino, tblDB, controlaTS, null, null);}
    public GrpCampos(String rol, boolean esFemenino, String tblDB, boolean controlaTS, Campos camposPK, Campos campos) {
        SysOut.dbgprintln("Voy a crear una Entidad con rol: " + rol + " Tabla: " + tblDB + " y " + ((controlaTS)?"con":"sin") + " control de TS", 4);
        this.rol = rol;
        this.esFemenino = esFemenino;
        this.tblDB = tblDB;
        if (camposPK == null) {this.camposPK = new Campos();} else {this.camposPK = camposPK;}
        if (campos == null) {this.campos = new Campos();} else {this.campos = campos;}
        this.controlaTS = controlaTS;
        if (controlaTS) {TS = new Valor(Valor.TipoValor.TS);}
        SysOut.dbgprintln("Creé una Entidad con rol: " + rol + " Tabla: " + tblDB + " y " + ((controlaTS)?"con":"sin") + " control de TS y " + this.camposPK.cantCampos() + " columnas PK y " + this.campos.cantCampos() + " columnas", 4);
    }
    
// GETTERs & SETTERs
    
    public Campo getCampo(String colDB){
        Campo campo = this.camposPK.getCampo(colDB);
        if (campo == null) {campo = this.campos.getCampo(colDB);}
        return (campo == null) ? null : campo;
    }
    public void setRol(String rol, boolean esFemenino) {this.rol = rol; this.esFemenino = esFemenino;}
    public void setTblDB(String tblDB) {this.tblDB = tblDB;}
    public boolean setCampo(String colDB, int valor){
        Campo campo = getCampo(colDB);
        return (campo == null) ? false : campo.setValor(valor);
    }
    public boolean setCampo(String colDB, String valor){
        Campo campo = getCampo(colDB);
        return (campo == null) ? false : campo.setValor(valor);
    }
    public boolean setCamposNoPKValorNulo() {
        if (this.campos.setCamposValorNulo()){return this.TS.setValorNulo();}
        return false;
    }
    
// METODOS PUBLICOS
    
    public void addCampoPK(Campo campo) {this.camposPK.addCampo(campo);}
    public void addCampo(Campo campo) {this.campos.addCampo(campo);}
    
    public boolean cargar(){return cargar(true);}
    public boolean cargar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nIngrese los datos de" + ((this.esFemenino) ? " la " : "l ") + this.rol + "\n");
        Scanner2 sn2 = new Scanner2();
        boolean bOk;
        bOk = this.camposPK.cargar(sn2);
        if (bOk) {bOk = this.campos.cargar(sn2);}
        sn2.close();
        return bOk;
    }
    
    public void mostrar(){mostrar(true);}
    public void mostrar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nPerfil de" + ((this.esFemenino) ? " la " : "l ") + this.rol + "\n");
        this.camposPK.mostrar();
        this.campos.mostrar();
        if (this.controlaTS) {TS.mostrar("Timestamp");}
    }

    public boolean insertar(BaseDeDatos bd){
        return (bd != null) ? bd.exInsUpdDel(this.getDBStmtInsert()) : false;
    }
        
    public boolean actualizar(BaseDeDatos bd){
        return (bd != null) ? bd.exInsUpdDel(this.getDBStmtUpdate()) : false;
    }
        
    public boolean borrar(BaseDeDatos bd){
        return (bd != null) ? bd.exInsUpdDel(this.getDBStmtDelete()) : false;
    }
        
    public String getDBStmtCreateTable(){
        if (tieneAlgunCampo()) {
            String stmt = "CREATE TABLE " +  tblDB + " (";
            stmt += this.camposPK.getDBStmtCreateTableSoloCampos() + ", ";        
            stmt += this.campos.getDBStmtCreateTableSoloCampos() + ", ";
            String sAux = this.getDBStmtCreateTableWithColumnTS();
            return ((controlaTS) ? stmt + sAux : stmt.substring(0,(stmt.length()-2))) + ")";
        } else {
            SysOut.dbgprintln("No se puede crear el DDL:CREATE de la tabla " + tblDB + " xq no tiene columnas", 8);
            return "";
        }
    }

    public String getDBStmtSelectRecord(Condiciones camposWHERE){
        if (tieneAlgunCampo()) {
            String sAux = "";
            String stmt = "SELECT ";
            stmt += this.camposPK.getDBStmtSelectCols();
            stmt += this.campos.getDBStmtSelectCols();
            SysOut.dbgprintln("Campos Cargados. stmt: " + stmt, 8);
            stmt = (this.controlaTS) ? stmt + colTimeStamp : stmt.substring(0,(stmt.length()-2));
            SysOut.dbgprintln("Campo TS " + ((this.controlaTS) ? "Agregado" : "No controla") + ". stmt: " + stmt, 8);
            stmt += " FROM " + tblDB;
            SysOut.dbgprintln("Campos y FROM Cargados. stmt: " + stmt, 8);
            stmt += (camposWHERE != null) ? " WHERE " + camposWHERE.getDBStmtWhere() : "";
            SysOut.dbgprintln("Campos, FROM y WHERE Cargados. stmt: " + stmt, 8);
            return stmt;
        } else {
            SysOut.dbgprintln("No se puede crear el DDL:SELECT de la tabla " + tblDB + " xq no tiene columnas", 8);
            return "";
        }
    }
    
    public String getDBStmtSelectRecordByPK() {
        return this.getDBStmtSelectRecord(this.getDBStmtCondicionesPK());
    }
        
    public String getDBStmtInsert(){
        if (tieneAlgunCampo()) {
            String sAux = "";
            String sValues = " VALUES (";
            String stmt = "INSERT INTO " +  tblDB + " (";
            sAux = this.camposPK.getDBStmtInsertCols();
            if (sAux != "") {
                stmt += sAux + ", ";
                sValues += this.camposPK.getDBStmtInsertValues() + ", ";
            }
            SysOut.dbgprintln("stmt: " + stmt + " / sValues: " + sValues + " / sAux: " + sAux, 8);
            sAux = this.campos.getDBStmtInsertCols();
            if (sAux != "") {
                stmt += sAux;
                sValues += this.campos.getDBStmtInsertValues();
            }
            SysOut.dbgprintln("stmt: " + stmt + " / sValues: " + sValues + " / sAux: " + sAux, 8);
            stmt = stmt.substring(0,(stmt.length()-2)) + ")" + sValues.substring(0,(sValues.length()-2)) + ")";
            return stmt;
        } else {        
            SysOut.dbgprintln("No se puede crear el DDL:INSERT de la tabla " + tblDB + " xq no tiene columnas", 8);
            return "";
        }
    }

    public String getDBStmtUpdate(){
        if (tieneAlgunCampo()) {
            String sAux = this.campos.getDBStmtUpdate();
            if (sAux != "") {
                String stmt = "UPDATE " +  tblDB + " SET " + sAux.substring(0,(sAux.length()-2))  + " WHERE " + this.getDBStmtCondicionesPKconTS().getDBStmtWhere();
                SysOut.dbgprintln("stmt: " + stmt + " / sAux: " + sAux, 8);                
                return stmt;
            } else {
                SysOut.dbgprintln("No se puede crear el DDL:UPDATE de la tabla " + tblDB + " xq no tiene columnas", 8);
                return "";
            }
        } else {
            SysOut.dbgprintln("No se puede crear el DDL:UPDATE de la tabla " + tblDB + " xq no tiene columnas", 8);
            return "";
        }
    }

    public String getDBStmtDelete(){
        SysOut.dbgprintln("Creando el DDL:DELETE de la tabla " + tblDB, 8);
        return "DELETE FROM " +  tblDB + " WHERE " + this.getDBStmtCondicionesPKconTS().getDBStmtWhere();
    }

    public Condiciones getDBStmtCondicionesPK(){return this.camposPK.getDBStmtCondicionesPK();}
    public Condiciones getDBStmtCondicionesPKconTS(){
        Condiciones camposWHERE = this.getDBStmtCondicionesPK();
        if (this.controlaTS) {
            camposWHERE.add(ConectorCondicion.ConectorCondiciones.AND, new Condicion(this.colTimeStamp, Condicion.CondicionesCampo.IGUAL, this.TS));
        }
        return camposWHERE;
    }
    
    public boolean fetchDBTodosLosCampos(ResultSet rs){return (this.camposPK.fetchDB(rs) && this.campos.fetchDB(rs));}
    
    public boolean fetchDBSoloCamposNoPK(ResultSet rs){
        boolean bOk = this.campos.fetchDB(rs);
        if (bOk && this.controlaTS){
            SysOut.dbgprintln("Voy a hacer fetch() del campo (" + colTimeStamp + ") con el ResultSet (" + rs.toString() + ")", 8);
            bOk = this.TS.fetchDB(rs, colTimeStamp); 
            if (!bOk){
                SysOut.dbgprintln("Al hacer fetch() del campo (" + colTimeStamp + ") el resultado es FALSE", 8);
                return false;
            }
        }
        SysOut.dbgprintln("fetch() Terminado para todos los " + this.campos.size() + " campos NO PK", 8);
        return true;
    }

// METODOS PRIVADOS

    private String getDBStmtCreateTableWithColumnTS(){
        if (controlaTS) {return (new Campo(etiquetaTimeStamp, false, true, colTimeStamp, Valor.TipoValor.TS, AccionesCampo.RUD)).getDBStmtCreateTable() + " DEFAULT current_timestamp()";}
        else {return "";}
    }

    private boolean tieneAlgunCampo(){return ((this.camposPK.tieneAlgunCampo()) || (this.campos.tieneAlgunCampo()));}

}
