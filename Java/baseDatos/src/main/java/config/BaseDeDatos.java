/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {
    public String driver = "com.mysql.jdbc.Driver";
    
    public Connection getConection(){
        Connection con=null;
        try{
            Class.forName(driver);            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comision1109", "carlos", "");
        } catch(SQLException e){
            System.out.println(e.toString());
        } catch(ClassNotFoundException ex){
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void main(String[] args){
        BaseDeDatos con = new BaseDeDatos();

        Connection conexion = null;
        conexion = con.getConection();
        
        PreparedStatement ps;
        ResultSet rs;
        
        ps = conexion.prepareStatement("SELECT * FROM docentes");
        rs = ps.executeQuery();
        
        while(rs.next()) {
            System.out.println("Hola");
        }
    }
        
        System.out.println("Hola");
    }
}
