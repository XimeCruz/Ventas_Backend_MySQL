package com.ventas.Ventas.service;

import com.ventas.Ventas.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<T> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    T create(T model);

    T update(T model);

    void delete(Integer id);
}
