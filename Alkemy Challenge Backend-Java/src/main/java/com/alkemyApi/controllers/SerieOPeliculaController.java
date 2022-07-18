package com.alkemyApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alkemyApi.models.SerieOPeliculaModel;
import com.alkemyApi.models.SerieOPeliculaModelGet;
import com.alkemyApi.services.ISerieOPeliculaService;

@RestController
@RequestMapping("/api/")
public class SerieOPeliculaController {

	@Autowired
	@Qualifier("serieOPeliculaService")
	private ISerieOPeliculaService serieOPeliculaService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/movies/newMovie")
	public ResponseEntity<SerieOPeliculaModel> crearPersonaje(@RequestBody SerieOPeliculaModel serieOPelicula) {
		return new ResponseEntity<>(serieOPeliculaService.crearSerieOPelicula(serieOPelicula), HttpStatus.CREATED);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("movies/update/{id}")
	public ResponseEntity<SerieOPeliculaModel> actualizarSerieOPelicula(@PathVariable(value = "id") int id,
			@RequestBody SerieOPeliculaModel serieOPeliculaUpdate) {
		SerieOPeliculaModel serieOPeliculaActualizada = serieOPeliculaService.actualizarSerieOPelicula(id,
				serieOPeliculaUpdate);

		return new ResponseEntity<>(serieOPeliculaActualizada, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/movies/delete/{id}")
	public ResponseEntity<String> eliminarSerieOPelicula(@PathVariable(value = "id") int id) {

		serieOPeliculaService.eliminarSerieOPelicula(id);
		return new ResponseEntity<>("Serie o pelicula eliminada con exito", HttpStatus.OK);
	}
	
	  @GetMapping("/movies") 
	  public List<SerieOPeliculaModelGet> obtenerPersonajes() {
	  
	  return serieOPeliculaService.obtenerSeriesOPeliculas();
	  
	  }
	  
	  @GetMapping("/movies/genre") public List<SerieOPeliculaModelGet>
	  obtenererSeriesOPeliculas(@RequestParam int idGenre) {
		  return serieOPeliculaService.obtenerSerieOPelicula(idGenre);
	   
	  }
	  
	  @GetMapping("/movies/name") public SerieOPeliculaModelGet
	  obtenererSeriesOPeliculas(@RequestParam String nombre) { 
		  
		  return serieOPeliculaService.obtenerSerieOPelicula(nombre);
	  
	  }
	  
	  @GetMapping("/movies/order") public List<SerieOPeliculaModelGet>
	  ordenarSeriesOPeliculas(@RequestParam String orden) { 
		  return serieOPeliculaService.ordernarSeriesOPeliculas(orden);
	  
	 }
	 
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @PostMapping("/movies/{idMovie}/characters/{idCharacter}")
	  public ResponseEntity<String> agregarPersonaje(@PathVariable(value="idMovie") int idMovie,@PathVariable (value="idCharacter")int idCharacter) {
		 
		  serieOPeliculaService.agregarPersonaje(idMovie,idCharacter);
		   return new ResponseEntity<>("Personaje agregado con exito", HttpStatus.OK);
		  
		  
		  
	  }

	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @DeleteMapping("/movies/{idMovie}/characters/{idCharacter}")
	  public ResponseEntity<String> eliminarPersonajeDeSerieOPelicula(@PathVariable(value="idMovie") int idMovie,@PathVariable (value="idCharacter")int idCharacter) {
		 
		  serieOPeliculaService.eliminarPersonaje(idMovie,idCharacter);
		   return new ResponseEntity<>("Personaje eliminado con exito", HttpStatus.OK);
		  
		  
		  
	  }
}
