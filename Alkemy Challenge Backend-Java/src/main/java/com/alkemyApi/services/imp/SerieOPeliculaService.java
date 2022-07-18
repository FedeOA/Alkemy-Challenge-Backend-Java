package com.alkemyApi.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alkemyApi.entities.Genero;
import com.alkemyApi.entities.Personaje;
import com.alkemyApi.entities.SerieOpelicula;
import com.alkemyApi.models.PersonajeModelGet;
import com.alkemyApi.models.SerieOPeliculaModel;
import com.alkemyApi.models.SerieOPeliculaModelGet;
import com.alkemyApi.repositories.IGeneroRepository;
import com.alkemyApi.repositories.IPersonajeRepository;
import com.alkemyApi.repositories.ISerieOPeliculaRepository;
import com.alkemyApi.services.ISerieOPeliculaService;


@Service
public class SerieOPeliculaService implements ISerieOPeliculaService {

	@Autowired
	@Qualifier("serieOPeliculaRepository")
	private ISerieOPeliculaRepository serieOPeliculaRepository;

	@Autowired
	@Qualifier("personajeRepository")
	private IPersonajeRepository personajeRepository;

	@Autowired
	@Qualifier("generoRepository")
	private IGeneroRepository generoRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<PersonajeModelGet> obtenerPersonajes(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SerieOPeliculaModel crearSerieOPelicula(SerieOPeliculaModel serieOPelicula) {

		Genero genero = generoRepository.findByGenero(serieOPelicula.getGenero());
		List<Personaje> personajesAsociados = new ArrayList<Personaje>();

		if(personajesAsociados!=null) {
		for (int i = 0; i < serieOPelicula.getPersonajesAsociados().size(); i++) {

			personajesAsociados.add(personajeRepository.traerPersonaje(serieOPelicula.getPersonajesAsociados().get(i)));

		}
		}
		SerieOpelicula nuevaSerieOPelicula = new SerieOpelicula(serieOPelicula.getTitulo(),
				serieOPelicula.getFechaCreacion(), serieOPelicula.getCalificacion(), personajesAsociados, genero);
		serieOPeliculaRepository.save(nuevaSerieOPelicula);

		return modelMapper.map(nuevaSerieOPelicula, SerieOPeliculaModel.class);
	}

	@Override
	public SerieOPeliculaModel actualizarSerieOPelicula(int id, SerieOPeliculaModel serieOPeliculaUpdate) {
		SerieOpelicula serieOPelicula = serieOPeliculaRepository.findById(id);

		serieOPelicula.setTitulo(serieOPeliculaUpdate.getTitulo());
		serieOPelicula.setCalificacion(serieOPeliculaUpdate.getCalificacion());
		serieOPelicula.setFechaCreacion(serieOPeliculaUpdate.getFechaCreacion());
		serieOPelicula.setGenero(generoRepository.findByGenero(serieOPeliculaUpdate.getGenero()));
		SerieOpelicula serieOPeliculaActualizada = serieOPeliculaRepository.save(serieOPelicula);

		return modelMapper.map(serieOPeliculaActualizada, SerieOPeliculaModel.class);

	}

	@Override
	public void eliminarSerieOPelicula(int id) {

		SerieOpelicula s = serieOPeliculaRepository.findById(id);

		for (int i = 0; i < s.getPersonajesAsociados().size(); i++) {
			s.getPersonajesAsociados().remove(s.getPersonajesAsociados().get(i));
			serieOPeliculaRepository.save(s);
		}

		serieOPeliculaRepository.delete(s);

	}

	@Override
	public List<SerieOPeliculaModelGet> obtenerSeriesOPeliculas() {
		List<SerieOpelicula> seriesOPeliculas = serieOPeliculaRepository.findAll();
		return seriesOPeliculas.stream().map(serieOPelicula -> mapearModel(serieOPelicula))
				.collect(Collectors.toList());
	}

	
	public SerieOPeliculaModelGet obtenerSerieOPelicula(String nombre) {
		return modelMapper.map(serieOPeliculaRepository.findByTitulo(nombre), SerieOPeliculaModelGet.class);
		}
	
	
	public SerieOPeliculaModelGet mapearModel(SerieOpelicula serieOPelicula) {
		SerieOPeliculaModelGet serieOPeliculaModel = modelMapper.map(serieOPelicula, SerieOPeliculaModelGet.class);
		return serieOPeliculaModel;
	}

	@Override
	public List<SerieOPeliculaModelGet> obtenerSerieOPelicula(int idGenre) {
		// TODO Auto-generated method stub
		List<SerieOpelicula> seriesOPeliculas = serieOPeliculaRepository.findAll();
		List<SerieOpelicula> seriesOPeliculas2=new ArrayList<SerieOpelicula>();
	
		
		for (int i=0;i<seriesOPeliculas.size();i++) {
			
			if (seriesOPeliculas.get(i).getGenero().getId()==idGenre) {
				
				seriesOPeliculas2.add(seriesOPeliculas.get(i));
				
				
				
			}
			
		}
		
		return seriesOPeliculas2.stream().map(serieOPelicula -> mapearModel(serieOPelicula))
				.collect(Collectors.toList());
	}

	@Override
	public List<SerieOPeliculaModelGet> ordernarSeriesOPeliculas(String orden) {
		// TODO Autoenerated method stub
		List<SerieOpelicula> seriesOPeliculas=null;
		if (orden.equals("ASC")) {
			seriesOPeliculas= serieOPeliculaRepository.traerSeriesOPeliculasOrdenadasDESC();
		}else {
			
			seriesOPeliculas= serieOPeliculaRepository.traerSeriesOPeliculasOrdenadasASC();
		}
		
		return seriesOPeliculas.stream().map(serieOPelicula -> mapearModel(serieOPelicula))
				.collect(Collectors.toList());
	}

	@Override
	public void agregarPersonaje(int idMovie, int idCharacter) {
		
		SerieOpelicula serieOPelicula= serieOPeliculaRepository.findById(idMovie);
		List<Personaje> listaAux=serieOPelicula.getPersonajesAsociados();
		Personaje personaje= personajeRepository.findById(idCharacter);
		listaAux.add(personaje);
		
		serieOPelicula.setPersonajesAsociados(listaAux);
		
		serieOPeliculaRepository.save(serieOPelicula);
	}

	@Override
	public void eliminarPersonaje(int idMovie, int idCharacter) {
		
		SerieOpelicula serieOPelicula= serieOPeliculaRepository.findById(idMovie);
		List<Personaje> listaAux=serieOPelicula.getPersonajesAsociados();
		Personaje personaje= personajeRepository.findById(idCharacter);
		listaAux.remove(personaje);
		
		serieOPelicula.setPersonajesAsociados(listaAux);
		
		serieOPeliculaRepository.save(serieOPelicula);
	}

}
