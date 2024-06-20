package com.atividade.apidevendas.domain.cliente;

import java.util.List;
import java.util.stream.Collectors;

import com.atividade.apidevendas.entities.Cliente;

public class ClienteMapper {
    public static Cliente toEntity(ClienteDto dto){
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCep(dto.getCep());
        cliente.setNumero(dto.getNumero());
        return cliente;
    }
    public static ClienteDto toDto(Cliente cliente){
        ClienteDto dto = new ClienteDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setCep(cliente.getCep());
        dto.setNumero(cliente.getNumero());
        return dto;
    }

    public static List<ClienteDto> toDTOList(List<Cliente> clientes){
        return clientes.stream().map(ClienteMapper::toDto).collect(Collectors.toList());
    }
}
