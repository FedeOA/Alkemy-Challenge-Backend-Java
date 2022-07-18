package com.alkemyApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemyApi.models.GeneroModel;
import com.alkemyApi.services.IGeneroService;

@RestController
@RequestMapping("/api/")
public class GeneroController {

	
	@Autowired
	@Qualifier("generoService")
	private IGeneroService generoService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/generos/newGeneros")
	public ResponseEntity<GeneroModel> crearPersonaje(@RequestBody GeneroModel generoModel) {
		return new ResponseEntity<>(generoService.crearGenero(generoModel), HttpStatus.CREATED);

	}
}
