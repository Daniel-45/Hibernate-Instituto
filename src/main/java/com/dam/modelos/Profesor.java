package com.dam.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import daw.com.Teclado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "PROFESORES")
public class Profesor extends Empleado implements Serializable {

	// Atributos
	@Column(name = "PUBLICACIONES", nullable = true)
	private int publicaciones;

	@Transient
	private transient static final float PLUS = 300;

	private static final long serialVersionUID = 1L;

	// Métodos

	// Leer datos
	public void leerDatos() {
		super.leerDatos();

		String respuesta = "";

		do {

			respuesta = Teclado.leerString("\n¿El profesor tiene publicaciones? S/N:");

			if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
				System.out.println("\nERROR!! Respuesta no valida");
				System.out.println("\nPor favor introduce S/N");
			}

		} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));

		if (respuesta.equalsIgnoreCase("S")) {
			publicaciones = Teclado.leerInt("\n¿Cuántas publicaciones tiene el profesor?");
		}
	}

	// Mostrar datos
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("\nPublicaciones: " + publicaciones);
		System.out.println("\nSueldo con PLUS: " + calculaSueldo() + " Euros");
		System.out.println("\n------------------------------ FINAL EMPLEADO ----------------------------\n");
	}

	// Calcular sueldo
	@Override
	public float calculaSueldo() {

		float sueldoProfesor = 0;

		if (publicaciones == 0) {

			sueldoProfesor = super.getSueldo();

		} else if (publicaciones > 0) {

			sueldoProfesor = super.getSueldo() + (publicaciones * PLUS);
		}
		return sueldoProfesor;
	}

}
