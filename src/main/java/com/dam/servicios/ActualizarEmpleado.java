package com.dam.servicios;

import com.dam.Service;
import com.dam.modelos.Administrativo;
import com.dam.modelos.Auxiliar;
import com.dam.modelos.Empleado;
import com.dam.modelos.Profesor;
import com.dam.repositorios.GenericJPADAO;

import daw.com.Teclado;

public class ActualizarEmpleado implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		System.out.println("\n-------------------------- ACTUALIZAR EMPLEADOS --------------------------");

		GenericJPADAO<Empleado, String> daoEmpleado = new GenericJPADAO<Empleado, String>(Empleado.class);

		Empleado e = daoEmpleado.findById(Teclado.leerString("\nIntroduce el DNI del empleado a actualizar:")).get();

		e.mostrarDatos();

		System.out.println("\nIntroduce los nuevos datos del empleado:");

		e.setNombre(Teclado.leerString("\nIntroduce el nuevo nombre:"));

		e.setEdad(Teclado.leerInt("\nIntroduce la nueva edad:"));

		e.setSueldo(Teclado.leerFloat("\nIntroduce el nuevo sueldo:"));

		if (e instanceof Auxiliar) {

			((Auxiliar) e).setIdiomas(Teclado.leerInt("\n¿Cuántos idiomas habla el auxiliar?:"));
			
			System.out.println();
			
		} else if (e instanceof Profesor) {

			((Profesor) e).setPublicaciones(Teclado.leerInt("\n¿Cuántas publicaciones tiene el profesor?:"));
			
			System.out.println();
			
		} else if (e instanceof Administrativo) {
			((Administrativo) e)
					.setAniosExperiencia(Teclado.leerInt("\n¿Cuántos años de experiencia tiene el administrativo?:"));
			
			System.out.println();
		}

		daoEmpleado.update(e);

		System.out.println("\n----------------------- FINAL ACTUALIZAR EMPLEADOS -----------------------");

	}

}
