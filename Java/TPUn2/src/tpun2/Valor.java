package tpun2;

public class Valor {
    public enum TipoValor {ENT, STR, FECHA};
    protected Boolean esNulo;
    private String s;
    private int i;
    private final TipoValor tv;

// CONSTRUCTORES
    
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

// GETTER's
    
    public String getValorS() {
        if (tv == TipoValor.STR) {return s;} else {/*Levantar la Excepción!!*/ return "";}
    }
    public int getValorI() {
        if (tv == TipoValor.ENT) {return i;} else { /*Levantar la Excepción!!*/ return 0;}
    }

// SETTER's

    public void setValorNulo() {
        this.esNulo = true;
    }
    public void setValor(String s) {
        if (tv == TipoValor.STR) {this.esNulo = false; this.s = s;} else {/*Levantar la Excepción!!*/}
    }
    public void setValor(int i) {
        if (tv == TipoValor.ENT) {this.esNulo = false; this.i = i;} else {/*Levantar la Excepción!!*/}
    }

// ACCIONES

    public void cargar(Scanner2 sn2, String etiqueta){
        switch (this.tv) {
            case ENT:
                setValor(sn2.cargarCampo(etiqueta, this.i));
                break;
            case STR:
                setValor(sn2.cargarCampo(etiqueta, this.s));
                break;
            default:
                /*Levantar la Excepción!!*/
                break;
        }
    }
    
    public void mostrar(String etiqueta){
        switch (this.tv) {
            case ENT:
                System.out.println(etiqueta + ": " + ((this.esNulo) ? "" : this.i));
                break;
            case STR:
                System.out.println(etiqueta + ": " + ((this.esNulo) ? "" : this.s));
                break;
            default:
                /*Levantar la Excepción!!*/
                break;
        }
    }
    
    public boolean esVacio(){
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
    public String getDBStmtTipoDato() {
        switch (this.tv) {
            case ENT:
                return "INT";
            case STR:
                return "VARCHAR(255)";
            default:
                /*Levantar la Excepción!!*/
                return "** ERROR de TIPO de DATO **";
        }
    }
}
