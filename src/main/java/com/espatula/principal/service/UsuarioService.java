package com.espatula.principal.service;

import java.util.List;

import com.espatula.principal.model.Usuario;

public interface UsuarioService {

	public Usuario insertarUsuario(Usuario usu);
	//public Usuario insertarUsuarioDTO(UsuarioDTO usuDTO);
	public List<Usuario> listarUsuarios();
	public Usuario obtenerUsuarioPorId(Integer id);
	public Usuario obtenerUsuarioPorUsername(String nombreUsuario);
	public void eliminarUsuario(Usuario user);
	public void eliminarUsuarioPorId(Integer id);
	
}
