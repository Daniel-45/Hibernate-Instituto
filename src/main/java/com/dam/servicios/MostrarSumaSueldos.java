package com.dam.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dam.Service;
import com.dam.repositorios.EntityManagerFactorySingleton;

public class MostrarSumaSueldos implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		System.out.println("\n------------------ SUMA TOTAL DE SUELDOS DE EMPLEADOS --------------------");

		EntityManager em = EntityManagerFactorySingleton.getInstance("instituto").getEmf().createEntityManager();

		Query query = em.createQuery("SELECT SUM(e.sueldo) FROM Empleado e");

		System.out.println();

		Number totalSueldos = (Number) query.getSingleResult();

		System.out.println("\nLa suma total de los sueldos de los empleados es " + totalSueldos + " Euros");

		System.out.println("\n--------------- FINAL SUMA TOTAL DE SUELDOS DE EMPLEADOS -----------------");

	}

}
