package com.atividade.apidevendas.entities;

import com.atividade.apidevendas.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Representa um pedido no sistema de vendas.
 *
 * A entidade Pedido armazena informações sobre um pedido, incluindo o cliente associado
 * e os itens do pedido.
 */
@Table(name = "pedido")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

    /**
     * Identificador único do pedido.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cliente que fez o pedido.
     * Relacionamento muitos-para-um com a entidade Cliente.
     */
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    /*
    * Data do pedido
    * */
    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

    /**
     * Status do Pedido
     */
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    /**
     * Lista de itens do pedido.
     * Relacionamento um-para-muitos com a entidade PedidoItens.
     * Os itens são removidos automaticamente quando o pedido é removido.
     */
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoItens> pedidoItensList;

    /**
     * Adiciona um item ao pedido.
     *
     * @param item Item a ser adicionado ao pedido.
     */
    public void addItens(PedidoItens item) {
        pedidoItensList.add(item);
        item.setPedido(this);
    }
}
