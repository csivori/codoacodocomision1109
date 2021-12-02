package modelo;

public class ConectorCondicion {
    public enum ConectorCondiciones {AND, OR};
    private ConectorCondiciones conectorCondicion;
    
    public ConectorCondicion(ConectorCondiciones conectorCondicion) {this.conectorCondicion = conectorCondicion;}
    public ConectorCondicion(String sConectorCondicion) {
        if ("AND".equals(sConectorCondicion.trim().toUpperCase())) {this.conectorCondicion = ConectorCondiciones.AND;}
        else {this.conectorCondicion = ConectorCondiciones.OR;}
    }

    @Override
    public String toString(){return (conectorCondicion == ConectorCondiciones.AND) ? " AND " : " OR ";}
}
