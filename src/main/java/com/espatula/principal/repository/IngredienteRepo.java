package com.espatula.principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espatula.principal.model.Ingrediente;

public interface IngredienteRepo extends JpaRepository<Ingrediente, Integer> {

	public Optional<Ingrediente> findByNombre(String name);
	
}
