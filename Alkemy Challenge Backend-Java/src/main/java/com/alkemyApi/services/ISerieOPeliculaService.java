package com.alkemyApi.services;

import java.util.List;

import com.alkemyApi.models.PersonajeModelGet;
import com.alkemyApi.models.SerieOPeliculaModel;
import com.alkemyApi.models.SerieOPeliculaModelGet;

public interface ISerieOPeliculaService {

	public List<PersonajeModelGet> obtenerPersonajes(int id);

	public SerieOPeliculaModel crearSerieOPelicula(SerieOPeliculaModel serieOPelicula);

	public SerieOPeliculaModel actualizarSerieOPelicula(int id, SerieOPeliculaModel serieOPeliculaUpdate);

	public void eliminarSerieOPelicula(int id);

	public List<SerieOPeliculaModelGet> obtenerSeriesOPeliculas();
	
	public SerieOPeliculaModelGet obtenerSerieOPelicula(String nombre);

	public List<SerieOPeliculaModelGet> obtenerSerieOPelicula(int idGenre);

	public List<SerieOPeliculaModelGet> ordernarSeriesOPeliculas(String orden);

	public void agregarPersonaje(int idMovie, int idCharacter);

	public void eliminarPersonaje(int idMovie, int idCharacter);

	

}
