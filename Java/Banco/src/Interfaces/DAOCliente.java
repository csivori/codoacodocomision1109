package Interfaces;

import banco.Cliente;
import java.util.List;

public interface DAOCliente {
    public void registrarCliente(Cliente cli);
    public void eliminarCliente(Cliente cli);
    public List<Cliente> listarClientes();
    
}
