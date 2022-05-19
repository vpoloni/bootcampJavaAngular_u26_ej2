package com.cientificosProyectos.service;

import java.util.List;

import com.cientificosProyectos.dto.AsignadoA;

public interface IAsignadoAService {

	// READ todos asignados
	public List<AsignadoA> listarAsignadoA();

	// CREATE nuevo asignado
	public AsignadoA guardarAsignadoA(AsignadoA asignadoA);

	// READ asignado por id
	public AsignadoA listarAsignadoAXID(int id);

	// UPDATE asignado
	public AsignadoA actualizarAsignadoA(AsignadoA asignadoA);

	// DELETE asignado
	public void eliminarAsignadoA(int id);

}
