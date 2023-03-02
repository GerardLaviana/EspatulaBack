package com.espatula.principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espatula.principal.model.Receta;

public interface RecetaRepo extends JpaRepository<Receta, Integer>{

	public Optional<Receta> findByNombre(String name);
	
}
