package com.espatula.principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espatula.principal.dto.UsuarioDTO;
import com.espatula.principal.security.model.Rol;
import com.espatula.principal.security.model.Usuario;
import com.espatula.principal.security.service.RolService;
import com.espatula.principal.security.service.UsuarioService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuService;
	
	@Autowired
	private RolService rolService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se han devuelto todos los usuarios")
	})
	public List<Usuario> listadoUsuarios(){
	        return usuService.listarUsuarios();
	}
	
	@RequestMapping(value="/getRoles", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se han devuelto todos los roles")
	})
	public List<Rol> listadoRoles(){
	        return rolService.listarRoles();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha devuelto el usuario")
	})
	public Usuario obtenerUsuarioPorID(@PathVariable(name = "id") Integer id){
	        return usuService.obtenerUsuarioPorId(id);
	}
	
	@RequestMapping(value="/username/{username}", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha devuelto el usuario por su username")
	})
	public Usuario obtenerUsuarioPorUsername(@PathVariable(name = "username") String username){
	        return usuService.obtenerUsuarioPorUsername(username);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha actualizado el usuario")
	})
	public ResponseEntity<?> actualizarUsuario(@PathVariable(name = "id") Integer idUsuAntiguo, @RequestBody UsuarioDTO usuActualizado, BindingResult bindingResult){
	        if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Usuario usuarioAntiguo = usuService.obtenerUsuarioPorId(idUsuAntiguo); 
	
		usuarioAntiguo.setUsername(usuActualizado.getUsername());
		usuarioAntiguo.setEmail(usuActualizado.getEmail());
		usuarioAntiguo.setRoles(usuActualizado.getRoles());
		
		usuService.guardar(usuarioAntiguo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha eliminado el usuario")
	})
	public ResponseEntity<HttpStatus> eliminarUsuarioPorID(@PathVariable(name = "id") Integer id){
		try{
			Usuario usuEliminar = usuService.obtenerUsuarioPorId(id);
			usuEliminar.getRoles().clear();
			usuService.deletePorId(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
