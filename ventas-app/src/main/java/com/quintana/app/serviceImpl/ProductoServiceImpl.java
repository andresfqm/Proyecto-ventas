package com.quintana.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintana.app.model.Producto;
import com.quintana.app.repo.IProductoRepo;
import com.quintana.app.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo repo;

	@Override
	public Producto registrar(Producto obj) {
		return repo.save(obj);
	}

	@Override
	public Producto modificar(Producto obj) {
		return repo.save(obj);
	}

	@Override
	public List<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto listarPorId(Integer id) {
		Optional<Producto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Producto();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
