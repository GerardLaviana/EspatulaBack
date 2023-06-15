package com.espatula.principal.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.espatula.principal.model.Comentario;
import com.espatula.principal.security.model.Usuario;

public class RecetaEditDTO {

	private int id;
	
	private String nombre;

	private int duracion;
	
	private Date fecha;

	private String tipo;

	private String origen;

	private String instrucciones;
	
	private float valoracion;

	private String dificultad;
	
	private String urlImagen;
	
	private Set<Comentario> comentarios;
	
	private Usuario usuario;
	
	private List<IngredienteCantidadDTO> ingredientes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<IngredienteCantidadDTO> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<IngredienteCantidadDTO> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
