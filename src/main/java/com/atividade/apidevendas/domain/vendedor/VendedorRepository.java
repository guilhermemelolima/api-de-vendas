package com.atividade.apidevendas.domain.vendedor;

import com.atividade.apidevendas.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT v FROM Vendedor v WHERE LOWER(v.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Vendedor> findByName(String nome);

}
