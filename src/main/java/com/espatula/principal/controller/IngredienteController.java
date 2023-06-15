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

import com.espatula.principal.dto.IngredienteDTO;
import com.espatula.principal.model.Ingrediente;
import com.espatula.principal.service.IngredienteService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteService ingreService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se han devuelto todos los ingredientes")
	})
	public List<Ingrediente> listadoIngredientes(){
	        return ingreService.listarIngredientes();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha devuelto el ingrediente")
	})
	public Ingrediente obtenerIngredientePorID(@PathVariable(name = "id") Integer id){
	        return ingreService.obtenerIngredientePorId(id);
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha insertado el ingrediente")
	})
	public ResponseEntity<?> insertarIngrediente(@RequestBody IngredienteDTO ingreNuevoDTO, BindingResult bindingResult){
		if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Ingrediente ingreNuevo = new Ingrediente(ingreNuevoDTO.getNombre(), ingreNuevoDTO.getTipo(), ingreNuevoDTO.isGluten());
		ingreService.insertarIngrediente(ingreNuevo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha actualizado el ingrediente")
	})
	public ResponseEntity<?> actualizarIngrediente(@PathVariable(name = "id") Integer idIngreAntiguo, @RequestBody IngredienteDTO ingreActualizado, BindingResult bindingResult){
	        if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Ingrediente ingreAntiguo = ingreService.obtenerIngredientePorId(idIngreAntiguo); 
		ingreAntiguo.setNombre(ingreActualizado.getNombre());
		ingreAntiguo.setTipo(ingreActualizado.getTipo());
		ingreAntiguo.setGluten(ingreActualizado.isGluten());
		
		ingreService.insertarIngrediente(ingreAntiguo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha eliminado el ingrediente")
	})
	public ResponseEntity<HttpStatus> eliminarIngredientePorID(@PathVariable(name = "id") Integer id){
		try{
			ingreService.eliminarIngredientePorId(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
