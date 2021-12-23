package modelo;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private Connection conexion;
    private Exception ultimaExcepcion;

// CONSTRUCTORES
    public AlumnoDAO() {
        Conexion con = new Conexion();
        this.conexion = con.getConection();
        this.ultimaExcepcion = (this.conexion == null) ? con.getUltimaExcepcion() : null;
    }

// GETTERs & SETTERs
    public Exception getUltimaExcepcion() {
        return ultimaExcepcion;
    }

// OVERRIDES
    @Override
    public String toString() {
        //    Codificar !!
        return "AlumnoDAO(conexion: " + conexion + ")";
    }

    public boolean equals(AlumnoDAO objeto) {
        //    Codificar !!
        return this == objeto;
    }

// METODOS PUBLICOS
    public List<Alumno> listarAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM PARTICIPANTES");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                lista.add(new Alumno(id, nombre, apellido, email, telefono));
            }
            return lista;
        } catch (SQLException e) {
            this.ultimaExcepcion = e;
//            System.out.println(e.toString());
        }
        return null;
    }

    public Alumno mostrarAlumno(int _id) {
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
                return new Alumno(id, nombre, apellido, email, telefono);
            } else {
                return null;
            }
        } catch (SQLException e) {
            this.ultimaExcepcion = e;
//            System.out.println(e.toString());
        }
        return null;
    }

    public boolean insertarAlumno(Alumno alumno) {
        return insertarAlumno(alumno.getNombre(), alumno.getApellido(), alumno.getEmail(), alumno.getTelefono());
    }

    public boolean insertarAlumno(String nombre, String apellido, String email, String telefono) {
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO PARTICIPANTES (nombre, apellido, email, telefono) VALUES (?,?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, telefono);
            return (ps.executeUpdate() == 1); // Se asegura que insertó 1 fila, sino retorna false
        } catch (SQLException e) {
            this.ultimaExcepcion = e;
//            System.out.println(e.toString());
        }
        return false;
    }

    public boolean modificarAlumno(int idold, Alumno alumno) {
        return modificarAlumno(idold, alumno.getId(), alumno.getNombre(), alumno.getApellido(), alumno.getEmail(), alumno.getTelefono());
    }

    public boolean modificarAlumno(int idold, int idnew, String nombre, String apellido, String email, String telefono) {
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE PARTICIPANTES SET id=?, nombre=?, apellido=?, email=?, telefono=? WHERE id=?");
            ps.setInt(1, idnew);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, email);
            ps.setString(5, telefono);
            ps.setInt(6, idold);
            return (ps.executeUpdate() == 1); // Se asegura que insertó 1 fila, sino retorna false
        } catch (SQLException e) {
            this.ultimaExcepcion = e;
//            System.out.println(e.toString());
        }
        return false;
    }

    public boolean eliminarAlumno(Alumno alumno) {
        return eliminarAlumno(alumno.getId());
    }

    public boolean eliminarAlumno(int id) {
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM PARTICIPANTES WHERE id = ?");
            ps.setInt(1, id);
            return (ps.executeUpdate() == 1); // Se asegura que insertó 1 fila, sino retorna false
        } catch (SQLException e) {
            this.ultimaExcepcion = e;
//            System.out.println(e.toString());
        }
        return false;
    }

    public boolean validarLogin(String usuario, String clave) {
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? and clave = ?");
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String usr = rs.getString("usuario");
                String pwd = rs.getString("clave");
                return (usuario.equals(usr) && clave.equals(pwd));
            }
        } catch (SQLException e) {
            this.ultimaExcepcion = e;
//            System.out.println(e.toString());
        }
        return false;
    }
    
// METODOS PRIVADOS
}
