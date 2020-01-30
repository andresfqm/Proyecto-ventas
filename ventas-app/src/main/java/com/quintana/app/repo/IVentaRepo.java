package com.quintana.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintana.app.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer>{

}
