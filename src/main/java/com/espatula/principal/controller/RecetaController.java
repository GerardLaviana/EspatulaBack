package com.espatula.principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
