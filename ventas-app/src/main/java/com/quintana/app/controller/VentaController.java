package com.quintana.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quintana.app.model.Venta;
import com.quintana.app.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IVentaService service;
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Venta obj){
		Venta v = service.registrar(obj);
		return new ResponseEntity<Object>(v, HttpStatus.CREATED);
	}
}
