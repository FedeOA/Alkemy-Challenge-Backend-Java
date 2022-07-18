package com.alkemyApi.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genero")
	private Set<SerieOpelicula> seriesYPeliculas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<SerieOpelicula> getSeriesYPeliculas() {
		return seriesYPeliculas;
	}

	public void setSeriesYPeliculas(Set<SerieOpelicula> seriesYPeliculas) {
		this.seriesYPeliculas = seriesYPeliculas;
	}

	public Genero(String genero) {
	this.nombre=genero;
	}
	
	public Genero() {}

}
