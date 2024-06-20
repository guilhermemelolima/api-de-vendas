package com.atividade.apidevendas.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {
    PENDENTE("PENDENTE"),
    CONFIRMADO("CONFIRMADO"),
    EM_PROCESSAMENTO("EM_PROCESSAMENTO"),
    ENVIADO("ENVIADO"),
    ENTREGUE("ENTREGUE"),
    CANCELADO("CANCELADO"),
    DEVOLVIDO("DEVOLVIDO"),
    REEMBOLSADO("REEMBOLSADO"),
    AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO"),
    FALHA_PAGAMENTO("FALHA_PAGAMENTO");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }

}
