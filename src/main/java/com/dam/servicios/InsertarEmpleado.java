package com.dam.servicios;

import java.util.HashSet;
import java.util.Set;

import com.dam.Service;
import com.dam.modelos.Administrativo;
import com.dam.modelos.Auxiliar;
import com.dam.modelos.Empleado;
import com.dam.modelos.Profesor;
import com.dam.repositorios.GenericJPADAO;
import com.dam.repositorios.Libreria;

import daw.com.Teclado;

public class InsertarEmpleado implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		System.out.println("\n--------------------------- INSERTAR EMPLEADOS ---------------------------");

		int tipo;
		Empleado e;
		String seguir = "";
		Set<Empleado> empleados = new HashSet<Empleado>();

		GenericJPADAO<Empleado, String> daoEmpleado = new GenericJPADAO<Empleado, String>(Empleado.class);

		do {

			System.out.println("\n1.Auxiliar");
			System.out.println("\n2.Profesor");
			System.out.println("\n3.Administrativo");
			tipo = Libreria.leerEntre(1, 3, "\nSelecciona el tipo de empleado:");

			if (tipo == 1) {
				e = new Auxiliar();
			} else if (tipo == 2) {
				e = new Profesor();
			} else {
				e = new Administrativo();
			}

			// Lee los datos de un empleado (auxiliar, profesor o administrativo)
			e.leerDatos(); // polimorfismo

			empleados.add(e);

			seguir = Teclado.leerString("\n¿Quieres seguir insertando empleados? S/N:");

			if (!seguir.equalsIgnoreCase("S") && !seguir.equalsIgnoreCase("N")) {
				System.out.println("\nERROR!! Respuesta no valida");
				System.out.println("\nPor favor introduce S/N");
				seguir = Teclado.leerString("\n¿Quieres seguir insertando empleados? S/N:");
			}

			System.out.println();

			daoEmpleado.save(e);

		} while (seguir.equalsIgnoreCase("S"));

		System.out.println("\n------------------------ FINAL INSERTAR EMPLEADOS ------------------------\n");

	}

}
