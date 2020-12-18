package com.dam.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import daw.com.Teclado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 
 * @author Daniel
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "EMPLEADOS_INSTITUTOS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DIS", discriminatorType = DiscriminatorType.STRING)
public abstract class Empleado implements Serializable {

	// Atributos
	@Id
	@Column(length = 9)
	@EqualsAndHashCode.Include
	private String dni;

	@Column(length = 20)
	private String nombre;

	private int edad;

	private float sueldo;

	private static final long serialVersionUID = 1L;

	// Métodos

	// Leer datos
	public void leerDatos() {
		dni = Teclado.leerString("\nIntroduce el DNI:");

		nombre = Teclado.leerString("\nIntroduce el nombre:");

		do {

			edad = Teclado.leerInt("\nIntroduce la edad:");
			if (edad < 18) {
				System.out.println("\nLa edad del empleado no puede ser inferior a 18 años");
			}

		} while (edad < 18);

		do {

			sueldo = Teclado.leerFloat("\nIntroduce el sueldo:");

			if (sueldo < 0) {
				System.out.println("\nERROR!! El sueldo no puede ser negativo");
			}

		} while (sueldo < 0);
	}

	// Mostrar datos
	public void mostrarDatos() {
		System.out.println("\n-------------------------------- EMPLEADO --------------------------------");
		System.out.println("\nDNI: " + dni);
		System.out.println("\nNombre: " + nombre);
		System.out.println("\nEdad: " + edad + " años");
		System.out.println("\nSueldo: " + sueldo + " Euros");
	}

	// Calcula sueldo
	public abstract float calculaSueldo();
}
