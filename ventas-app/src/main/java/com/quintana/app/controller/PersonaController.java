package com.quintana.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quintana.app.model.Persona;
import com.quintana.app.service.IPersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private IPersonaService service;

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Persona obj) {
		Persona per = service.registrar(obj);
		return new ResponseEntity<Object>(per, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Persona> modificar(@RequestBody Persona obj) {
		Persona per = service.modificar(obj);
		return new ResponseEntity<Persona>(per, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> ls = service.listar();
		return new ResponseEntity<List<Persona>>(ls, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) {
		Persona per = service.listarPorId(id);
		if (per.getIdPersona() == null) {
			System.out.println("Aqui se controla el evento null");
		}

		return new ResponseEntity<Persona>(per, HttpStatus.OK);
	}

}
