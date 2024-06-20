package com.atividade.apidevendas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vendedor")
@Getter
@Setter
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do cliente.
     * Não pode ser nulo e tem um limite máximo de 150 caracteres.
     */
    @Column(nullable = false, length = 150)
    private String nome;

    /**
     * Email do vendedor.
     * Não pode ser nulo e tem um limite máximo de 50 caracteres.
     */
    @Column(nullable = false, length = 50)
    private String email;
}
