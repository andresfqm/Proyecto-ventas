package com.quintana.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintana.app.model.Venta;
import com.quintana.app.repo.IVentaRepo;
import com.quintana.app.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo repo;

	@Override
	public Venta registrar(Venta obj) {
		obj.getDetalleVenta().forEach(det ->{
			det.setVenta(obj);
		});
		return repo.save(obj);
	}

	@Override
	public Venta modificar(Venta obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
