package com.ventas.Ventas.service;

import com.ventas.Ventas.model.Persona;
import com.ventas.Ventas.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements ICRUDService<Persona> {

    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> findById(Integer id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }
}
