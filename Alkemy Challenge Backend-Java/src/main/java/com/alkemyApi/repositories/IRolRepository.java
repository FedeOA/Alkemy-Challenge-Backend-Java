package com.alkemyApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemyApi.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer> {

	public Optional<Rol> findByRol(String nombre);
}
