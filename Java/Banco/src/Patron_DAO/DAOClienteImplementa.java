package Patron_DAO;

import Interfaces.DAOCliente;
import banco.Cliente;
import java.util.List;
import java.sql.*;

public class DAOClienteImplementa extends Conexion implements DAOCliente {

    @Override
    public void registrarCliente(Cliente cli) {
        try{
            conectar();
            String sql = "INSERT INTO cuentas (nombre) VALUES(?)";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, cli.getNombre());
            pStmt.execute();
            desconectar();            
        }catch(Exception e) {
            System.out.println("error al insertar la cuenta");
        }
    }

    @Override
    public void eliminarCliente(Cliente cli) {
        try{
            conectar();
            String sql = "DELETE cuentas WHERE nro_cuenta = ?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, cli.getNombre());
            pStmt.execute();
            desconectar();            
        }catch(Exception e) {
            System.out.println("error al insertar la cuenta");
        }
    }

    @Override
    public List<Cliente> listarClientes() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
}
