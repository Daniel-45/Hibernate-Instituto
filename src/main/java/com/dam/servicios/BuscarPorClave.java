package com.dam.servicios;

import com.dam.Service;
import com.dam.modelos.Empleado;
import com.dam.repositorios.GenericJPADAO;

import daw.com.Teclado;

public class BuscarPorClave implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		System.out.println("\n-------------------------- EMPLEADOS POR CLAVE ---------------------------");

		GenericJPADAO<Empleado, String> daoEmpleado = new GenericJPADAO<Empleado, String>(Empleado.class);

		Empleado e = daoEmpleado.findById(Teclado.leerString("\nIntroduce el DNI del empleado a buscar:")).get();

		e.mostrarDatos();

		System.out.println("\n----------------------- FINAL EMPLEADOS POR CLAVE ------------------------");
	}

}
