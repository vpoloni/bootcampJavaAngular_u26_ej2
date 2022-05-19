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

import com.cientificosProyectos.dto.Cientifico;
import com.cientificosProyectos.service.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificoController {
	@Autowired
	CientificoServiceImpl cientificoServiceImpl;

	@GetMapping("/cientificos")
	public List<Cientifico> listarCientificos() {
		return cientificoServiceImpl.listarCientificos();
	}

	@PostMapping("/cientificos")
	public Cientifico crearCientifico(@RequestBody Cientifico cientifico) {

		return cientificoServiceImpl.guardarCientifico(cientifico);
	}

	@GetMapping("/cientificos/{id}") 
	public Cientifico listarCientificoXID(@PathVariable(name = "id") String id) {

		Cientifico cientificoPorId = new Cientifico();
		cientificoPorId = cientificoServiceImpl.listarCientificoXID(id);

		return cientificoPorId;
	}

	@PutMapping("/cientificos/{id}") 
	public Cientifico actualizarCientifico(@PathVariable(name = "id") String id, @RequestBody Cientifico cientifico) {
		Cientifico cientificoSeleccionado = new Cientifico();
		Cientifico cientificoActualizado = new Cientifico();

		// obtenemos cientifico de la DB
		cientificoSeleccionado = cientificoServiceImpl.listarCientificoXID(id);

		// seteamos nuevos valores
		cientificoSeleccionado.setId(cientifico.getId());
		cientificoSeleccionado.setNombre(cientifico.getNombre());

		// actualizamos cientifico en la DB
		cientificoActualizado = cientificoServiceImpl.actualizarCientifico(cientificoSeleccionado);

		return cientificoActualizado;
	}

	@DeleteMapping("/cientificos/{id}") 
	public void eliminarCientifico(@PathVariable(name = "id") String dni) {
		cientificoServiceImpl.eliminarCientifico(dni);
	}

}
