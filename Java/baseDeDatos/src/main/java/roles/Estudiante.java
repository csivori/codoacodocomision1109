package roles;

import modelo.*;
import modelo.Campo.AccionesCampo;
import modelo.Valor.TipoValor;

public class Estudiante extends Persona
{
    public Estudiante(){
        super("Estudiante", false, "ESTUDIANTES");
        this.datosPer.addCampo(new Campo("Hobbie", false, false, "hobbie", TipoValor.STR, AccionesCampo.CRUD));
        this.datosPer.addCampo(new Campo("Editor de Texto Preferido", false, true, "editor_pref", TipoValor.STR, AccionesCampo.CRUD));
        this.datosPer.addCampo(new Campo("Sistema Operativo", false, false, "sistema_operativo", TipoValor.STR, AccionesCampo.CRUD));
    }
}