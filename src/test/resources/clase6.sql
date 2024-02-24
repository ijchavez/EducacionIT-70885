-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS mydb;

CREATE TABLE IF NOT EXISTS Personas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT,
    email VARCHAR(100),
    telefono VARCHAR(15)
);
use mydb;
-- Insertar algunos datos de ejemplo
INSERT INTO Personas (nombre, apellido, edad, email, telefono) VALUES
    ('Juan', 'Pérez', 25, 'juan.perez@email.com', '123-456-7890'),
    ('María', 'Gómez', 30, 'maria.gomez@email.com', '987-654-3210'),
    ('Carlos', 'Rodríguez', 22, 'carlos.rodriguez@email.com', '456-789-0123'),
    ('Ana', 'López', 28, 'ana.lopez@email.com', '111-222-3333'),
    ('Pedro', 'Martínez', 35, 'pedro.martinez@email.com', '444-555-6666'),
    ('Laura', 'Fernández', 29, 'laura.fernandez@email.com', '777-888-9999'),
    ('Roberto', 'Hernández', 32, 'roberto.hernandez@email.com', '101-202-3030'),
    ('Isabel', 'Sánchez', 27, 'isabel.sanchez@email.com', '404-505-6060'),
    ('Miguel', 'Gutiérrez', 31, 'miguel.gutierrez@email.com', '707-808-9090'),
    ('Carmen', 'Díaz', 26, 'carmen.diaz@email.com', '111-222-3333'),
    ('Francisco', 'Torres', 33, 'francisco.torres@email.com', '444-555-6666'),
    ('Sofía', 'Ramírez', 30, 'sofia.ramirez@email.com', '777-888-9999'),
    ('Javier', 'Vargas', 29, 'javier.vargas@email.com', '101-202-3030'),
    ('Elena', 'Moreno', 34, 'elena.moreno@email.com', '404-505-6060'),
    ('Alejandro', 'Castro', 28, 'alejandro.castro@email.com', '707-808-9090'),
    ('Natalia', 'Ruiz', 25, 'natalia.ruiz@email.com', '111-222-3333'),
    ('Hugo', 'Ortega', 32, 'hugo.ortega@email.com', '444-555-6666'),
    ('Adriana', 'Luna', 27, 'adriana.luna@email.com', '777-888-9999'),
    ('Diego', 'Fuentes', 29, 'diego.fuentes@email.com', '101-202-3030'),
    ('Valentina', 'Soto', 31, 'valentina.soto@email.com', '404-505-6060'),
    ('Fernando', 'Jiménez', 26, 'fernando.jimenez@email.com', '707-808-9090'),
    ('Carolina', 'García', 33, 'carolina.garcia@email.com', '111-222-3333'),
    ('Raúl', 'Mendoza', 30, 'raul.mendoza@email.com', '444-555-6666');