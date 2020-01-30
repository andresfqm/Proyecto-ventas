package com.quintana.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quintana.app.model.Persona;
import com.quintana.app.service.IPersonaService;

@RequestMapping("/persona")
@RestController
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Persona obj){
		Persona per = service.registrar(obj);
		return new ResponseEntity<Object>(per, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> ls = service.listar();
		return new ResponseEntity<List<Persona>>(ls, HttpStatus.OK);
	}

}
