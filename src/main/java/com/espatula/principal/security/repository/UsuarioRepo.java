package com.espatula.principal.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.espatula.principal.security.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

	public Optional<Usuario> findByUsername(String name);
	boolean existsByUsername(String name);
	boolean existsByEmail(String email);
}
