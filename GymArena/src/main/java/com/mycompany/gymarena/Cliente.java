package com.mycompany.gymarena;

public class Cliente 
{
    private int id, membresia;
    private String nombre, apellido;
    
    public Cliente()
    {
        
    }
    
    public Cliente(int id)
    {
        this.id = id;
    }
    
    public Cliente(String nombre, String apellido, int membresia)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }
    
    public Cliente(int id, String nombre, String apellido, int membresia)
    {
        this(nombre, apellido, membresia);
        this.id = id;
    }
}
