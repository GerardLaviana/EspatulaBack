package com.espatula.principal.service;

import java.util.List;

import com.espatula.principal.model.Ingrediente;

public interface IngredienteService {

	public Ingrediente insertarIngrediente(Ingrediente ingre);
	public Ingrediente actualizarIngrediente(Ingrediente ingreU, Integer idIA);
	public List<Ingrediente> listarIngredientes();
	public Ingrediente obtenerIngredientePorId(Integer id);
	public Ingrediente obtenerIngredientePorNombre(String nombreIngre);
	public void eliminarIngrediente(Ingrediente ingre);
	public void eliminarIngredientePorId(Integer id);
	
}
