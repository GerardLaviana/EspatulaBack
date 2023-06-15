package com.espatula.principal.security.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espatula.principal.security.model.Usuario;
import com.espatula.principal.security.repository.UsuarioRepo;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepo usuarioRepo;
	
	public Optional<Usuario> getByUsername(String nombreUsu){
		return usuarioRepo.findByUsername(nombreUsu);
	}
	
	public boolean existsByUsername(String nombre){
		return usuarioRepo.existsByUsername(nombre);
	}
	
	public boolean existsByEmail(String correo){
		return usuarioRepo.existsByEmail(correo);
	}
	
	public Usuario guardar(Usuario usu) {
		 return usuarioRepo.save(usu);
	}
	
	public List<Usuario> listarUsuarios() {
		return usuarioRepo.findAll();
	}
	
	public Usuario obtenerUsuarioPorId(Integer id) {
		return usuarioRepo.findById(id).get();
	}

	
	public Usuario obtenerUsuarioPorUsername(String nombreUsuario) {
		return usuarioRepo.findByUsername(nombreUsuario).get();
	}

	public void deletePorId(int id) {
		usuarioRepo.delete(usuarioRepo.findById(id).get());
	}
	
	public void eliminarUsuario(Usuario user) {
		usuarioRepo.delete(user);
	}
	
	public Usuario actualizarUsuario(Usuario usuU, Integer idUA) {
		Usuario usuAntiguo = obtenerUsuarioPorId(idUA);
		//TODO: GUARDAR NUEVOS DATOS??
		return guardar(usuAntiguo);
	}
}
