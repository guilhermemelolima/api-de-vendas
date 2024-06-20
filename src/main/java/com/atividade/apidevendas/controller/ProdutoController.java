package com.atividade.apidevendas.controller;

import com.atividade.apidevendas.domain.produto.ProdutoDto;
import com.atividade.apidevendas.domain.produto.ProdutoMapper;
import com.atividade.apidevendas.domain.produto.ProdutoService;
import com.atividade.apidevendas.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Controller de Produtos da API
* É responsável por lidar com solicitações HTTP
* recebidas e retornar uma resposta apropriada. Eles atuam
* como intermediarios entre o cliente e a lógica da API
* */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // API retorna todos os produtos
    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listarProdutos() {
        List<ProdutoDto> produtos = ProdutoMapper.toDTOList(produtoService.listarProdutos());
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    // API retorna produto pelo id informado
    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<ProdutoDto> buscarProdutoPorId(@PathVariable long id) {
        ProdutoDto produto = ProdutoMapper.toDto(produtoService.buscarProdutoPorId(id));
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    // API retorna produtos pelo Nome
    @GetMapping("/buscarPorNome/{nome}")
    public ResponseEntity<List<ProdutoDto>> buscarProdutoPorNome(@PathVariable String nome) {
        List<ProdutoDto> produtos = ProdutoMapper.toDTOList(produtoService.buscarProdutosPorNome(nome));
        return produtos != null ? new ResponseEntity<>(produtos, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Criar Produto
    @PostMapping
    public ResponseEntity<ProdutoDto> adicionarProduto(@RequestBody ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.toEntity(produtoDto);
        ProdutoDto produtoSalvo = ProdutoMapper.toDto(produtoService.salvarProduto(produto));
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }
    // Atualizar Produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable long id, @RequestBody ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.toEntity(produtoDto);
        ProdutoDto produtoAtualizado = ProdutoMapper.toDto(produtoService.atualizarProduto(id, produto));
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }
    //Deletar Produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable long id) {
        produtoService.excluirProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
