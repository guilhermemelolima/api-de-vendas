package com.atividade.apidevendas.domain.produto;

import com.atividade.apidevendas.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* É a camada da aplicação responsável por executar a lógica
* de negócios e encapsular a funcionalidade da aplicação.
* */
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    // Lista todos os Produtos
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
    // Retorna produto pelo Id
    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }
    // Retorna produtos pelo Nome
    public List<Produto> buscarProdutosPorNome(String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    // Salva produto
    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }
    // Atualiza produto
    public Produto atualizarProduto(Long id, Produto produto){
        Produto produtoCadastrado = buscarProdutoPorId(id);
        if(produtoCadastrado == null){
            return null;
        }
        else{
            produtoCadastrado.setNome(produto.getNome());
            produtoCadastrado.setValor(produto.getValor());
            return produtoRepository.save(produtoCadastrado);
        }
    }
    // Deletar produto
    public void excluirProduto(Long id){
        if(buscarProdutoPorId(id) != null){
            produtoRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Produto informado não encontrado");
        }
    }



}
