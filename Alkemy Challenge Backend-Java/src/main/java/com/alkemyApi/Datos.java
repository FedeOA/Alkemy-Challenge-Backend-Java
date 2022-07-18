package com.alkemyApi;

import java.util.Optional;

import com.alkemyApi.entities.Personaje;
import com.alkemyApi.models.PersonajeModel;

public class Datos {

	public static Optional<Personaje> crearPrersonaje001() {

		return Optional.of(new Personaje(10, "Iron man", 50, 90,
				"es un millonario excentrico a quien le gusta llamar la atencion"));
	}

	public static Optional<Personaje> crearPrersonaje002() {

		return Optional.of(new Personaje(20, "Superman", 40, 100,
				"es un superheroe que cuenta con gran fuerza y la capacidad de volar"));
	}
}
