CREATE DATABASE IF NOT EXISTS empleados_db;

--  Usando la DB
USE empleados_db;

--  Creación de la Tabla Movies
CREATE TABLE IF NOT EXISTS empleados (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    salario DOUBLE NOT NULL,
    fechaInicio DATE NOT NULL
);

--  Insertando datos en la Tabla Movies
INSERT INTO empleados (nombre, apellido, cargo, salario, fechaInicio)
VALUES
('Mario', 'González', 'Director', 80000.0, '1972-03-15'),
('Ana', 'López', 'Productora', 60000.0, '2006-02-28'),
('Carlos', 'Martínez', 'Actor', 40000.0, '2000-01-15'),
('Lucía', 'Fernández', 'Guionista', 55000.0, '2009-09-14'),
('Isabel', 'Ramírez', 'Actriz', 45000.0, '2006-05-20');