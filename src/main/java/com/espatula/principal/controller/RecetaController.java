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

import com.espatula.principal.model.Receta;
import com.espatula.principal.service.RecetaService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/receta")
public class RecetaController {

	@Autowired
	private RecetaService receService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se han devuelto todas las recetas")
	})
	public List<Receta> listadoRecetas(){
	        return receService.listarRecetas();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha devuelto la receta")
	})
	public Receta obtenerRecetaPorID(@PathVariable(name = "id") Integer id){
	        return receService.obtenerRecetaPorId(id);
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha insertado la receta")
	})
	public Receta insertarReceta(@RequestBody Receta recetaNueva){
	        return receService.insertarReceta(recetaNueva);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha actualizado la receta")
	})
	public Receta actualizarReceta(@RequestBody Receta recetaActualizada, @PathVariable(name = "id") Integer idRecetaAntigua){
	        return receService.actualizarReceta(recetaActualizada, idRecetaAntigua);
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha eliminado la receta")
	})
	public ResponseEntity<HttpStatus> eliminarRecetaPorID(@PathVariable(name = "id") Integer id){
		try{
			receService.eliminarRecetaPorId(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
