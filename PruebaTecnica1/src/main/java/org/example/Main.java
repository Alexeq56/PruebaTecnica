package org.example;

import org.example.controllers.EmpleadoController;

import java.util.Date;


public class Main {

    public static void main(String[] args) {
        EmpleadoController empleadoController = new EmpleadoController();

        // Agregar un nuevo empleado
        empleadoController.agregarEmpleado("Juan", "Pérez", "Desarrollador", 3000.00, new Date());

        // Listar empleados
        empleadoController.listarEmpleados();

        // Actualizar un empleado
        empleadoController.actualizarEmpleado(1L, "Juan", "Pérez", "Desarrollador Senior", 3500.00, new Date());

        // Buscar empleados por cargo
        empleadoController.buscarEmpleadosPorCargo("Desarrollador");

        // Eliminar un empleado
        empleadoController.eliminarEmpleado(1L);

        // Cerrar conexiones
        empleadoController.close();
    }
}