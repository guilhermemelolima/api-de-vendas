package com.atividade.apidevendas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa um cliente no sistema de vendas.
 *
 * A entidade Cliente armazena informações essenciais sobre os clientes,
 * incluindo nome, email, CEP e número de residência.
 */
@Table(name = "cliente")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

    /**
     * Identificador único do cliente.
     * Gerado automaticamente pelo banco de dados.
     */
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
     * Email do cliente.
     * Não pode ser nulo e tem um limite máximo de 50 caracteres.
     */
    @Column(nullable = false, length = 50)
    private String email;

    /**
     * Código de Endereçamento Postal (CEP) do cliente.
     * Não pode ser nulo e tem um limite máximo de 9 caracteres.
     */
    @Column(nullable = false, length = 9)
    private String cep;

    /**
     * Número da residência do cliente.
     * Não pode ser nulo e tem um limite máximo de 6 caracteres.
     */
    @Column(nullable = false, length = 6)
    private String numero;
}
