package roles;

import modelo.*;
import modelo.Campo.AccionesCampo;
import modelo.Valor.TipoValor;

public class Docente extends Persona
{
    public Docente(){
        super("Docente", false, "DOCENTES");
        this.datosPer.addCampo(new Campo("AnosExperiencia", false, false, "anos_experiencia", TipoValor.ENT, AccionesCampo.CRUD));
        this.datosPer.addCampo(new Campo("Matricula", true, false, "matricula", TipoValor.ENT, AccionesCampo.CRUD));
    }
}