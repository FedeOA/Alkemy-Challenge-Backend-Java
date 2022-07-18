package com.alkemyApi.models;

import java.time.LocalDate;

public class SerieOPeliculaModelGet {

	
	
	private String titulo;
	private LocalDate fechaCreacion;
	
	public SerieOPeliculaModelGet() {}
	
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
	
	
}
