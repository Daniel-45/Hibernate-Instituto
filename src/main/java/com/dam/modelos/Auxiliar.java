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
@DiscriminatorValue(value = "AUXILIARES")
public class Auxiliar extends Empleado implements Serializable {

	// Atributos
	@Column(nullable = true)
	private int idiomas;

	@Transient
	private transient static final float PLUS = 200;

	private static final long serialVersionUID = 1L;

	// Métodos

	// leer datos
	public void leerDatos() {
		super.leerDatos();

		String respuesta = "";

		do {

			respuesta = Teclado.leerString("\n¿El auxiliar tiene idiomas? S/N:");

			if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
				System.out.println("\nERROR!! Respuesta no valida");
				System.out.println("\nPor favor introduce S/N");
			}

		} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));

		if (respuesta.equalsIgnoreCase("S")) {
			idiomas = Teclado.leerInt("\n¿Cuántos idiomas habla el auxiliar?");
		}

	}

	// Mostrar datos

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("\nIdiomas: " + idiomas);
		System.out.println("\nSueldo con PLUS: " + calculaSueldo() + " Euros");
		System.out.println("\n------------------------------ FINAL EMPLEADO ----------------------------\n");
	}

	// Calcular sueldo
	@Override
	public float calculaSueldo() {

		float sueldoAuxiliar = 0;

		if (idiomas == 0) {
			sueldoAuxiliar = super.getSueldo();
		} else if (idiomas > 0) {
			sueldoAuxiliar = super.getSueldo() + (idiomas * PLUS);
		}

		return sueldoAuxiliar;
	}

}
