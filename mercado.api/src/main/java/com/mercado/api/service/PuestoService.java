package com.mercado.api.service;

import com.mercado.api.entity.Puesto;
import com.mercado.api.repository.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoService {

    @Autowired
    private PuestoRepository puestoRepository;

    public List<Puesto> listarTodos() {
        return puestoRepository.findAll();
    }

    public Optional<Puesto> obtenerPorId(Long id) {
        return puestoRepository.findById(id);
    }

    public Puesto guardar(Puesto puesto) {
        return puestoRepository.save(puesto);
    }

    public Puesto actualizar(Long id, Puesto puestoDetalles) {
        return puestoRepository.findById(id).map(puesto -> {
            puesto.setCodigo(puestoDetalles.getCodigo());
            puesto.setSector(puestoDetalles.getSector());
            puesto.setSocio(puestoDetalles.getSocio());
            return puestoRepository.save(puesto);
        }).orElseThrow(() -> new RuntimeException("Puesto no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        puestoRepository.deleteById(id);
    }
}