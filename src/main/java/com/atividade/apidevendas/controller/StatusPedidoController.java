package com.atividade.apidevendas.controller;

import com.atividade.apidevendas.enums.StatusPedido;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/statusPedido")
public class StatusPedidoController {

    @GetMapping
    public List<String> getStatusList(){
        return Arrays.stream(StatusPedido.values())
                .map(StatusPedido::getStatus)
                .collect(Collectors.toList());
    }
}
