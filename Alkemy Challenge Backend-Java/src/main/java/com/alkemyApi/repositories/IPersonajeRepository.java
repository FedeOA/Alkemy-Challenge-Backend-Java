package com.alkemyApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.alkemyApi.entities.Personaje;

@Repository("personajeRepository")
public interface IPersonajeRepository extends JpaRepository<Personaje, Integer> {

	@Query("SELECT p FROM Personaje p where p.edad=(:edad)")
	public abstract List<Personaje> traerPersonajes(@Param("edad") int edad);

	@Query("SELECT p FROM Personaje p where p.nombre=(:nombre)")
	public abstract List<Personaje> traerPersonajes(@Param("nombre") String nombre);

	@Query("SELECT p FROM Personaje p where p.nombre=(:nombre)")
	public abstract Personaje traerPersonaje(@Param("nombre") String nombre);

	@Query("SELECT p FROM Personaje p where p.id=(:id)")
	public Personaje findById(int id);

}
