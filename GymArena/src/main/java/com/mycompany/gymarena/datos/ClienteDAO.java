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
    public boolean agregarCliente(Cliente cliente) 
    {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO clientes(nombre, apellido, membresia) "
                + " VALUES(?, ?, ?)";
        
        try
        {
            ps = con.prepareCall(sql);
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            
            
            return true;
        }catch(Exception e )
        {
            System.out.println("Error al agregar cliente: " + e.getMessage());
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
    public boolean modificarCliente(Cliente cliente) 
    {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "UPDATE clientes SET nombre = ? , apellido = ? , membresia = ? " + 
                "WHERE clienteId = ?";
        try
        {
            ps = con.prepareCall(sql);
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            
            return true;
            
        }catch(Exception e )
        {
            System.out.println("Error al modificar cliente: " + e.getMessage());
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
    public boolean eliminarCliente(Cliente cliente) 
    {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "DELETE FROM clientes WHERE clienteId = ?";
        
        try
        {
            ps = con.prepareCall(sql);
            ps.setInt(1,cliente.getId());
            ps.execute();
            return true;
            
        }catch(Exception e )
        {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
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
    
    public static void main(String[] args) 
    {
        IClienteDAO clienteDao = new ClienteDAO();
 
        /* BUSCAR POR ID
        
        Cliente cliente1 = new Cliente(2);
        Boolean encontrado = clienteDao.buscarClientePorId(cliente1);
        
        if(encontrado)
            System.out.println("Cliente encontrado: " + cliente1);
        else
            System.out.println("No se encontro cliente con el ID: " + cliente1.getId());
        */
        
        //AGREGAR CLIENTE
        /*
        Cliente nuevoCliente = new Cliente("Daniel", "Gil", 300);
        boolean agregado = clienteDao.agregarCliente(nuevoCliente);
        if(agregado)
            System.out.println("Cliente agregado: " + nuevoCliente);
        else
            System.out.println("Error al agregar el nuevo cliente: " + nuevoCliente);
        */
        
        //MODIFICAR CLIENTE
        /*
        Cliente modificarCliente = new Cliente(3, "Coco", "Liso",100);
        boolean modificado = clienteDao.modificarCliente(modificarCliente);
        if(modificado)
            System.out.println("Cliente modificado: " + modificarCliente);
        else
            System.out.println("Error al modificar el cliente: " + modificarCliente);
        */
        
        //ELIMINAR CLIENTE
        Cliente clienteEliminar = new Cliente(1);
        boolean eliminado = clienteDao.eliminarCliente(clienteEliminar);
        if(eliminado)
            System.out.println("Cliente: " + clienteEliminar + " eliminado");
        else
            System.out.println("Error al eliminar el cliente: " + clienteEliminar);
        
        //LISTAR CLIENTES
        
        System.out.println("*** Listar cliente ***");

        var clientes = clienteDao.ListarClientes();
        clientes.forEach(System.out::println);
        
    }
}
