package com.mercado.api.repository;

import com.mercado.api.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuestoRepository extends JpaRepository<Puesto, Long> {
}