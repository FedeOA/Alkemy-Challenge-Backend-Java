package com.alkemyApi.models;

import java.util.ArrayList;
import java.util.List;

import com.alkemyApi.entities.SerieOpelicula;

public class PersonajeModel {

	private int id;

	private String nombre;

	private int edad;

	private float peso;

	private String historia;

	private List<String> seriesYpeliculas = new ArrayList<String>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getSeriesYpeliculas() {
		return seriesYpeliculas;
	}

	public void setSeriesYpeliculas(List<String> seriesYpeliculas) {
		this.seriesYpeliculas = seriesYpeliculas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public PersonajeModel() {
	}

	public PersonajeModel(int id, String nombre, int edad, float peso, String historia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
	}
	
	
}
