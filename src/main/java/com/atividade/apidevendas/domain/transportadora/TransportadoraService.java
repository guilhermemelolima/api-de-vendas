package com.atividade.apidevendas.domain.transportadora;

import com.atividade.apidevendas.domain.cliente.ClienteRepository;
import com.atividade.apidevendas.entities.Transportadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportadoraService {
    @Autowired
    private TransportadoraRepository transportadoraRepository;

    public List<Transportadora> listarTransportadoras(){
        return transportadoraRepository.findAll();
    }

    public Transportadora buscarTransportadoraPorId(Long id){
        return transportadoraRepository.findById(id).orElse(null);
    }

    public Transportadora salvarTransportadora(Transportadora transportadora){
        return transportadoraRepository.save(transportadora);
    }

    public Transportadora atualizarTransportadora(Long id, Transportadora transportadora){
        Transportadora transportadoraCadastrado = buscarTransportadoraPorId(id);
        if(transportadoraCadastrado == null){
            return null;
        }
        else{
            transportadoraCadastrado.setNome(transportadora.getNome());
            transportadoraCadastrado.setEmail(transportadora.getEmail());
            transportadoraCadastrado.setCep(transportadora.getCep());
            return transportadoraRepository.save(transportadoraCadastrado);
        }
    }

    public void excluirTransportadora(Long id){
        if(buscarTransportadoraPorId(id) != null){
            transportadoraRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Transportadora informada não encontrada");
        }
    }
}
