package com.ventas.Ventas.service;

import com.ventas.Ventas.model.Producto;
import com.ventas.Ventas.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements ICRUDService<Producto>{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto create(Producto model) {
        return productoRepository.save(model);
    }

    @Override
    public Producto update(Producto model) {
        return productoRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }
}
