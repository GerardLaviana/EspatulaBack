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

import com.espatula.principal.dto.ComentarioDTO;
import com.espatula.principal.model.Comentario;
import com.espatula.principal.model.Receta;
import com.espatula.principal.security.model.Usuario;
import com.espatula.principal.security.service.UsuarioService;
import com.espatula.principal.service.ComentarioService;
import com.espatula.principal.service.RecetaService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService comenService;
	
	@Autowired
	private RecetaService receService;
	
	@Autowired
	private UsuarioService usuService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se han devuelto todos los comentarios")
	})
	public List<Comentario> listadoRecetas(){
	        return comenService.listarComentarios();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha devuelto el comentario")
	})
	public Comentario obtenerComentarioPorID(@PathVariable(name = "id") Integer id){
	        return comenService.obtenerComentarioPorId(id);
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha insertado el comentario")
	})
	public ResponseEntity<?> insertarComentario(@RequestBody ComentarioDTO comenDTO, BindingResult bindingResult){
	    if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    Receta recetaComentada = receService.obtenerRecetaPorId(comenDTO.getIdReceta());
	    Usuario usuarioComentador = usuService.obtenerUsuarioPorUsername(comenDTO.getUsername());
		Comentario comenNuevo = new Comentario(comenDTO.getMensaje(), recetaComentada, usuarioComentador);
		
		comenService.insertarComentario(comenNuevo);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha eliminado el comentario")
	})
	public ResponseEntity<HttpStatus> eliminarComentarioPorID(@PathVariable(name = "id") Integer id){
		try{
			comenService.eliminarComentarioPorId(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
