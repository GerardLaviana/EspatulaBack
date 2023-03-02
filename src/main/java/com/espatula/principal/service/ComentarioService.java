package com.espatula.principal.service;

import java.util.List;

import com.espatula.principal.model.Comentario;
import com.espatula.principal.model.Usuario;

public interface ComentarioService {

	public Comentario insertarComentario(Comentario comen);
	public List<Comentario> listarComentarios();
	public Comentario obtenerComentarioPorId(Integer id);
	public List<Comentario> obtenerComentariosPorUsuario(Usuario usu);
	public void eliminarComentario(Comentario comen);
	public void eliminarComentarioPorId(Integer id);
	
}
