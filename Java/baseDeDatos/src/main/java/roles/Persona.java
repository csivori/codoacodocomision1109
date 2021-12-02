package roles;

import base.SysOut;
import config.BaseDeDatos;
import java.sql.ResultSet;
import modelo.*;
import modelo.Campo.AccionesCampo;
import static modelo.Condicion.CondicionesCampo.IGUAL;
import modelo.Valor.TipoValor;

public class Persona {
// ATRIBUTOS PUBLICOS
// ATRIBUTOS PRIVADOS

    protected GrpCampos datosPer;

// CONSTRUCTORES

    public Persona() {
        this("Persona", true, "PERSONAS");
        SysOut.dbgprintln("Persona Creada sin valores", 4);
    }

    public Persona(int id, BaseDeDatos bd) {
        this();
        SysOut.dbgprintln("Persona Creada. Voy a Cargar la Persona: " + id + " de la DB", 4);
        this.recuperar(id, bd);
    }

    public Persona(String rol, boolean esFemenino, String tblDB) {
        SysOut.dbgprintln("Voy a crear una Persona con rol: " + rol + " y Tabla: " + tblDB, 4);
        this.datosPer = new GrpCampos(rol, esFemenino, tblDB, true);
        this.datosPer.addCampoPK(new Campo("id", false, true, "id", TipoValor.ENT, AccionesCampo.RUD));
        this.datosPer.addCampo(new Campo("Nombre", false, false, "nombre", TipoValor.STR, AccionesCampo.CRUD));
        this.datosPer.addCampo(new Campo("Apellido", false, false, "apellido", TipoValor.STR, AccionesCampo.CRUD));
        this.datosPer.addCampo(new Campo("Edad", true, false, "edad", TipoValor.ENT, AccionesCampo.CRUD));
        SysOut.dbgprintln("Creé una Persona con rol: " + rol + " y Tabla: " + tblDB, 4);
    }

// GETTERs & SETTERs

    public boolean setPK(int id){
        if (this.datosPer.setCampo("id", id)) {return this.datosPer.setCamposNoPKValorNulo();}
        return false;
    }
    
    public boolean setNombre(String nombre){
        return this.datosPer.setCampo("nombre", nombre);
    }

    public boolean setApellido(String apellido){
        return this.datosPer.setCampo("apellido", apellido);
    }

    public boolean setEdad(int edad){
        return this.datosPer.setCampo("edad", edad);
    }

// METODOS PUBLICOS

    public void cargar() {
        cargar(true);
    }

    public void cargar(boolean mostrarTitulo) {
        datosPer.cargar(mostrarTitulo);
    }

    public void mostrar() {
        mostrar(true);
    }    
    
    public void mostrar(boolean mostrarTitulo) {
        datosPer.mostrar(mostrarTitulo);
    }

    public boolean recuperar(int id, BaseDeDatos bd){
        if (this.setPK(id)) {return this.recuperar(bd);}
        return false;
    }
    
    public boolean recuperar(BaseDeDatos bd){
        if (bd != null)  {this.datosPer.fetchDBSoloCamposNoPK(bd.exSelectFirst(this.getDBStmtSelectByPK()));}        
        return false;
    }

    public boolean insertar(BaseDeDatos bd){
        return this.datosPer.insertar(bd);
    }

    public boolean actualizar(BaseDeDatos bd){
        return this.datosPer.actualizar(bd);
    }

    public boolean borrar(BaseDeDatos bd){
        return this.datosPer.borrar(bd);
    }

    public String getDBStmtCreateTable() {
        return datosPer.getDBStmtCreateTable();
    }

    public String getDBStmtSelect(Condiciones condiciones) {
        return datosPer.getDBStmtSelectRecord(condiciones);
    }

    public String getDBStmtSelectByPK() {
        return datosPer.getDBStmtSelectRecordByPK();
    }

    public String getDBStmtInsert() {
        return datosPer.getDBStmtInsert();
    }    

    public String getDBStmtUpdate() {
        return datosPer.getDBStmtUpdate();
    }    

    public String getDBStmtDelete() {
        return datosPer.getDBStmtDelete();
    }    
}
