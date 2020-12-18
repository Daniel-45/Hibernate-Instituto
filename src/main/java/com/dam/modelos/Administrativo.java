package com.dam.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

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
@DiscriminatorValue(value = "ADMINISTRATIVOS")
public class Administrativo extends Empleado implements Serializable {

	// Atributos
	@Column(name = "AÑOS_DE_EXPERIENCIA", nullable = true)
	@SerializedName("años de experiencia")
	private int aniosExperiencia;

	@Transient
	private transient static final float PLUS = 150;

	private static final long serialVersionUID = 1L;

	// Métodos

	// Leer datos
	public void leerDatos() {
		super.leerDatos();

		do {

			if (aniosExperiencia < 0) {
				System.out.println("\nLos años de experiencia no pueden ser inferior a cero!!");
			} else {
				aniosExperiencia = Teclado.leerInt("\nAños de experiencia:");
			}

		} while (aniosExperiencia < 0);
	}

	// Mostrar datos
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("\nAños de experiencia: " + aniosExperiencia);
		System.out.println("\nSueldo con PLUS: " + calculaSueldo() + " Euros");
		System.out.println("\n------------------------------ FINAL EMPLEADO ----------------------------\n");
	}

	// Calcular sueldo
	@Override
	public float calculaSueldo() {

		float sueldoAdministrativo = 0;

		if (aniosExperiencia == 0) {

			sueldoAdministrativo = super.getSueldo();

		} else if (aniosExperiencia > 0) {

			sueldoAdministrativo = super.getSueldo() + (aniosExperiencia * PLUS);
		}

		return sueldoAdministrativo;
	}

}
