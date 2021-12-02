package Patron_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/comision1109/";
    private final String BASE_DATO = "bancos";
    private final String USER = "root";
    private final String PWD = "";
    protected Connection con;

    public void conectar() throws Exception {
      try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL + BASE_DATO, USER, PWD);
            System.out.println("Me conecté Exitosamente !!");
        } catch (Exception e) {
            System.out.println("Error en la Conexión");
            throw e;}
    }
    
    public void desconectar() throws SQLException {
        if (con != null){
            if (!con.isClosed()){con.close(); System.out.println("Conexión Cerrada Exitosamente !!");}
        }
    }
}