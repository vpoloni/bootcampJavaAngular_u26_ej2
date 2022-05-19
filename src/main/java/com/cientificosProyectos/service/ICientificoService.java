package com.cientificosProyectos.service;

import java.util.List;

import com.cientificosProyectos.dto.Cientifico;

public interface ICientificoService {

	// READ todos cientificos
	public List<Cientifico> listarCientificos();

	// CREATE nuevo cientifico
	public Cientifico guardarCientifico(Cientifico cientifico);

	// READ cientifico por id
	public Cientifico listarCientificoXID(String id);

	// UPDATE cientifico
	public Cientifico actualizarCientifico(Cientifico cientifico);

	// DELETE cientifico
	public void eliminarCientifico(String id);

}
