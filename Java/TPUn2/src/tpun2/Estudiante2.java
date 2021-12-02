package tpun2;

import tpun2.Valor.TipoValor;

public class Estudiante2 extends Persona2
{
    public Estudiante2(){
        super("Estudiante", false, "ESTUDIANTES");
        this.datosPer.addCampo(new Campo("Hobbie", false, false, "hobbie", TipoValor.STR));
        this.datosPer.addCampo(new Campo("Editor de Texto Preferido", false, true, "editor_pref", TipoValor.STR));
        this.datosPer.addCampo(new Campo("Sistema Operativo", false, false, "sistema_operativo", TipoValor.STR));
    }
}