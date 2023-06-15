package com.espatula.principal.dto;

import com.espatula.principal.model.Ingrediente;

public class IngredienteCantidadDTO {

	private Ingrediente ingrediente;
	
	private int cantidad;
	
	private String unidadMedida;
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
}
