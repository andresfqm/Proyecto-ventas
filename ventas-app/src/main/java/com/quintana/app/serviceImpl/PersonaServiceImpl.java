package com.quintana.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintana.app.model.Persona;
import com.quintana.app.repo.IPersonaRepo;
import com.quintana.app.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo repo;

	@Override
	public Persona registrar(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public Persona modificar(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public List<Persona> listar() {
		return repo.findAll();
	}

	@Override
	public Persona listarPorId(Integer id) {
		Optional<Persona> pr = repo.findById(id);
		return pr.isPresent() ? pr.get() : new Persona();
		
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
