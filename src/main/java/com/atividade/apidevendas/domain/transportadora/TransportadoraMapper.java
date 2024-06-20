package com.atividade.apidevendas.domain.transportadora;

import java.util.List;
import java.util.stream.Collectors;
import com.atividade.apidevendas.entities.Transportadora;

public class TransportadoraMapper {
    public static Transportadora toEntity(TransportadoraDto dto){
        Transportadora transportadora = new Transportadora();
        transportadora.setId(dto.getId());
        transportadora.setNome(dto.getNome());
        transportadora.setTelefone(dto.getTelefone());
        return transportadora;
    }
    public static TransportadoraDto toDto(Transportadora transportadora){
        TransportadoraDto dto = new TransportadoraDto();
        dto.setId(transportadora.getId());
        dto.setNome(transportadora.getNome());
        dto.setTelefone(transportadora.getTelefone());
        return dto;
    }

    public static List<TransportadoraDto> toDTOList(List<Transportadora> transportadoras){
        return transportadoras.stream().map(TransportadoraMapper::toDto).collect(Collectors.toList());
    }
}