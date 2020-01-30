package com.quintana.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintana.app.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
