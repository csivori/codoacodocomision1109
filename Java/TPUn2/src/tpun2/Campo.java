package tpun2;

public class Campo extends Valor{
    private String etiqueta;
    private boolean esFemenino;
    private boolean permiteNulo;
    private String colDB;
    
    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, TipoValor tv) {
        super(tv);
        setAtributos(etiqueta, esFemenino, permiteNulo, colDB);
    }    
    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, int i) {
        super(i);
        setAtributos(etiqueta, esFemenino, permiteNulo, colDB);
    }
    public Campo(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB, String s) {
        super(s);
        setAtributos(etiqueta, esFemenino, permiteNulo, colDB);
    }

// SETTERs

    public void setAtributos(String etiqueta, boolean esFemenino, boolean permiteNulo, String colDB) {
        this.etiqueta = etiqueta;
        this.esFemenino = esFemenino;
        this.permiteNulo = permiteNulo;
        this.colDB = colDB;
    }
    
// ACCIONES
    
    public void cargar(Scanner2 sn2){
        do{
            super.cargar(sn2, etiqueta);
        } while (!validarNulo()); 
    }
    
    public void mostrar(){super.mostrar(etiqueta);}
    
    public String getDBStmtCreateTable(){
        return colDB + " " + getDBStmtTipoDato() + ((!permiteNulo) ? " NOT NULL" : "") ;
    }

// PRIVADAS
        
    private String getArticulo(){
        return (((esFemenino) ? "La " : "El ") + etiqueta);
    }
    
    private boolean validarNulo(){
        if (!permiteNulo) {
            if (esNulo) {
                System.out.println("*** " + getArticulo() + " NO permite NULOS ***");
                return false;
            } else if (esVacio()) {
                System.out.println("*** " + getArticulo() + " NO puede ser VACIO o CERO ***");
                return false;
            }
        }
        return true;
    }
}
