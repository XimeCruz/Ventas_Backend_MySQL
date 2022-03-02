package com.ventas.Ventas.service;

import com.ventas.Ventas.model.Venta;
import com.ventas.Ventas.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements ICRUDService<Venta>{

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> findById(Integer id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta create(Venta model) {
        return ventaRepository.save(model);
    }

    @Override
    public Venta update(Venta model) {
        return ventaRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        ventaRepository.deleteById(id);
    }
}
