package com.cientificosProyectos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cientificosProyectos.dto.Proyecto;
import com.cientificosProyectos.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;

	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos() {
		return proyectoServiceImpl.listarProyectos();
	}

	@PostMapping("/proyectos")
	public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {

		return proyectoServiceImpl.guardarProyecto(proyecto);
	}

	@GetMapping("/proyectos/{id}")
	public Proyecto listarProyectoXID(@PathVariable(name = "id") String id) {

		Proyecto proyectoPorId = new Proyecto();
		proyectoPorId = proyectoServiceImpl.listarProyectoXID(id);

		return proyectoPorId;
	}

	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name = "id") String id, @RequestBody Proyecto proyecto) {
		Proyecto proyectoSeleccionado = new Proyecto();
		Proyecto proyectoActualizado = new Proyecto();

		// obtenemos proyecto de la DB
		proyectoSeleccionado = proyectoServiceImpl.listarProyectoXID(id);

		// seteamos nuevos valores
		proyectoSeleccionado.setId(proyecto.getId());
		proyectoSeleccionado.setNombre(proyecto.getNombre());
		proyectoSeleccionado.setHoras(proyecto.getHoras());

		// actualizamos proyecto en la DB
		proyectoActualizado = proyectoServiceImpl.actualizarProyecto(proyectoSeleccionado);

		return proyectoActualizado;
	}

	@DeleteMapping("/proyectos/{id}")
	public void eliminarProyecto(@PathVariable(name = "id") String id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}

}
