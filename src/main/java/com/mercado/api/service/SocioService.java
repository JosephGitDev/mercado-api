package com.mercado.api.service;

import com.mercado.api.entity.Socio;
import com.mercado.api.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> listarTodos() {
        return socioRepository.findAll();
    }

    public Optional<Socio> obtenerPorId(Long id) {
        return socioRepository.findById(id);
    }

    public Socio guardar(Socio socio) {
        return socioRepository.save(socio);
    }

    public Socio actualizar(Long id, Socio socioDetalles) {
        return socioRepository.findById(id).map(socio -> {
            socio.setNombre(socioDetalles.getNombre());
            socio.setDni(socioDetalles.getDni());
            socio.setTelefono(socioDetalles.getTelefono());
            socio.setEmail(socioDetalles.getEmail());
            return socioRepository.save(socio);
        }).orElseThrow(() -> new RuntimeException("Socio no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        socioRepository.deleteById(id);
    }
}