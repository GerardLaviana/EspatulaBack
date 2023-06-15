package com.espatula.principal.security.model;

import java.util.Collection;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.espatula.principal.model.Comentario;
import com.espatula.principal.model.Receta;

public class UsuarioPrincipal implements UserDetails{

	private String username;
	private String password;
	private String email;
	private Set<Receta> recetas;
	private Set<Comentario> comentarios;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioPrincipal(String username, String password, String email, Set<Receta> recetas,
			Set<Comentario> comentarios, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.recetas = recetas;
		this.comentarios = comentarios;
		this.authorities = authorities;
	}

	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> authorities = usuario.getRoles().stream().map(
				rol -> new SimpleGrantedAuthority(rol.getNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getUsername(), usuario.getPassword(), usuario.getEmail(), usuario.getRecetas(), usuario.getComentarios(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Set<Receta> getRecetas() {
		return recetas;
	}
	
	public Set<Comentario> getComentarios() {
		return comentarios;
	}
	
}
