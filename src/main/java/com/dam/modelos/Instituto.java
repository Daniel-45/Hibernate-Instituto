package com.dam.modelos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dam.repositorios.Libreria;

import daw.com.Teclado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * 
 * @author Daniel
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "INSTITUTOS")
public class Instituto implements Serializable {

	// Atributos
	@Id
	@Column(length = 30)
	@EqualsAndHashCode.Include
	private String nombre;

	@Singular
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// Evitar tabla intermedia Instituto - Empleado
	@JoinColumn(name = "FK_INSTITUTO")
	private Set<Empleado> empleados;

	@Embedded
	@Builder.Default
	private Direccion direccion = new Direccion();
	private static final long serialVersionUID = 1L;

	// Métodos

	// Leer datos
	public void leerDatos() {

		nombre = Teclado.leerString("\nIntroduce el nombre del instituto:");

		direccion.leerDatos();

		int tipo;
		String seguir;
		Empleado e;

		System.out.println("\n--------------------------- INSERTAR EMPLEADOS ---------------------------");

		empleados = new HashSet<Empleado>();

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

		} while (seguir.equalsIgnoreCase("S"));

		System.out.println("\n------------------------ FINAL INSERTAR EMPLEADOS ------------------------\n");

	}

	// Mostrar datos
	public void mostrarDatos() {

		System.out.println("\n--------------------------- MOSTRAR DATOS INSTITUTO ----------------------");

		System.out.println("\nNombre del Instituto: " + nombre);

		direccion.mostrarDatos();

		System.out.println("\n----------------------------- MOSTRAR EMPLEADOS --------------------------");

		for (Empleado e : empleados) {

			e.mostrarDatos();

		}

		System.out.println("------------------------ FINAL MOSTRAR EMPLEADOS -------------------------");

		System.out.println("\n------------------------ FINAL MOSTRAR DATOS INSTITUTO -------------------");
	}

}
