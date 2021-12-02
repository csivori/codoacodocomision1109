package tpun2;

import tpun2.Valor.TipoValor;

public class Persona2 {
    protected GrpCampos datosPer;

    public Persona2(){this("Persona", true, "PERSONAS");}
    public Persona2(String rol, boolean esFemenino, String tblDB){
        this.datosPer = new GrpCampos(rol, esFemenino, tblDB);
        this.datosPer.addCampo(new Campo("Nombre", false, false, "nombre", TipoValor.STR));
        this.datosPer.addCampo(new Campo("Apellido", false, false, "apellido", TipoValor.STR));
        this.datosPer.addCampo(new Campo("Edad", true, false, "edad", TipoValor.ENT));
    }

    public void cargar(){cargar(true);}
    public void cargar(Boolean mostrarTitulo){datosPer.cargar(mostrarTitulo);}

    public void mostrar(){mostrar(true);}
    public void mostrar(Boolean mostrarTitulo){datosPer.mostrar(mostrarTitulo);}

    public String getDBStmtCreateTable(){return datosPer.getDBStmtCreateTable();}
}
