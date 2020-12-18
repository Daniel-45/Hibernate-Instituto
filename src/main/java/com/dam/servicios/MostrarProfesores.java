package com.dam.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dam.Service;
import com.dam.modelos.Empleado;
import com.dam.repositorios.EntityManagerFactorySingleton;

public class MostrarProfesores implements Service {

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		// TODO Auto-generated method stub

		EntityManager em = EntityManagerFactorySingleton.getInstance("instituto").getEmf().createEntityManager();

		System.out.println("\n-------------------------- EMPLEADOS POR TIPO ----------------------------");

		Query query = em.createQuery("SELECT e FROM Empleado e  WHERE TYPE(e) = Profesor");

		List<Empleado> empleados = query.getResultList();

		empleados.stream().forEach(e -> e.mostrarDatos());

		System.out.println("\n----------------------- FINAL EMPLEADOS POR TIPO -------------------------");

	}

}
