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
import com.alkemyApi.models.PersonajeModel;
import com.alkemyApi.models.PersonajeModelGet;
import com.alkemyApi.services.IPersonajeService;

@RestController
@RequestMapping("/api/")
public class PersonajeController {

	@Autowired
	@Qualifier("personajeService")
	private IPersonajeService personajeService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/characters/newCharacter")
	public ResponseEntity<PersonajeModel> crearPersonaje(@RequestBody PersonajeModel personajeModel) {
		return new ResponseEntity<>(personajeService.crearPersonaje(personajeModel), HttpStatus.CREATED);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("characters/update/{id}")
	public ResponseEntity<PersonajeModel> actualizarPersonaje(@PathVariable(value = "id") int id,
			@RequestBody PersonajeModel personajeUpdate) {
		PersonajeModel personajeActualizado = personajeService.actualizarPersonaje(id, personajeUpdate);

		return new ResponseEntity<>(personajeActualizado, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/characters/delete/{id}")
	public ResponseEntity<String> eliminarPersonaje(@PathVariable(value = "id") int id) {

		personajeService.eliminarPersonaje(id);
		return new ResponseEntity<>("Personaje eliminado con exito", HttpStatus.OK);
	}

	@GetMapping("/characters")
	public List<PersonajeModelGet> obtenerPersonajes() {

		return personajeService.obtenerPersonajes();

	}

	@GetMapping("/characters/age")
	public List<PersonajeModelGet> obtenererPersonajes(@RequestParam int age) {
		return personajeService.obtenerPersonajes(age);

	}

	@GetMapping("/characters/name")
	public List<PersonajeModelGet> obtenererPersonajes(@RequestParam String nombre) {
		return personajeService.obtenerPersonajes(nombre);

	}

	@GetMapping("/characters/movies")
	public List<PersonajeModelGet> obtenererPersonajesMovies(@RequestParam int idMovie) {
		return personajeService.obtenerPersonajesMovies(idMovie);

	}

}
