package com.espatula.principal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espatula.principal.model.Ingrediente;
import com.espatula.principal.model.Receta;
import com.espatula.principal.model.Usuario;
import com.espatula.principal.service.IngredienteService;
import com.espatula.principal.service.RecetaService;
import com.espatula.principal.service.UsuarioService;

@RestController
public class WebApplicationController {

	@Autowired
	private RecetaService receService;
	
	@Autowired
	private IngredienteService ingreService;
	
	@Autowired
	private UsuarioService usuService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	String inicio() {
		//crearTablas();
		return "<h1>Bienvenido a la Espátula</h1>";
	}
	
	public void crearTablas() {
		
		Receta primeraReceta = new Receta("Tortilla Española",5f,15,"Comida","España", "Aqui se explica como facelo","Media");
		Receta segundaReceta = new Receta("Sándwich mixto",4.5f,5,"Cena","Inglaterra", "Aqui se explica como facelo","Fácil");
		Receta terceraReceta = new Receta("Tarta de Santiago",3.5f,60,"Postre","España", "Aqui se explica como facelo","Dificíl");
		
		Ingrediente pan = new Ingrediente("Pan de molde", "Cereal", true);
		Ingrediente jamon = new Ingrediente("Jamon", "Carne", false);
		Ingrediente queso = new Ingrediente("Queso", "Lacteo", false);
		Ingrediente huevo = new Ingrediente("Huevo", "Producto Animal", false);
		Ingrediente patata = new Ingrediente("Patata", "Verdura", false);
		Ingrediente almendra = new Ingrediente("Almendra", "Fruto Seco", false);
		Ingrediente mantequilla = new Ingrediente("Mantequilla", "Lacteo", false);
		Ingrediente azucar = new Ingrediente("Azucar", "Azucar", false);
		Ingrediente limon = new Ingrediente("Limon", "Fruta", false);
		
		Usuario usuario1 = new Usuario("Isabel","1234", "ejemplo@gmail.com");
		Usuario usuario2 = new Usuario("Manolo","1234", "manolo@gmail.com");
		Usuario usuario3 = new Usuario("Juan","1234", "juan@gmail.com");

		usuario1.getRecetas().add(primeraReceta);
		primeraReceta.setUsuario(usuario1);

		usuario2.getRecetas().add(terceraReceta);
		terceraReceta.setUsuario(usuario2);

		usuario2.getRecetas().add(segundaReceta);
		segundaReceta.setUsuario(usuario2);

		usuService.insertarUsuario(usuario1);
		usuService.insertarUsuario(usuario2);
		
		
		ingreService.insertarIngrediente(pan);
		ingreService.insertarIngrediente(jamon);
		ingreService.insertarIngrediente(queso);
		ingreService.insertarIngrediente(huevo);
		ingreService.insertarIngrediente(patata);
		ingreService.insertarIngrediente(almendra);
		ingreService.insertarIngrediente(mantequilla);
		ingreService.insertarIngrediente(azucar);
		ingreService.insertarIngrediente(limon);
		
		receService.insertarReceta(primeraReceta);
		receService.insertarReceta(segundaReceta);
		receService.insertarReceta(terceraReceta);
		
		primeraReceta.addIngrediente(huevo, 1);
		primeraReceta.addIngrediente(patata, 3);

		segundaReceta.addIngrediente(pan, 5);
		segundaReceta.addIngrediente(jamon, 3);
		segundaReceta.addIngrediente(queso, 3);

		terceraReceta.addIngrediente(huevo, 2);
		terceraReceta.addIngrediente(almendra, 14);
		terceraReceta.addIngrediente(mantequilla, 50);
		terceraReceta.addIngrediente(azucar, 200);
		terceraReceta.addIngrediente(limon, 2);
		usuService.insertarUsuario(usuario3);
		
		/*
		userServiceImpl.insertarUsuario(usuario1);
		userServiceImpl.insertarUsuario(usuario2);
		userServiceImpl.insertarUsuario(usuario3);

		receServiceImpl.insertarReceta(primeraReceta);
		receServiceImpl.insertarReceta(segundaReceta);
		receServiceImpl.insertarReceta(terceraReceta);

		ingreServiceImpl.insertarIngrediente(pan);
		ingreServiceImpl.insertarIngrediente(jamon);
		ingreServiceImpl.insertarIngrediente(queso);
		ingreServiceImpl.insertarIngrediente(huevo);
		ingreServiceImpl.insertarIngrediente(patata);
		ingreServiceImpl.insertarIngrediente(almendra);
		ingreServiceImpl.insertarIngrediente(mantequilla);
		ingreServiceImpl.insertarIngrediente(azucar);
		ingreServiceImpl.insertarIngrediente(limon);
		 */
	}
	
}