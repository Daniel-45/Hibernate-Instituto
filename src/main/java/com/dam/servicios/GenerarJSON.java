package com.dam.servicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.dam.MainInstitutoHibernate;
import com.dam.Service;
import com.dam.modelos.Instituto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GenerarJSON implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		Instituto instituto = MainInstitutoHibernate.cargaDatos();

		Gson creador = new GsonBuilder().setPrettyPrinting().create();

		// Guardar en un String el objeto (banco)
		String jsonCadena = creador.toJson(instituto);

		// Mostrar por consola el json creado
		System.out.println(jsonCadena);

		PrintWriter ficheroInstituto;

		// Meter dentro de un bloque try/catch para tratar las excepciones
		try {
			// Instanciar el objeto con el fichero json que quiero crear como parametro.
			ficheroInstituto = new PrintWriter(new File("files/instituto.json"));

			// Convertir objetos Java a JSON.
			creador.toJson(instituto, ficheroInstituto);

			// IMPORTANTE!! Hay que cerrar el fichero.
			ficheroInstituto.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
