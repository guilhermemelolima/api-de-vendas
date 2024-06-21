package com.atividade.apidevendas.domain.transportadora;

import com.atividade.apidevendas.entities.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
    @Query("SELECT t FROM Transportadora t WHERE LOWER(t.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Transportadora> findByName(String nome);
}
