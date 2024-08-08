package com.mycompany.gymarena.datos;

import com.mycompany.gymarena.dominio.Cliente;
import java.util.List;

public interface IClienteDAO 
{
    List<Cliente> ListarClientes();
    
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
    
}
