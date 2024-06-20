package com.atividade.apidevendas.domain.pedidoItens;

import com.atividade.apidevendas.entities.Pedido;
import com.atividade.apidevendas.entities.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItensDto {

    private Long id;
    private Pedido pedido;
    private Produto produto;
    private int quantidade;
}
