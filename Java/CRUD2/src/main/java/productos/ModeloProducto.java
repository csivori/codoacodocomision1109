package productos;

import config.BaseDeDatos;
import java.util.*;
import java.sql.*;
import javax.sql.DataSource;

public class ModeloProducto {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
//    private DataSource origenDatos;
    private BaseDeDatos origenDatos;
    
// CONSTRUCTORES
//public ModeloProducto(DataSource origenDatos){
public ModeloProducto(BaseDeDatos origenDatos){
        this.origenDatos = origenDatos;
}

// GETTERs & SETTERs
// OVERRIDES
    @Override
    public String toString() {
        return "ModeloProductos [origenDatos]: " + origenDatos.toString();
    }

// METODOS PUBLICOS
    public List<Producto> getProductos() throws Exception {
        List<Producto> productos = new ArrayList<>();
        
        Connection miConexion = null;
        Statement stmt = null;
        ResultSet rs = null;
        miConexion = origenDatos.getConection();
        stmt = miConexion.createStatement();
        rs = stmt.executeQuery("SELECT * FROM PRODUCTOS");
        while (rs.next()){
            productos.add(new Producto(rs.getString("Codigo"), rs.getString("Seccion"), rs.getString("Nombre"), rs.getFloat("Precio"), rs.getDate("Fecha"), rs.getString("Importado"), rs.getString("PaisOrigen"), rs.getBlob("Foto"), rs.getDate("ts")));
        }
        return productos;
    }
// METODOS PRIVADOS

}
