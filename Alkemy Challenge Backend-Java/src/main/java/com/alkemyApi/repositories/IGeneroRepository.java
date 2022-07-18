package com.alkemyApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alkemyApi.entities.Genero;

@Repository("generoRepository")
public interface IGeneroRepository extends JpaRepository<Genero, Integer> {

	@Query("SELECT g FROM Genero g where g.nombre=(:nombre)")
	public abstract Genero findByGenero(@Param(value = "nombre") String nombre);
}
