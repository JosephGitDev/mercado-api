package com.mercado.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "puesto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto")
    private Long idPuesto;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 50)
    private String sector;

    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio;
}