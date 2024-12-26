package org.example.controllers;

import org.example.entities.Empleado;
import org.example.persistence.EmpleadoDAO;

import java.util.List;

public class EmpleadoController {

    private EmpleadoDAO empleadoDAO;

    public EmpleadoController() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    // Agregar un nuevo empleado
    public void agregarEmpleado(String nombre, String apellido, String cargo, double salario, java.util.Date fechaInicio) {
        Empleado empleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio);
        empleadoDAO.agregarEmpleado(empleado);
        System.out.println("Empleado agregado: " + nombre);
    }

    // Listar empleados
    public void listarEmpleados() {
        List<Empleado> empleados = empleadoDAO.listarEmpleados();
        System.out.println("Listado de empleados:");
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " " + emp.getApellido());
        }
    }

    // Actualizar un empleado
    public void actualizarEmpleado(Long id, String nombre, String apellido, String cargo, double salario, java.util.Date fechaInicio) {
        Empleado empleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio);
        empleado.setId(id);
        empleadoDAO.actualizarEmpleado(empleado);
        System.out.println("Empleado actualizado: " + nombre);
    }

    // Buscar empleados por cargo
    public void buscarEmpleadosPorCargo(String cargo) {
        List<Empleado> empleados = empleadoDAO.buscarEmpleadosPorCargo(cargo);
        System.out.println("Empleados con cargo " + cargo + ":");
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " " + emp.getApellido());
        }
    }

    // Eliminar un empleado
    public void eliminarEmpleado(Long id) {
        empleadoDAO.eliminarEmpleado(id);
        System.out.println("Empleado eliminado con ID: " + id);
    }

    // Cerrar conexiones
    public void close() {
        empleadoDAO.close();
    }
}
