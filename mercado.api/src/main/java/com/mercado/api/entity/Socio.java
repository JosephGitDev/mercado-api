package com.mercado.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "socio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Long idSocio;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 15)
    private String dni;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;
}