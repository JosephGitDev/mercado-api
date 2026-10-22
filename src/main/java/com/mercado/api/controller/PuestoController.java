package com.mercado.api.controller;

import com.mercado.api.entity.Puesto;
import com.mercado.api.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puestos")
@CrossOrigin(origins = "*")
public class PuestoController {

    @Autowired
    private PuestoService puestoService;

    // GET: Listar todos los puestos
    @GetMapping
    public List<Puesto> listarTodos() {
        return puestoService.listarTodos();
    }

    // GET: Buscar puesto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Puesto> obtenerPorId(@PathVariable Long id) {
        return puestoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Registrar un nuevo puesto
    @PostMapping
    public Puesto crear(@RequestBody Puesto puesto) {
        return puestoService.guardar(puesto);
    }

    // PUT: Actualizar un puesto
    @PutMapping("/{id}")
    public ResponseEntity<Puesto> actualizar(@PathVariable Long id, @RequestBody Puesto puesto) {
        try {
            return ResponseEntity.ok(puestoService.actualizar(id, puesto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Eliminar un puesto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        puestoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}