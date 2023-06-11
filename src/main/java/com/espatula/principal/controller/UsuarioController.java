package com.espatula.principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espatula.principal.security.model.Usuario;
import com.espatula.principal.security.service.UsuarioService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se han devuelto todos los usuarios")
	})
	public List<Usuario> listadoUsuarios(){
	        return usuService.listarUsuarios();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha devuelto el usuario")
	})
	public Usuario obtenerUsuarioPorID(@PathVariable(name = "id") Integer id){
	        return usuService.obtenerUsuarioPorId(id);
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha insertado el usuario")
	})
	public Usuario insertarUsuario(@RequestBody Usuario usuNuevo){
	        return usuService.guardar(usuNuevo);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha actualizado el usuario")
	})
	public Usuario actualizarUsuario(@RequestBody Usuario usuActualizado, @PathVariable(name = "id") Integer idUsuAntiguo){
	        return usuService.actualizarUsuario(usuActualizado, idUsuAntiguo);
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha eliminado el usuario")
	})
	public ResponseEntity<HttpStatus> eliminarUsuarioPorID(@PathVariable(name = "id") Integer id){
		try{
			usuService.deletePorId(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
