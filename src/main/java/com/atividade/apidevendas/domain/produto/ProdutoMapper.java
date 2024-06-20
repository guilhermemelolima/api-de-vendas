package com.atividade.apidevendas.domain.produto;

import com.atividade.apidevendas.entities.Produto;

import java.util.List;
import java.util.stream.Collectors;

/*
* A classe Mapper é utilizada para conversão
* de dados entre o Objeto Entidade de Produto e o
* Objeto de Transferencia de Dados (DTO) de Produto
* e vice-versa
* */
public class ProdutoMapper {
    // Converte dados da DTO para a Entidade de Produto
    public static Produto toEntity(ProdutoDto dto){
        Produto entity = new Produto();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        entity.setStatus(dto.getStatus());
        entity.setValor(dto.getValor());

        return entity;
    }
    // Converte dados da Entidade para a DTO de Produto
    public static ProdutoDto toDto(Produto entity){
        ProdutoDto dto = new ProdutoDto();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setQuantidadeEstoque(entity.getQuantidadeEstoque());
        dto.setStatus(entity.getStatus());
        dto.setValor(entity.getValor());

        return dto;
    }
    // Retorna ProdutosDTO em forma de Lista
    public static List<ProdutoDto> toDTOList(List<Produto> produtos){
        return produtos.stream().map(ProdutoMapper::toDto).collect(Collectors.toList());
    }
}
