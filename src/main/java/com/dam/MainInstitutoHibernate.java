package com.dam;

import javax.persistence.EntityManager;

import com.dam.modelos.Administrativo;
import com.dam.modelos.Auxiliar;
import com.dam.modelos.Direccion;
import com.dam.modelos.Instituto;
import com.dam.modelos.Profesor;
import com.dam.repositorios.EntityManagerFactorySingleton;
import com.dam.servicios.ActualizarEmpleado;
import com.dam.servicios.BuscarPorClave;
import com.dam.servicios.EliminarEmpleado;
import com.dam.servicios.GenerarJSON;
import com.dam.servicios.InsertarEmpleado;
import com.dam.servicios.MostrarEmpleados;
import com.dam.servicios.MostrarEmpleadosEdad;
import com.dam.servicios.MostrarProfesores;
import com.dam.servicios.MostrarSumaSueldos;

public class MainInstitutoHibernate extends AppMenu {

	// Atributos
	private static EntityManager em;
	final MenuItem SALIR = new MenuItem("Salir de la aplicación", 0, () -> {});

	// Constructor
	public MainInstitutoHibernate() {
		super();
		addOpcion(new MenuItem("Insertar empleado", 1, new InsertarEmpleado()));
		addOpcion(new MenuItem("Eliminar empleado", 2, new EliminarEmpleado()));
		addOpcion(new MenuItem("Actualizar empleado", 3, new ActualizarEmpleado()));
		addOpcion(new MenuItem("Buscar empleado por clave", 4, new BuscarPorClave()));
		addOpcion(new MenuItem("Mostrar profesores del instituto", 5, new MostrarProfesores()));
		addOpcion(new MenuItem("Generar fichero JSON del instituto", 6, new GenerarJSON()));
		addOpcion(new MenuItem("Mostrar todos los empleados del instituto", 7, new MostrarEmpleados()));
		addOpcion(new MenuItem("Mostrar empleados instituto ordenados por edad", 8, new MostrarEmpleadosEdad()));
		addOpcion(new MenuItem("Mostrar suma total de sueldos de los empleados", 9, new MostrarSumaSueldos()));

		addOpcion(SALIR);
	}

	// Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainInstitutoHibernate app = new MainInstitutoHibernate();

		Instituto instituto = cargaDatos();

		em = EntityManagerFactorySingleton.getInstance("instituto").getEmf().createEntityManager();

		em.getTransaction().begin();
		em.persist(instituto);
		em.getTransaction().commit();

		em.clear();

		instituto.mostrarDatos();

		app.run();
	}

	// Métodos

	// Cargar datos
	public static Instituto cargaDatos() {

		// Dirección
		Direccion direccion = Direccion.builder().id(1).calle("C/ Villablanca").numero(89).poblacion("Madrid")
				.localidad("Vicalvaro").build();

		// Auxiliares
		Auxiliar auxiliar1 = Auxiliar.builder().dni("53258765V").nombre("Oscar").edad(18).sueldo(900).idiomas(0)
				.build();

		Auxiliar auxiliar2 = Auxiliar.builder().dni("53983128N").nombre("Ana").edad(23).sueldo(1000).idiomas(2).build();

		// Profesores
		Profesor profesor1 = Profesor.builder().dni("52819576M").nombre("Miguel").edad(60).sueldo(1500).publicaciones(2)
				.build();

		Profesor profesor2 = Profesor.builder().dni("52683159P").nombre("Pedro").edad(54).sueldo(1700).publicaciones(1)
				.build();

		// Administrativos
		Administrativo administrativo1 = Administrativo.builder().dni("53443162A").nombre("Emma").edad(37).sueldo(1200)
				.aniosExperiencia(7).build();

		Administrativo administrativo2 = Administrativo.builder().dni("53852462C").nombre("Carmen").edad(35)
				.sueldo(1200).aniosExperiencia(2).build();

		// Instituto
		Instituto instituto = Instituto.builder().nombre("IES VILLABLANCA").direccion(direccion).empleado(auxiliar1)
				.empleado(auxiliar2).empleado(profesor1).empleado(profesor2).empleado(administrativo1)
				.empleado(administrativo2).build();

		return instituto;
	}

}
