package com.espatula.principal.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espatula.principal.security.enums.RolNombre;
import com.espatula.principal.security.model.Rol;
import com.espatula.principal.security.repository.RolRepo;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepo rolRepo;
	
	
	public List<Rol> listarRoles() {
		return rolRepo.findAll();
	}
	
	public Optional<Rol> getByNombre(RolNombre rolNombre){
		return rolRepo.findByNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		 rolRepo.save(rol);
	}
}
