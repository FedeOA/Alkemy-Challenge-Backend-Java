package com.alkemyApi.services;

import java.util.List;

import com.alkemyApi.models.PersonajeModel;
import com.alkemyApi.models.PersonajeModelGet;

public interface IPersonajeService {

	public PersonajeModel crearPersonaje(PersonajeModel personajeModel);

	public List<PersonajeModelGet> obtenerPersonajes();

	public List<PersonajeModelGet> obtenerPersonajes(int edad);

	public List<PersonajeModelGet> obtenerPersonajes(String nombre);

	public List<PersonajeModelGet> obtenerPersonajesMovies(int idMovie);

	public PersonajeModel actualizarPersonaje(int id, PersonajeModel personajeUpdate);

	public void eliminarPersonaje(int id);

}
