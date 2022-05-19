
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
import com.cientificosProyectos.dto.AsignadoA;
import com.cientificosProyectos.service.AsignadoAServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoAController {
	@Autowired
	AsignadoAServiceImpl asignadoAServiceImpl;

	@GetMapping("/asignado")
	public List<AsignadoA> listarAsignadoAs() {
		return asignadoAServiceImpl.listarAsignadoA();
	}

	@PostMapping("/asignado")
	public AsignadoA crearAsignadoA(@RequestBody AsignadoA asignadoA) {

		return asignadoAServiceImpl.guardarAsignadoA(asignadoA);
	}

	@GetMapping("/asignado/{id}")
	public AsignadoA listarAsignadoAXID(@PathVariable(name = "id") int id) {

		AsignadoA asignadoAPorId = new AsignadoA();
		asignadoAPorId = asignadoAServiceImpl.listarAsignadoAXID(id);

		return asignadoAPorId;
	}

	@PutMapping("/asignado/{id}")
	public AsignadoA actualizarAsignadoA(@PathVariable(name = "id") int id, @RequestBody AsignadoA asignadoA) {
		AsignadoA asignadoASeleccionado = new AsignadoA();
		AsignadoA asignadoAActualizado = new AsignadoA();

		// obtenemos asignadoA de la DB
		asignadoASeleccionado = asignadoAServiceImpl.listarAsignadoAXID(id);

		// seteamos nuevos valores
		asignadoASeleccionado.setCientifico(asignadoA.getCientifico());
		asignadoASeleccionado.setProyecto(asignadoA.getProyecto());

		// actualizamos asignadoA en la DB
		asignadoAActualizado = asignadoAServiceImpl.actualizarAsignadoA(asignadoASeleccionado);

		return asignadoAActualizado;
	}

	@DeleteMapping("/asignado/{id}")
	public void eleiminarAsignadoA(@PathVariable(name = "id") int id) {
		asignadoAServiceImpl.eliminarAsignadoA(id);
	}

}
