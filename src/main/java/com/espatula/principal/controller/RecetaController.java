package com.espatula.principal.controller;

import java.util.Date;
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

import com.espatula.principal.dto.IngredienteCantidadDTO;
import com.espatula.principal.dto.RecetaDTO;
import com.espatula.principal.dto.RecetaEditDTO;
import com.espatula.principal.model.Ingrediente;
import com.espatula.principal.model.Receta;
import com.espatula.principal.security.model.Usuario;
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
	public ResponseEntity<?> insertarReceta(@RequestBody RecetaDTO recetaDTO, BindingResult bindingResult){
		if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Receta recetaNueva = new Receta(recetaDTO.getNombre(), recetaDTO.getDuracion(), recetaDTO.getTipo(), recetaDTO.getOrigen(),
				recetaDTO.getInstrucciones(), recetaDTO.getDificultad(), recetaDTO.getUrlImagen());
		Usuario usuarioReceta = recetaDTO.getUsuario();
		usuarioReceta.getRecetas().add(recetaNueva);
		recetaNueva.setUsuario(usuarioReceta);
		receService.insertarReceta(recetaNueva);
		for (int i = 0; i < recetaDTO.getIngredientes().size(); i++) {
			Ingrediente ingre = recetaDTO.getIngredientes().get(i).getIngrediente();
			int cantidad = recetaDTO.getIngredientes().get(i).getCantidad();
			String medida = recetaDTO.getIngredientes().get(i).getUnidadMedida();
			recetaNueva.addIngrediente(ingre, cantidad, medida);
		}
		receService.insertarReceta(recetaNueva);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Se ha actualizado la receta")
	})
	public ResponseEntity<?> actualizarReceta(@PathVariable(name = "id") Integer idRecetaAntigua, @RequestBody RecetaEditDTO recetaDTO, BindingResult bindingResult){
		if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Receta recetaAntigua = receService.obtenerRecetaPorId(idRecetaAntigua); 
		recetaAntigua.removeIngredientes();
		recetaAntigua.setNombre(recetaDTO.getNombre());
		recetaAntigua.setDuracion(recetaDTO.getDuracion());
		recetaAntigua.setFecha(new Date());
		recetaAntigua.setInstrucciones(recetaDTO.getInstrucciones());
		recetaAntigua.setOrigen(recetaDTO.getOrigen());
		recetaAntigua.setTipo(recetaDTO.getTipo());
		recetaAntigua.setValoracion(recetaDTO.getValoracion());
		recetaAntigua.setDificultad(recetaDTO.getDificultad());
		recetaAntigua.setUrlImagen(recetaDTO.getUrlImagen());
		recetaAntigua.setComentarios(recetaDTO.getComentarios());

		for (int i = 0; i < recetaDTO.getIngredientes().size(); i++) {
			Ingrediente ingre = recetaDTO.getIngredientes().get(i).getIngrediente();
			int cantidad = recetaDTO.getIngredientes().get(i).getCantidad();
			String medida = recetaDTO.getIngredientes().get(i).getUnidadMedida();
			recetaAntigua.addIngrediente(ingre, cantidad, medida);
		}
		
		receService.insertarReceta(recetaAntigua);
		return new ResponseEntity<>(HttpStatus.CREATED);
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
