package com.ventas.Ventas.repository;

import com.ventas.Ventas.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
}
