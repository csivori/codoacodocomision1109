package modelo;

public class Condicion {
//    public enum CondicionesCampo {IGUAL, DISTINTO, MAYOR, MAYORoIGUAL, MENOR, MENORoIGUAL};
    public enum CondicionesCampo {
        IGUAL("="), DISTINTO("!="), MAYOR(">"), MAYORoIGUAL(">="), MENOR("<"), MENORoIGUAL("<=");
        private String simbolo;
        private CondicionesCampo(String simbolo){this.simbolo = simbolo;}
        public String toString(){return simbolo;}
    };
    private CondicionesCampo condicion;
    private Campo campo;
    
    public Condicion(String colDB, CondicionesCampo condicion, Valor valor) {
        this.condicion = condicion;
        this.campo = new Campo("campoCondicion", false, false, colDB, valor, null);
    }
    public Condicion(Campo campo, CondicionesCampo condicion) {
        this.campo = campo;
        this.condicion = condicion;
    }

//    public String getDBStmtWhere(){return "(" + this.campo.getDBStmtCondicionStr(getSimbolo()) + ")";}
    public String getDBStmtWhere(){return "(" + this.campo.getDBStmtCondicionStr(this.condicion.toString()) + ")";}
    
// METODOS PRIVADOS
    
//    private String getSimbolo(){
//        switch (this.condicion){
//            case IGUAL: return "=";
//            case DISTINTO: return "!=";
//            case MAYOR: return ">";
//            case MAYORoIGUAL: return ">=";
//            case MENOR: return "<";
//            case MENORoIGUAL: return "<=";
//        }
//        return "ERROR";
//    }
}
