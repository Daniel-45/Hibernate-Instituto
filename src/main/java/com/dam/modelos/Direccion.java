package com.dam.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.dam.repositorios.Libreria;

import daw.com.Teclado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
//Indica que este POJO será parte de otra entidad
@Embeddable
public class Direccion implements Serializable {

	// Atributos
	@EqualsAndHashCode.Include
	private int id;

	@Column(length = 30)
	private String calle;

	private int numero;

	@Column(length = 20)
	private String poblacion;

	@Column(length = 20)
	private String localidad;

	private static final long serialVersionUID = 1L;

	// Métodos

	// Leer datos
	public void leerDatos() {
		calle = Teclado.leerString("\nIntroduce la calle:");
		numero = Libreria.leerPositivo("\nIntroduce el número:");
		poblacion = Teclado.leerString("\nIntroduce la ciudad:");
		localidad = Teclado.leerString("\nIntroduce la localidad:");
	}

	// Mostrar datos
	public void mostrarDatos() {
		System.out.println("\nID: " + id);
		System.out.println("\nCalle: " + calle);
		System.out.println("\nNúmero: " + numero);
		System.out.println("\nCiudad: " + poblacion);
		System.out.println("\nLocalidad: " + localidad);
	}

}
