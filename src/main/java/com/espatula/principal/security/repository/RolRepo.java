package com.espatula.principal.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espatula.principal.security.enums.RolNombre;
import com.espatula.principal.security.model.Rol;

public interface RolRepo extends JpaRepository<Rol, Integer> {
	
	public Optional<Rol> findByNombre(RolNombre name);

}
