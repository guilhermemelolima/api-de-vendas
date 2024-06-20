package com.atividade.apidevendas.domain.produto;

import com.atividade.apidevendas.entities.Vendedor;
import com.atividade.apidevendas.enums.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Representa um produto no Sistema de Vendas
 *
 * A classe DTO (Data Transfer Object) contém apenas as
 * informações nescessárias para a transferencia de dados.
 * Ele é utilizado para reduzir a largura de banda necessária
 * para transferir dados e para melhorar o desempenho da API.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoDto {
    /*
    * Declaração de variáveis do Objeto.
    * */
    private Long id; // Identificador único do produto.
    private String nome; // Nome do produto.
    private String descricao; // Descrição do produto
    private Integer quantidadeEstoque; // Quantodade em estoque
    private Double valor; // Valor do produto
    private StatusProduto status;
}
