package com.mycompany.gymarena;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
    public static Connection getConexion()
    {
        Connection conexion = null;
        String baseDatos = "gymarena";
        String url = "jdbc:mysql://localhost:3306/" + baseDatos;
        String usuario = "root";
        String password = "root";
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch(Exception e)
        {
            System.out.println("Error al conectarse a la base de datos " + e.getMessage());
        }
        
        return conexion;
    }
    
    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        
        if(conexion != null)
            System.out.println("Conexion exitosa: " + conexion);
        else
          System.out.println("Error al conectarse");
    }
}
