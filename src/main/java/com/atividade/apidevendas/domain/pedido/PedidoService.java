package com.atividade.apidevendas.domain.pedido;

import com.atividade.apidevendas.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public List<Pedido> listarTodos(){ return repository.findAll(); }

    public List<Pedido> listarPorData(LocalDate startDate, LocalDate endDate) {
        return repository.findByData(startDate, endDate);
    }

    public Pedido buscarPorId(Long id){ return repository.findById(id).orElse(null); }

    public Pedido salvar(Pedido pedido){ return repository.save(pedido); }

    public void delete(Long id){
        if( buscarPorId(id) != null){
            repository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Pedido informado não encontrado");
        }
    }

    public Pedido atualizar(Pedido pedido){
        if(buscarPorId(pedido.getId()) != null){
            return repository.save(pedido);
        }else{
            throw new IllegalArgumentException("Pedido informado não encontrado");
        }
    }

}
