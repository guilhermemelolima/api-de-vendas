package com.atividade.apidevendas.domain.pedidoItens;

import com.atividade.apidevendas.entities.PedidoItens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItensRepository  extends JpaRepository<PedidoItens, Long> {
}
