package com.atividade.apidevendas.domain.cliente;

import java.util.List;
import java.util.Optional;

import com.atividade.apidevendas.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;

import com.atividade.apidevendas.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
     @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }
    
    public List<Cliente> buscarClientesPorNome(String nome){ return clienteRepository.findByName(nome); }

    public List<Pedido> buscarPedidosPeloClienteId(Long id){
        return clienteRepository.buscarPedidosPeloClienteId(id);
    }

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public Cliente atualizarCliente(Long id, Cliente cliente){
        Cliente clienteCadastrado = buscarClientePorId(id);
        if(clienteCadastrado == null){
            return null;
        }
        else{
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setEmail(cliente.getEmail());
            clienteCadastrado.setCep(cliente.getCep());
            clienteCadastrado.setNumero(cliente.getNumero());
            return clienteRepository.save(clienteCadastrado);
        }
    }
    
    public void excluirCliente(Long id){
        if(buscarClientePorId(id) != null){
            clienteRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Cliente informado não encontrado");
        }
    }
}
