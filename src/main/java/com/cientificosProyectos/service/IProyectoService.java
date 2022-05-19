package com.cientificosProyectos.service;

import java.util.List;

import com.cientificosProyectos.dto.Proyecto;

public interface IProyectoService {
	
	// READ todos proyectos
	public List<Proyecto> listarProyectos();

	// CREATE nuevo proyecto
	public Proyecto guardarProyecto(Proyecto proyecto);

	// READ proyecto por id
	public Proyecto listarProyectoXID(String id);

	// UPDATE proyecto
	public Proyecto actualizarProyecto(Proyecto proyecto);

	// DELETE proyecto
	public void eliminarProyecto(String id);

}
