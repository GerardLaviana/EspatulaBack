package com.espatula.principal.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.espatula.principal.security.model.Usuario;

@Entity
@Table(name = "recetas")
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "valoracion")
	private float valoracion;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "duracion")
	private int duracion;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "origen")
	private String origen;

	@Column(name = "instrucciones")
	private String instrucciones;

	@Column(name = "dificultad")
	private String dificultad;
	
	@Column(name = "urlImagen")
	private String urlImagen;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@OneToMany(mappedBy="receta", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE )
	private Set<Comentario> comentarios;
	
	@OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<RecetasIngredientes> ingredientes;

	public Receta() {
		this.fecha = new Date();
		this.valoracion = 0f;
		this.usuario = new Usuario();
		this.comentarios = new HashSet<Comentario>();
		this.ingredientes = new HashSet<RecetasIngredientes>();
	}

	public Receta(String nombre, int duracion, String tipo, String origen, String instrucciones,
			String dificultad, String urlImg) {
		this.nombre = nombre;
		this.valoracion = 0f;
		this.duracion = duracion;
		this.tipo = tipo;
		this.origen = origen;
		this.instrucciones = instrucciones;
		this.dificultad = dificultad;
		this.urlImagen = urlImg;
		this.fecha = new Date();
		this.usuario = new Usuario();
		this.comentarios = new HashSet<Comentario>();
		this.ingredientes = new HashSet<RecetasIngredientes>();
	}

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

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<RecetasIngredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<RecetasIngredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void addIngrediente(Ingrediente ingre, int cantidad, String medida) {
		RecetasIngredientes ri = new RecetasIngredientes(this, ingre, cantidad, medida);
		if (this.ingredientes.contains(ri)) {
			this.ingredientes.remove(ri);
		}
		if (cantidad != 0) {
			this.ingredientes.add(ri);
			ingre.getRecetas().add(ri);
		}
	}

	public void removeIngrediente(Ingrediente ingre) {
		for (RecetasIngredientes ri : this.ingredientes) {
			if (ri.getIngrediente().equals(ingre)) {
				this.ingredientes.remove(ri);
			}
		}
		for (RecetasIngredientes ri : ingre.getRecetas()) {
			if (ri.getReceta().equals(this)) {
				ingre.getRecetas().remove(ri);
			}
		}
	}
	
	public void removeIngredientes() {
		this.ingredientes.removeAll(this.ingredientes);
	}
	
}
