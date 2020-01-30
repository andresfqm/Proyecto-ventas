package com.quintana.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintana.app.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}
