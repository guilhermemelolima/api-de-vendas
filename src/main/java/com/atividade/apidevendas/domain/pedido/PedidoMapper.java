package com.atividade.apidevendas.domain.pedido;

import com.atividade.apidevendas.entities.Pedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoDto toDto(Pedido entity){
        PedidoDto dto = new PedidoDto();

        dto.setId(entity.getId());
        dto.setCliente(entity.getCliente());
        dto.setData(entity.getData());
        dto.setVendedor(entity.getVendedor());
        dto.setStatus(entity.getStatus());
        dto.setPedidoItensList(entity.getPedidoItensList());

        return dto;
    }

    public static Pedido toEntity(PedidoDto dto){
        Pedido entity = new Pedido();

        entity.setId(dto.getId());
        entity.setCliente(dto.getCliente());
        entity.setData(dto.getData());
        entity.setVendedor(dto.getVendedor());
        entity.setStatus(dto.getStatus());
        entity.setPedidoItensList(dto.getPedidoItensList());

        return entity;
    }

    public static List<PedidoDto> toDtoList(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoMapper::toDto).collect(Collectors.toList());
    }

}
