package com.atividade.apidevendas.domain.pedido;

import com.atividade.apidevendas.entities.Cliente;
import com.atividade.apidevendas.entities.PedidoItens;
import com.atividade.apidevendas.entities.Vendedor;
import com.atividade.apidevendas.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PedidoDto{

    private Long id;
    private Cliente cliente;
    private LocalDate data;
    private StatusPedido status;
    private Vendedor vendedor;
    private List<PedidoItens> pedidoItensList;

}

