package com.mycompany.gymarena;

import com.mycompany.gymarena.datos.ClienteDAO;
import com.mycompany.gymarena.datos.IClienteDAO;
import com.mycompany.gymarena.dominio.Cliente;
import java.util.Scanner;

public class GymArena 
{
    public static void main(String[] args) 
    {
        GymArenaApp();
    }

    private static void GymArenaApp() 
    {
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        
        IClienteDAO clienteDao = new ClienteDAO();
        
        do
        {
            try
            {
                System.out.print("""
                        --- Bienvenido a GymArena ---
                                 
                        1.- Mostrar lista
                        2.- Buscar cliente
                        3.- Agregar usuario
                        4.- Modificar usuario
                        5.- Eliminar usuario
                        6 .- Salir
                                 
                        Ejecute una opcion a realizar:  """);
                opcion = input.nextInt();
                
                switch(opcion)
                {
                    case 1: 
                        input.nextLine();
                        System.out.println("--- Lista de clientes ---");
                        var clientes = clienteDao.ListarClientes();
                        clientes.forEach(System.out::println);
                    
                    case 2:
                        input.nextLine();
                        System.out.print("Digite el ID del cliente: ");
                        int id = input.nextInt();
                        Cliente cliente = new Cliente(id);
                        Boolean encontrado = clienteDao.buscarClientePorId(cliente);
                        
                        if(encontrado)
                            System.out.println("Cliente encontrado: " + cliente);
                        else
                            System.out.println("No se encontro cliente con el ID: " + cliente.getId());
                    
                    case 3:
                        input.nextLine();
                        System.out.println("--- Agregar nuevo cliente ---");
                        
                        System.out.print("Nombre: ");
                        String nombre = input.nextLine();
                        
                        System.out.print("Apellido: ");
                        String apellido = input.nextLine();

                        System.out.print("Membresia: ");
                        int membresia = input.nextInt();


                        Cliente nuevoCliente = new Cliente(nombre, apellido, membresia);
                        boolean agregado = clienteDao.agregarCliente(nuevoCliente);

                        if (agregado) {
                            System.out.println("Cliente agregado: " + nuevoCliente);
                        } else {
                            System.out.println("Error al agregar el nuevo cliente: " + nuevoCliente);
                        }
 
                    case 4:
                        input.nextLine();
                        System.out.println("--- Modificar cliente ---");
                        
                        System.out.print("ID: ");
                        id = input.nextInt();
                        
                        System.out.print("Nombre: ");
                        nombre = input.nextLine();
                        
                        System.out.print("Apellido: ");
                        apellido = input.nextLine();

                        System.out.print("Membresia: ");
                        membresia = input.nextInt();


                        cliente = new Cliente(id, nombre, apellido, membresia);
                        
                        boolean modificado = clienteDao.modificarCliente(cliente);
                        
                        if(modificado)
                            System.out.println("Cliente modificado: " + cliente);
                        else
                            System.out.println("Error al modificar el cliente: " + cliente);

                    case 5:
                        input.nextLine();
                        System.out.println("--- Eliminar cliente ---");
                        System.out.print("iD del cliente: ");
                        id = input.nextInt();
                        
                        Cliente clienteEliminar = new Cliente(id);
                        boolean eliminado = clienteDao.eliminarCliente(clienteEliminar);
                        if(eliminado)
                            System.out.println("Cliente: " + clienteEliminar + " eliminado");
                        else
                            System.out.println("Error al eliminar el cliente: " + clienteEliminar);
                }
            }catch(Exception e)
            {
                System.out.println("Error al ejecutar las opciones " + e.getMessage());
            }
        }while(opcion != 6);
    }
}
