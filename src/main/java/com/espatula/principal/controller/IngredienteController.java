package com.espatula.principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
