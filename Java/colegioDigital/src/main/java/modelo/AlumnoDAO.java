package modelo;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    Connection conexion;
    
// CONSTRUCTORES
    public AlumnoDAO(){
        Conexion con = new Conexion();
        this.conexion = con.getConection();
    }
    
// GETTERs & SETTERs

// OVERRIDES
@Override
    public String toString(){
    //    Codificar !!
        return "AlumnoDAO(conexion: " + conexion + ")";
    }

    public boolean equals(AlumnoDAO objeto){
    //    Codificar !!
        return this == objeto;}

// METODOS PUBLICOS
    public List<Alumno> listarAlumnos(){
        List<Alumno> lista = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM PARTICIPANTES");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                lista.add(new Alumno(id, nombre, apellido, email, telefono));
            }
            return lista;
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return null;
    }
    
    public Alumno listarAlumno(int _id){
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM PARTICIPANTES WHERE id = ?");
            ps.setInt(1, _id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                return new Alumno(id, nombre, apellido, email, telefono);}
            else {return null;}
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return null;
    }
    
    public boolean ingresarAlumno(Alumno alumno){return ingresarAlumno(alumno.getNombre(), alumno.getApellido(), alumno.getEmail(), alumno.getTelefono());}
    public boolean ingresarAlumno(String nombre, String apellido, String email, String telefono){
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO PARTICIPANTES (nombre, apellido, email, telefono) VALUES (?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, telefono);
            return ps.execute();
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return false;
    }
    
    public boolean modificarAlumno(Alumno alumno){return modificarAlumno(alumno.getId(), alumno.getNombre(), alumno.getApellido(), alumno.getEmail(), alumno.getTelefono());}
    public boolean modificarAlumno(int id, String nombre, String apellido, String email, String telefono){
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE PARTICIPANTES SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id = ?");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, telefono);
            ps.setInt(5, id);
            return ps.execute();
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return false;
    }
    
    public boolean eliminarAlumno(Alumno alumno){return eliminarAlumno(alumno.getId());}
    public boolean eliminarAlumno(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM PARTICIPANTES WHERE id = ?");
            ps.setInt(1, id);
            return ps.execute();
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return false;
    }

// METODOS PRIVADOS

}
