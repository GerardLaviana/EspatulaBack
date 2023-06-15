package com.espatula.principal.dto;

import java.util.List;

import com.espatula.principal.security.model.Usuario;

public class RecetaDTO {

	private String nombre;

	private int duracion;

	private String tipo;

	private String origen;

	private String instrucciones;

	private String dificultad;
	
	private String urlImagen;
	
	private Usuario usuario;
	
	private List<IngredienteCantidadDTO> ingredientes;

	public String getNombre() {
		return nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getOrigen() {
		return origen;
	}

	public String getInstrucciones() {
		return instrucciones;
	}

	public String getDificultad() {
		return dificultad;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<IngredienteCantidadDTO> getIngredientes() {
		return ingredientes;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setIngredientes(List<IngredienteCantidadDTO> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
