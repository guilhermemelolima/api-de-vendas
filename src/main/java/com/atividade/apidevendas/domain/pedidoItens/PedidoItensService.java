package com.atividade.apidevendas.domain.pedidoItens;

import com.atividade.apidevendas.entities.Pedido;
import com.atividade.apidevendas.entities.PedidoItens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoItensService {

    @Autowired
    PedidoItensRepository repository;

    public List<PedidoItens> listarTodos(){ return repository.findAll(); }

    public PedidoItens buscarPorId(Long id){ return repository.findById(id).orElse(null); }

    public PedidoItens salvar(PedidoItens pedidoItens){ return repository.save(pedidoItens); }

    public void delete(Long id){
        if( buscarPorId(id) != null){
            repository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Pedido informado não encontrado");
        }
    }

    public PedidoItens atualizar(PedidoItens pedidoItens){
        if(buscarPorId(pedidoItens.getId()) != null){
            return repository.save(pedidoItens);
        }else{
            throw new IllegalArgumentException("Pedido informado não encontrado");
        }
    }
}
