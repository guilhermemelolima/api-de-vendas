package com.atividade.apidevendas.domain.vendedor;

import com.atividade.apidevendas.entities.Vendedor;

import java.util.List;
import java.util.stream.Collectors;

public class VendedorMapper {

    public static Vendedor toEntity(VendedorDto dto){
        Vendedor entity = new Vendedor();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    public static VendedorDto toDto(Vendedor entity){
        VendedorDto dto = new VendedorDto();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());

        return dto;
    }

    public static List<VendedorDto> toDtoList(List<Vendedor> vendedores){
        return vendedores.stream().map(VendedorMapper::toDto).collect(Collectors.toList());
    }

}
