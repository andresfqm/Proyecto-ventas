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

import com.quintana.app.model.Producto;
import com.quintana.app.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Producto obj) {
		Producto pd = service.registrar(obj);
		return new ResponseEntity<Object>(pd, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Producto> modificar(@RequestBody Producto obj) {
		Producto pd = service.modificar(obj);
		return new ResponseEntity<Producto>(pd, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Producto>> listar() {
		List<Producto> ls = service.listar();
		return new ResponseEntity<List<Producto>>(ls, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) {
		Producto pd = service.listarPorId(id);

		if (pd.getIdProducto() == null) {
			System.out.println("Aqui controlar la exception");
		}

		return new ResponseEntity<Producto>(pd, HttpStatus.OK);
	}
}
