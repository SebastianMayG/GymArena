package com.mycompany.gymarena.datos;

import com.mycompany.gymarena.conexion.Conexion;
import com.mycompany.gymarena.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO
{

    @Override
    public List<Cliente> ListarClientes() 
    {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM Clientes ORDER BY clienteId";
        
        try
        {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("clienteId"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                
                clientes.add(cliente);
            }
        }catch(Exception e)
        {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        finally
        {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) 
    {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM Clientes WHERE clienteId = ?";
        
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                
                return true;
            }
        }catch(Exception e)
        {
            System.out.println("Error al recuperar cliente por id: ");
        }
        finally
        {
            try
            {
                con.close();
            }catch(Exception e)
            {
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false; 
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static void main(String[] args) 
    {
        IClienteDAO clienteDao = new ClienteDAO();
        
        /*System.out.println("*** Listar cliente ***");
        
        
        var clientes = clienteDao.ListarClientes();
        clientes.forEach(System.out::println);
        */
        
        Cliente cliente1 = new Cliente(2);
        Boolean encontrado = clienteDao.buscarClientePorId(cliente1);
        
        if(encontrado)
            System.out.println("Cliente encontrado: " + cliente1);
        else
            System.out.println("No se encontro cliente con el ID: " + cliente1.getId());
    }
}
