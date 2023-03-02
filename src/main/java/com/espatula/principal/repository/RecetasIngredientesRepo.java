package com.espatula.principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espatula.principal.model.RecetasIngredientes;

public interface RecetasIngredientesRepo extends JpaRepository<RecetasIngredientes, Integer> {

	//public Optional<RecetasIngredientes> findByNombre(String name);
	
}
