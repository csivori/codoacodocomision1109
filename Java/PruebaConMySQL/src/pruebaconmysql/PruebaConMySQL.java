package pruebaconmysql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
//import jave.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PruebaConMySQL {

    public static void main(String[] args) {
        // TODO code application logic here
        String usr = "root";
        String pwd = "";
        String url = "jdbc:mysql://localhost:3306/comision1109";
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaConMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url, usr, pwd);
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT into docentes VALUES(null, 'Emiliano', 'TUKY', 35, null, 'CABA')");
            rs = stmt.executeQuery("SELECT * from docentes");
            rs.next();
            do{
                System.out.println(rs.getString("id") + "," + rs.getString("nombre") + "," + rs.getString("apellido") + "," + rs.getString("edad") + "," + rs.getString("fecha") + "," + rs.getString("provincia"));
            }while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(PruebaConMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
