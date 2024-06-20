package com.atividade.apidevendas.entities;

import com.atividade.apidevendas.enums.StatusProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa um produto no sistema de vendas.
 *
 * A entidade Produto armazena informações essenciais sobre os produtos,
 * incluindo nome e valor.
 */
@Table(name = "produto")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {

    /**
     * Identificador único do produto.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do produto.
     * Não pode ser nulo e tem um limite máximo de 150 caracteres.
     */
    @Column(nullable = false, length = 150)
    private String nome;

    /*
    * Descrição do produto
    */
    @Column()
    private String descricao;

    /*
    * Quantidade em estoque
    * Não pode ser nulo
    */
    @Column(nullable = false)
    private Integer quantidadeEstoque;

    /**
     * Valor do produto.
     * Não pode ser nulo.
     */
    @Column(nullable = false)
    private Double valor;

    /**
     * Status de venda do produto
     */
    @Enumerated(EnumType.STRING)
    private StatusProduto status;
}
