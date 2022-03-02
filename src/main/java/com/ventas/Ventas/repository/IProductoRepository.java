package com.ventas.Ventas.repository;

import com.ventas.Ventas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,Integer> {
}
