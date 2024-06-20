package com.atividade.apidevendas.domain.pedido;

import com.atividade.apidevendas.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.data BETWEEN :startDate AND :endDate")
    List<Pedido> findByData(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}
