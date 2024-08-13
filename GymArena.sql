-- CRUD CREATE - (INSERT) READ - (SELECT) UPDATE - (UPDATE) DELETE - (DELETE)

DROP DATABASE IF EXISTS GymArena;
CREATE DATABASE GymArena;

USE GymArena;

CREATE TABLE Clientes(
	clienteId INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    membresia INT NULL,
    
    CONSTRAINT Clientes_clienteId_pk PRIMARY KEY (clienteId)
);

INSERT INTO Clientes (nombre, apellido, membresia) VALUES
('Juan', 'Perez', 200),
('Ana', 'Gomez', 200),
('Carlos', 'Ramirez', 200);

SELECT * FROM Clientes;