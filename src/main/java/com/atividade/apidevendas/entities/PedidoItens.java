package com.atividade.apidevendas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa os itens de um pedido no sistema de vendas.
 *
 * A entidade PedidoItens armazena informações sobre os produtos incluídos em um pedido,
 * incluindo a quantidade de cada produto.
 */
@Table(name = "pedido_itens")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoItens {

    /**
     * Identificador único do item do pedido.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Pedido ao qual este item pertence.
     * Relacionamento muitos-para-um com a entidade Pedido.
     * Ignorado na serialização JSON para evitar referências circulares.
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    /**
     * Produto incluído no pedido.
     * Relacionamento muitos-para-um com a entidade Produto.
     */
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    /**
     * Quantidade do produto no pedido.
     * Não pode ser nulo.
     */
    @Column(nullable = false)
    private int quantidade;
}
