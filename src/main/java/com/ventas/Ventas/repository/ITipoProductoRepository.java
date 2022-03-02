package com.ventas.Ventas.repository;

import com.ventas.Ventas.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoProductoRepository extends JpaRepository<TipoProducto,Integer> {
}
