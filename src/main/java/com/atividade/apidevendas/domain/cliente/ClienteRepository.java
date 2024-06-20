package com.atividade.apidevendas.domain.cliente;

import java.util.List;

import com.atividade.apidevendas.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import com.atividade.apidevendas.entities.Cliente;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Cliente> findByName(String nome);

    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :id")
    List<Pedido> buscarPedidosPeloClienteId(Long id);

}
