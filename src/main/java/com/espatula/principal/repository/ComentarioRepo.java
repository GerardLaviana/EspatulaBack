package com.espatula.principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espatula.principal.model.Comentario;
import com.espatula.principal.security.model.Usuario;

public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {

	public Optional<Comentario> findByUsuario(Usuario usuario);
	
}
