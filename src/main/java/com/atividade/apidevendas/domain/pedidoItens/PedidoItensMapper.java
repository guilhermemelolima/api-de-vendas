package com.atividade.apidevendas.domain.pedidoItens;

import com.atividade.apidevendas.domain.pedido.PedidoDto;
import com.atividade.apidevendas.domain.pedido.PedidoMapper;
import com.atividade.apidevendas.entities.Pedido;
import com.atividade.apidevendas.entities.PedidoItens;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoItensMapper {

    public static PedidoItensDto toDto(PedidoItens pedidoItens){
        PedidoItensDto dto = new PedidoItensDto();

        dto.setId(pedidoItens.getId());
        dto.setPedido(pedidoItens.getPedido());
        dto.setProduto(pedidoItens.getProduto());
        dto.setQuantidade(pedidoItens.getQuantidade());

        return dto;
    }

    public static PedidoItens toEntity(PedidoItensDto dto){
        PedidoItens entity = new PedidoItens();

        entity.setId(dto.getId());
        entity.setPedido(dto.getPedido());
        entity.setProduto(dto.getProduto());
        entity.setQuantidade(dto.getQuantidade());

        return entity;
    }

    public static List<PedidoItensDto> toDTOList(List<PedidoItens> pedidosItens) {
        return pedidosItens.stream().map(PedidoItensMapper::toDto).collect(Collectors.toList());
    }
}
