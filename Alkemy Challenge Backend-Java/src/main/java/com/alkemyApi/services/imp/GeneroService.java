package com.alkemyApi.services.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alkemyApi.entities.Genero;
import com.alkemyApi.models.GeneroModel;
import com.alkemyApi.repositories.IGeneroRepository;
import com.alkemyApi.repositories.IPersonajeRepository;
import com.alkemyApi.services.IGeneroService;
@Service
public class GeneroService implements IGeneroService {

	@Autowired
	@Qualifier("generoRepository")
	private IGeneroRepository generoRepository;

	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public GeneroModel crearGenero(GeneroModel generoModel) {
		Genero generoNuevo= new Genero(generoModel.getGenero());
		generoRepository.save(generoNuevo);
				
				return modelMapper.map(generoNuevo, GeneroModel.class);
	}

}
