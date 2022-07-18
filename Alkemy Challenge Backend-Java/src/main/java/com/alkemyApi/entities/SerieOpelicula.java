package com.alkemyApi.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SerieOpelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String titulo;
	@Column
	private LocalDate fechaCreacion;
	@Column
	private int calificacion;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "personajes_peliculas", joinColumns = @JoinColumn(name = "peliculaId"), inverseJoinColumns = @JoinColumn(name = "personajeId"))
	private List<Personaje> personajesAsociados = new ArrayList<Personaje>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "genero_id", nullable = true)
	private Genero genero;

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

	public List<Personaje> getPersonajesAsociados() {
		return personajesAsociados;
	}

	public void setPersonajesAsociados(List<Personaje> personajesAsociados) {
		this.personajesAsociados = personajesAsociados;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public SerieOpelicula() {
	}

	public SerieOpelicula(String titulo, LocalDate fechaCreacion, int calificacion, List<Personaje> personajesAsociados,
			Genero genero) {
		super();
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.personajesAsociados = personajesAsociados;
		this.genero = genero;
	}

}
