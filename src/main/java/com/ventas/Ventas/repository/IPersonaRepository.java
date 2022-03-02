package com.ventas.Ventas.repository;

import com.ventas.Ventas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
}
