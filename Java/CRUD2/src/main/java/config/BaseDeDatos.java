package config;

import base.SysOut;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {
    public String driver = "com.mysql.cj.jdbc.Driver";
    
    public BaseDeDatos(){
        try{
            Class.forName(driver);            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public Connection getConection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comision1109", "carlos", "prueba");
        } catch(SQLException e){
            SysOut.dbgprintln(e.toString(), 0);
        }
        return con;
    }
    
    public boolean exInsUpdDel(String stmt){
        int filasAfectadas = 0;
        Connection con = this.getConection();
        if (con != null) {
            SysOut.dbgprintln("Conexión Exitosa...", 6);
            try {
                Statement st = con.createStatement();
                SysOut.dbgprintln("Objeto Statement Creado... - " + stmt, 6);
                filasAfectadas = st.executeUpdate(stmt);
                SysOut.dbgprintln("Statement Ejecutado... - filasAfectadas: " + filasAfectadas, 6);
                st.close();
                SysOut.dbgprintln("Statement Cerrado...", 6);
                con.close();
                SysOut.dbgprintln("Conexión Cerrada...", 6);
                return (filasAfectadas == 1);
            } catch(SQLException e){SysOut.dbgprintln(e.toString(), 0);}

            try {
                con.close();
                SysOut.dbgprintln("Conexión Cerrada...", 6);
            } catch(SQLException e){System.out.println(e.toString());}
        }
        SysOut.dbgprintln("Falló algo...", 6);
        return false;
    }
    
    public ResultSet exSel(String stmt){
        Connection con = this.getConection();
        if (con != null) {
            SysOut.dbgprintln("Conexión Exitosa...", 6);
            try {
                PreparedStatement ps = con.prepareStatement(stmt);
                SysOut.dbgprintln("Objeto Select Preparado...", 6);
                ResultSet rs = ps.executeQuery();
                SysOut.dbgprintln("Select Ejecutado...", 6);
            //    ps.close();
                SysOut.dbgprintln("Statement Cerrado...", 6);
               // con.close();
                SysOut.dbgprintln("Conexión Cerrada...", 6);
                return rs;
            } catch(SQLException e){SysOut.dbgprintln(e.toString(), 0);}

            try {
                con.close();
                SysOut.dbgprintln("Conexión Cerrada...", 6);
            } catch(SQLException e){SysOut.dbgprintln(e.toString(), 0);}
        }
        SysOut.dbgprintln("Falló algo...", 6);
        return null;
    }

    public ResultSet exSelectFirst(String stmt){
        ResultSet rs = exSel(stmt);
        if (rs != null) {
            try {
                return ((rs.next()) ? rs : null);
            } catch (SQLException ex) {
                return null;
    //            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
/*    public static void main(String[] args) throws SQLException {
        BaseDeDatos con = new BaseDeDatos();

        Connection conexion;
        conexion = con.getConection();
        
        PreparedStatement ps;
        ResultSet rs;

        ps = conexion.prepareStatement("SELECT * FROM docentes");
        rs = ps.executeQuery();
        
        while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                
                System.out.println("\nId: " + id + "\nNombre: " + nombre  + "\nApellido: " + apellido  + "\nEdad: " + edad);
            }
        System.out.println("Hola2");
    }
*/
}
