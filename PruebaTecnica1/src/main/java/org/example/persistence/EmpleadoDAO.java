package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entities.Empleado;
import java.util.List;

public class EmpleadoDAO {

    private final EntityManager entityManager;

    public EmpleadoDAO() {
        this.entityManager = ConfigJPA.getEntityManager();
    }

    // Agregar un nuevo empleado
    public void agregarEmpleado(Empleado empleado) {
        try {
            entityManager.getTransaction().begin();
            //Se guarda el objeto Empleado en la base de datos. El metodo persist() se encarga de insertar el objeto en la tabla de la base de datos.
            entityManager.persist(empleado);
            entityManager.getTransaction().commit();
            //Si ocurre una excepción durante el proceso de persistencia, la transacción se revierte mediante rollback().
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            //se lanza una RuntimeException con el mensaje Error
            throw new RuntimeException("Error al agregar el empleado", e);
        }
    }

    // Listar todos los empleados
    public List<Empleado> listarEmpleados() {
        //Aquí, se crea una consulta utilizando JPQL la consulta "FROM empleados" intenta seleccionar todos los registros de la tabla empleados
        TypedQuery<Empleado> query = entityManager.createQuery(" FROM empleados ", Empleado.class);
        return query.getResultList();
    }

    // Actualizar un empleado
    public void actualizarEmpleado(Empleado empleado) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(empleado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Error al actualizar el empleado", e);
        }
    }

    // Eliminar un empleado
    public void eliminarEmpleado(Long id) {
        try {
            entityManager.getTransaction().begin();
            Empleado empleado = entityManager.find(Empleado.class, id);
            if (empleado != null) {
                entityManager.remove(empleado);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Error al eliminar el empleado", e);
        }
    }

    // Buscar empleados por cargo
    public List<Empleado> buscarEmpleadosPorCargo(String cargo) {
        TypedQuery<Empleado> query = entityManager.createQuery("FROM empleados e WHERE e.cargo = :cargo", Empleado.class);
        query.setParameter("cargo", cargo);
        return query.getResultList();
    }

    // Cerrar el EntityManager
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
