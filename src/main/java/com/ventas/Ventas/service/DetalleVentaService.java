package com.ventas.Ventas.service;

import com.ventas.Ventas.model.DetalleVenta;
import com.ventas.Ventas.repository.IDetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService implements ICRUDService<DetalleVenta> {

    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;


    @Override
    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Optional<DetalleVenta> findById(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta create(DetalleVenta model) {
        return detalleVentaRepository.save(model);
    }

    @Override
    public DetalleVenta update(DetalleVenta model) {
        return detalleVentaRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}
