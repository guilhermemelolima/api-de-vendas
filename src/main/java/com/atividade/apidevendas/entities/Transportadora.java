package com.atividade.apidevendas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* Representa uma transportadora no sistema de vendas.
*
* A entidade Transportadora armazena informações essenciais sobre as transportadoras
* incluindo nome e telefone
* */
@Table(name = "transportadora")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transportadora {

    /*
    * Identificador único da Transportadora.
    * Gerado automaticamente pelo banco de dados.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    * Nome da transportadora.
    * Não pode ser nulo e tem um limite máximo de 150 caracteres.
    */
    @Column(nullable = false, length = 150)
    private String nome;

    /*
    * Telefone da transportadora.
    * Não pode ser nulo e tem um limite máximo de 150 caracteres
    */
    @Column(nullable = false, length = 11)
    private String telefone;
}
