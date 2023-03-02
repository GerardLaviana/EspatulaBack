package com.espatula.principal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espatula.principal.model.Comentario;
import com.espatula.principal.model.Usuario;
import com.espatula.principal.repository.ComentarioRepo;

@Service
public class ComentarioService implements com.espatula.principal.service.ComentarioService{

	@Autowired
	ComentarioRepo comentarioRepo;

	@Override
	public Comentario insertarComentario(Comentario comen) {
		return comentarioRepo.save(comen);
	}

	@Override
	public List<Comentario> listarComentarios() {
		return comentarioRepo.findAll();
	}

	@Override
	public Comentario obtenerComentarioPorId(Integer id) {
		return comentarioRepo.findById(id).get();
	}

	@Override
	public List<Comentario> obtenerComentariosPorUsuario(Usuario usu) {
		List<Comentario> listaComentarios = new ArrayList<Comentario>();
		for (Comentario comentario : listarComentarios()) {
			if(comentario.getUsuario().equals(usu)) {
				listaComentarios.add(comentario);
			};
		}
		return listaComentarios;
	}

	@Override
	public void eliminarComentario(Comentario comen) {
		comentarioRepo.delete(comen);
	}

	@Override
	public void eliminarComentarioPorId(Integer id) {
		comentarioRepo.delete(comentarioRepo.findById(id).get());
	}
	
}
