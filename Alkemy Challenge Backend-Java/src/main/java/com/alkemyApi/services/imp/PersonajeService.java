package com.alkemyApi.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alkemyApi.entities.Personaje;
import com.alkemyApi.entities.SerieOpelicula;
import com.alkemyApi.models.PersonajeModel;
import com.alkemyApi.models.PersonajeModelGet;
import com.alkemyApi.repositories.IPersonajeRepository;
import com.alkemyApi.repositories.ISerieOPeliculaRepository;
import com.alkemyApi.services.IPersonajeService;

@Service
public class PersonajeService implements IPersonajeService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	@Qualifier("personajeRepository")
	private IPersonajeRepository personajeRepository;

	@Autowired
	@Qualifier("serieOPeliculaRepository")
	private ISerieOPeliculaRepository serieOPeliculaRepository;

	@Override
	public PersonajeModel crearPersonaje(PersonajeModel personajeModel) {

		Personaje nuevoPersonaje = new Personaje(personajeModel.getNombre(), personajeModel.getEdad(),
				personajeModel.getPeso(), personajeModel.getHistoria());

		personajeRepository.save(nuevoPersonaje);

		for (int i = 0; i < personajeModel.getSeriesYpeliculas().size(); i++) {

			SerieOpelicula pelicula = serieOPeliculaRepository
					.findByTitulo(personajeModel.getSeriesYpeliculas().get(i));
			pelicula.getPersonajesAsociados().add(nuevoPersonaje);
			serieOPeliculaRepository.save(pelicula);
		}

		return modelMapper.map(nuevoPersonaje, PersonajeModel.class);
	}

	@Override
	public List<PersonajeModelGet> obtenerPersonajes() {
		List<Personaje> personajes = personajeRepository.findAll();
		return personajes.stream().map(personaje -> mapearModel(personaje)).collect(Collectors.toList());
	}

	public List<PersonajeModelGet> obtenerPersonajes(int edad) {
		List<Personaje> personajes = personajeRepository.traerPersonajes(edad);

		return personajes.stream().map(personaje -> mapearModel(personaje)).collect(Collectors.toList());

	}

	private PersonajeModelGet mapearModel(Personaje personaje) {
		PersonajeModelGet personajeModel = modelMapper.map(personaje, PersonajeModelGet.class);
		return personajeModel;
	}

	@Override
	public List<PersonajeModelGet> obtenerPersonajes(String nombre) {
		List<Personaje> personajes = personajeRepository.traerPersonajes(nombre);

		return personajes.stream().map(personaje -> mapearModel(personaje)).collect(Collectors.toList());
	}

	@Override
	public List<PersonajeModelGet> obtenerPersonajesMovies(int idMovie) {

		SerieOpelicula serieOPelicula = serieOPeliculaRepository.findById(idMovie);

		return serieOPelicula.getPersonajesAsociados().stream().map(personaje -> mapearModel(personaje))
				.collect(Collectors.toList());
	}

	@Override
	public PersonajeModel actualizarPersonaje(int id, PersonajeModel personajeUpdate) {

		Personaje personaje = personajeRepository.findById(id);

		personaje.setEdad(personajeUpdate.getEdad());
		personaje.setHistoria(personajeUpdate.getHistoria());
		personaje.setNombre(personajeUpdate.getNombre());
		personaje.setPeso(personajeUpdate.getPeso());

		Personaje personajeActualizado = personajeRepository.save(personaje);

		return modelMapper.map(personajeActualizado, PersonajeModel.class);
	}

	@Override
	public void eliminarPersonaje(int id) {

		List<SerieOpelicula> seriesOPeliculas = serieOPeliculaRepository.findAll();
		Personaje p = personajeRepository.findById(id);

		for (int i = 0; i < seriesOPeliculas.size(); i++) {
			for (int z = 0; z < seriesOPeliculas.get(i).getPersonajesAsociados().size(); z++) {

				if (seriesOPeliculas.get(i).getPersonajesAsociados().get(z).getId() == id) {

					seriesOPeliculas.get(i).getPersonajesAsociados().remove(p);

				}

			}

		}
		personajeRepository.delete(p);

	}

}
