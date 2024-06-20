package com.atividade.apidevendas.domain.produto;

import com.atividade.apidevendas.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* O repository é utilizado para gerenciar a persistencia
* e recuperação de dados em um banco de dados.
* Ele fornece uma camada abstrata sobre o banco de dados
* e simplifica a interaçõa com ele.
* */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // encontra produtos pelo nome.
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
