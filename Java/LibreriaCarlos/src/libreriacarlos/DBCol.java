package libreriacarlos;


public class DBCol {
    enum tipoCol {ENT, STR, FECHA}; 
    String nombre;
    tipoCol tipo;

    public DBCol(String nombre, tipoCol tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
}
