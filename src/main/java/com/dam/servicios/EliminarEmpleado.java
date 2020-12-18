package com.dam.servicios;

import com.dam.Service;
import com.dam.modelos.Empleado;
import com.dam.repositorios.GenericJPADAO;

import daw.com.Teclado;

public class EliminarEmpleado implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		System.out.println("\n--------------------------- ELIMINAR EMPLEADOS ---------------------------");

		GenericJPADAO<Empleado, String> daoEmpleado = new GenericJPADAO<Empleado, String>(Empleado.class);

		Empleado e = daoEmpleado.findById(Teclado.leerString("\nIntroduce el DNI del empleado a eliminar:")).get();

		daoEmpleado.delete(e);

		System.out.println("\n------------------------ FINAL ELIMINAR EMPLEADOS ------------------------");

	}

}
