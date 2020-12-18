package com.dam.servicios;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dam.Service;
import com.dam.modelos.Empleado;
import com.dam.repositorios.EntityManagerFactorySingleton;

public class MostrarSueldoInferior implements Service {

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		// TODO Auto-generated method stub

		System.out.println("\n--------------- EMPLEADOS CON SUELDO INFERIOR 1000 EUROS -----------------");

		EntityManager em = EntityManagerFactorySingleton.getInstance("instituto").getEmf().createEntityManager();

		Query query = em.createQuery("SELECT e FROM Empleado e");

		Stream<Empleado> stream = query.getResultStream();

		stream.filter(e -> e.getSueldo() < 1000).forEach(e -> e.mostrarDatos());

		System.out.println("\n------------ FINAL EMPLEADOS CON SUELDO INFERIOR 1000 EUROS --------------");
	}

}
