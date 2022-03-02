package com.ventas.Ventas.service;

import com.ventas.Ventas.model.TipoProducto;
import com.ventas.Ventas.repository.ITipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TipoProductoService implements ICRUDService<TipoProducto>{

    @Autowired
    private ITipoProductoRepository tipoProductoRepository;

    @Override
    public List<TipoProducto> findAll() {
        return tipoProductoRepository.findAll();
    }

    @Override
    public Optional<TipoProducto> findById(Integer id) {
        return tipoProductoRepository.findById(id);
    }

    @Override
    public TipoProducto create(TipoProducto model) {
        return tipoProductoRepository.save(model);
    }

    @Override
    public TipoProducto update(TipoProducto model) {
        return tipoProductoRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        tipoProductoRepository.deleteById(id);
    }
}
