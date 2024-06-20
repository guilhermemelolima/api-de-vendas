package com.atividade.apidevendas.domain.transportadora;

import com.atividade.apidevendas.entities.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
}
