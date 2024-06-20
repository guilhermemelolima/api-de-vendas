package com.atividade.apidevendas.domain.vendedor;

import com.atividade.apidevendas.entities.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public List<Vendedor> listarTodos(){ return repository.findAll(); }

    public Vendedor buscarPorId(Long id){ return repository.findById(id).orElse(null); }

    public List<Vendedor> buscarVendedorPorNome(String nome){ return repository.findByName(nome); }

    public Vendedor salvar(Vendedor vendedor){ return repository.save(vendedor); }

    public Vendedor atualizar(Vendedor vendedor){
        if(buscarPorId(vendedor.getId()) != null){
            return repository.save(vendedor);
        } else {
            throw new IllegalStateException("Vendedor informado não encontradoe");
        }
    }

    public void deletar(Vendedor vendedor){
        if(buscarPorId(vendedor.getId()) != null){
            repository.delete(vendedor);
        } else {
            throw new IllegalStateException("Vendedor informado não encontradoe");
        }
    }

}
