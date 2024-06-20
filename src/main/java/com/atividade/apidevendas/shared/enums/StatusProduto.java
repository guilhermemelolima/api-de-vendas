package com.atividade.apidevendas.enums;

import lombok.Getter;

@Getter
public enum StatusProduto {
    FORA_DE_ESTOQUE("FORA_DE_ESTOQUE"),
    EM_ESTOQUE("EM_ESTOQUE"),
    DISPONIVEL_PARA_RESERVA("DISPONIVEL_PARA_RESERVA");

    private final String status;

    StatusProduto(String status) {
        this.status = status;
    }
}
