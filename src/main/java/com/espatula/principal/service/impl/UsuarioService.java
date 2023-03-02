package com.espatula.principal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espatula.principal.model.Usuario;
import com.espatula.principal.repository.UsuarioRepo;

@Service
public class UsuarioService implements com.espatula.principal.service.UsuarioService {

	@Autowired
	UsuarioRepo usuarioRepo;
	
	@Override
	public Usuario insertarUsuario(Usuario usu) {
		return usuarioRepo.save(usu);
	}
	/**
	@Override
	public Usuario insertarUsuarioDTO(UsuarioDTO usuDTO) {
		Usuario usuarioNuevo = new Usuario(usuDTO.getUsername(), passwordEncoder.encode(usuDTO.getPassword()), usuDTO.getEmail());
		usuarioNuevo.getRoles().add(new Rol("ROLE_USER"));
		return usuarioRepo.save(usuarioNuevo);
	}*/

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer id) {
		return usuarioRepo.findById(id).get();
	}

	@Override
	public Usuario obtenerUsuarioPorUsername(String nombreUsuario) {
		return usuarioRepo.findByUsername(nombreUsuario).get();
	}

	@Override
	public void eliminarUsuario(Usuario user) {
		usuarioRepo.delete(user);
	}

	@Override
	public void eliminarUsuarioPorId(Integer id) {
		usuarioRepo.delete(usuarioRepo.findById(id).get());
	}
	
}
