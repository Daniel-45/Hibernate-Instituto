package com.dam.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dam.Service;
import com.dam.modelos.Empleado;
import com.dam.repositorios.EntityManagerFactorySingleton;

public class MostrarEmpleadosEdad implements Service {

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		// TODO Auto-generated method stub

		EntityManager em = EntityManagerFactorySingleton.getInstance("instituto").getEmf().createEntityManager();

		System.out.println("\n-------------------------- TODOS LOS EMPLEADOS ---------------------------\n");

		Query query = em.createQuery("SELECT e FROM Empleado e ORDER BY e.edad");

		List<Empleado> empleados = query.getResultList();

		empleados.stream().forEach(e -> e.mostrarDatos());

		System.out.println("\n----------------------- FINAL TODOS LOS EMPLEADOS ------------------------\n");
	}

}
