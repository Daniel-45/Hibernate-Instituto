package com.dam.servicios;

import java.util.List;

import com.dam.Service;
import com.dam.modelos.Empleado;
import com.dam.repositorios.GenericJPADAO;

public class MostrarEmpleados implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		System.out.println("\n---------------------- MOSTRAR TODOS LOS EMPLEADOS -----------------------");

		GenericJPADAO<Empleado, String> daoEmpleado = new GenericJPADAO<Empleado, String>(Empleado.class);

		List<Empleado> lista = (List<Empleado>) daoEmpleado.findAll();

		for (Empleado e : lista) {

			e.mostrarDatos();
		}

		System.out.println("\n------------------- FINAL MOSTRAR TODOS LOS EMPLEADOS --------------------");

	}

}
