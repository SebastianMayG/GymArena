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
                input.nextLine();
                
                switch(opcion)
                {
                    case 1 -> { 
                        System.out.println("--- Lista de clientes ---");
                        var clientes = clienteDao.ListarClientes();
                        clientes.forEach(System.out::println);
                    }
                        
                    case 2 -> {
                        System.out.print("Digite el ID del cliente: ");
                        int id = input.nextInt();
                        input.nextLine();
                        Cliente cliente = new Cliente(id);
                        Boolean encontrado = clienteDao.buscarClientePorId(cliente);
                        
                        if(encontrado)
                            System.out.println("Cliente encontrado: " + cliente);
                        else
                            System.out.println("No se encontro cliente con el ID: " + cliente.getId());
                    }
                        
                    case 3 -> {
                        System.out.println("--- Agregar nuevo cliente ---");
                        
                        System.out.print("Nombre: ");
                        String nombre = input.nextLine();
                        
                        System.out.print("Apellido: ");
                        String apellido = input.nextLine();

                        System.out.print("Membresia: ");
                        int membresia = input.nextInt();
                        input.nextLine();
                        
                        Cliente nuevoCliente = new Cliente(nombre, apellido, membresia);
                        boolean agregado = clienteDao.agregarCliente(nuevoCliente);

                        if (agregado)
                            System.out.println("Cliente agregado: " + nuevoCliente);
                        else
                            System.out.println("Error al agregar el nuevo cliente: " + nuevoCliente);
                    }
 
                    case 4 -> {
                        System.out.println("--- Modificar cliente ---");
                        System.out.print("ID: ");
                        int id = input.nextInt();
                        input.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = input.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = input.nextLine();
                        System.out.print("Membresia: ");
                        int membresia = input.nextInt();
                        input.nextLine();
                        
                        Cliente cliente = new Cliente(id, nombre, apellido, membresia);
                        boolean modificado = clienteDao.modificarCliente(cliente);
                        if(modificado)
                            System.out.println("Cliente modificado: " + cliente);
                        else
                            System.out.println("Error al modificar el cliente: " + cliente);
                    }

                    case 5 -> {
                        System.out.println("--- Eliminar cliente ---");
                        System.out.print("ID del cliente: ");
                        int id = input.nextInt();
                        input.nextLine();
                        
                        Cliente clienteEliminar = new Cliente(id);
                        boolean eliminado = clienteDao.eliminarCliente(clienteEliminar);
                        if(eliminado)
                            System.out.println("Cliente: " + clienteEliminar + " eliminado");
                        else
                            System.out.println("Error al eliminar el cliente: " + clienteEliminar);
                    }
                        
                    case 6 -> {
                        System.out.println("Saliendo del programa...");
                    }
                
                    default -> System.out.println("Opcion no valida. Por favor, elija una opcion entre 1 y 6.");
                }
            }catch(Exception e)
            {
                System.out.println("Error al ejecutar las opciones: " + e.getMessage());
                input.nextLine();
            }
        }while(opcion != 6);
        
        input.close();
    }
}
