package com.alkemyApi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.alkemyApi.entities.SerieOpelicula;
import com.alkemyApi.models.SerieOPeliculaModelGet;

@Repository("serieOPeliculaRepository")
public interface ISerieOPeliculaRepository extends JpaRepository<SerieOpelicula, Integer> {

	public abstract SerieOpelicula findByTitulo(@Param("titulo") String titulo);

	public abstract SerieOpelicula findById(@Param("id") int id);
	
	
	@Query ("SELECT s FROM SerieOpelicula s order by (s.titulo) ASC")
	public abstract List<SerieOpelicula> traerSeriesOPeliculasOrdenadasASC();
	
	@Query ("SELECT s FROM SerieOpelicula s order by (s.titulo) DESC")
	public abstract List<SerieOpelicula> traerSeriesOPeliculasOrdenadasDESC();

}
