package com.ventas.Ventas.repository;

import com.ventas.Ventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente,Integer> {
}
