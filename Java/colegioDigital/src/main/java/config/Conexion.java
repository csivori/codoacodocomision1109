package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
// ATRIBUTOS PUBLICOS

    public String driver = "com.mysql.cj.jdbc.Driver";

// ATRIBUTOS PRIVADOS
// CONSTRUCTORES
    public Conexion() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// GETTERs & SETTERs
// OVERRIDES
    @Override
    public String toString() {
        return "Conexion: Driver(" + driver + ")";
    }

//    @Override
//    public boolean equals(Conexion objeto){
//        Codificar !!
//        return this == objeto;}
// METODOS PUBLICOS
    public Connection getConection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comision1109", "carlos", "prueba");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return con;
    }

// METODOS PRIVADOS
//    public static void main(String args[]) throws SQLException {
//        Connection con = new Conexion().getConection();
//        PreparedStatement ps = con.prepareStatement("SELECT * from PARTICIPANTES");
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String nombre = rs.getString("nombre");
//            String apellido = rs.getString("apellido");
//            String email = rs.getString("email");
//            String telefono = rs.getString("telefono");
//
//            System.out.println("\nId: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEmail: " + email + "\nTeléfono: " + telefono);
//        }
//
//    }
}
