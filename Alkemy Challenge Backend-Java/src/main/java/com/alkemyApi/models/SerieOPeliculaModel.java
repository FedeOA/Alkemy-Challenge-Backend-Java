package com.alkemyApi.models;

import java.time.LocalDate;
import java.util.List;

public class SerieOPeliculaModel {

	private int id;

	private String titulo;

	private LocalDate fechaCreacion;

	private int calificacion;

	private List<String> personajesAsociados;

	private String genero;

	public SerieOPeliculaModel() {
	}

	public SerieOPeliculaModel(String titulo, LocalDate fechaCreacion, int calificacion,
			List<String> personajesAsociados, String genero) {
		super();
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.personajesAsociados = personajesAsociados;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public List<String> getPersonajesAsociados() {
		return personajesAsociados;
	}

	public void setPersonajesAsociados(List<String> personajesAsociados) {
		this.personajesAsociados = personajesAsociados;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
