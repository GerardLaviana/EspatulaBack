package com.espatula.principal.service;

import java.util.List;

import com.espatula.principal.model.Receta;

public interface RecetaService {

	public Receta insertarReceta(Receta rece);
	public Receta actualizarReceta(Receta receU, Integer idRA);
	public List<Receta> listarRecetas();
	public Receta obtenerRecetaPorId(Integer id);
	public Receta obtenerRecetaPorNombre(String nombreReceta);
	public void eliminarReceta(Receta rece);
	public void eliminarRecetaPorId(Integer id);
	
}
