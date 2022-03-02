package com.ventas.Ventas.repository;

import com.ventas.Ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta,Integer> {
}
