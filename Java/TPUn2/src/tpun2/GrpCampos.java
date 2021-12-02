package tpun2;

import java.util.ArrayList;

public class GrpCampos {
    private String rol, tblDB;
    private boolean esFemenino; // Sirve para decidir "El" o "La"
    ArrayList<Campo> campos;

    public GrpCampos(String rol, boolean esFemenino, String tblDB) {
        this.rol = rol;
        this.esFemenino = esFemenino;
        this.tblDB = tblDB;
        this.campos = new ArrayList<Campo>();
    }
    public GrpCampos(String rol, boolean esFemenino, String tblDB, Campo[] campos) {
        this(rol, esFemenino, tblDB);
        for (Campo campo : campos){this.campos.add(campo);};
    }
    
// SETTERs
    
    public void setRol(String rol, boolean esFemenino) {this.rol = rol; this.esFemenino = esFemenino;}
    public void setTblDB(String tblDB) {this.tblDB = tblDB;}
    
// ACCIONES
    
    public void addCampo(Campo campo) {this.campos.add(campo);}
    
    public void cargar(){cargar(true);}
    public void cargar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nIngrese los datos de" + ((this.esFemenino) ? " la " : "l ") + this.rol + "\n");
        Scanner2 sn2 = new Scanner2();
        for (Campo campo : this.campos){campo.cargar(sn2);}
        sn2.close();
    }
    
    public void mostrar(){mostrar(true);}
    public void mostrar(Boolean mostrarTitulo){
        if (mostrarTitulo) System.out.println("\nPerfil de" + ((this.esFemenino) ? " la " : "l ") + this.rol + "\n");
        for (Campo campo : this.campos){campo.mostrar();}
    }

    public String getDBStmtCreateTable(){
        String stmt = "CREATE TABLE " +  tblDB + " (";
        for (Campo campo : this.campos){stmt += campo.getDBStmtCreateTable() + ", ";}        
        return stmt + ((this.campos.size()>0) ? "\b\b" : "") + ")";
    }
}
