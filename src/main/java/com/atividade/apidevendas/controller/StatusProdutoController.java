package com.atividade.apidevendas.controller;

import com.atividade.apidevendas.enums.StatusProduto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/statusProduto")
public class StatusProdutoController {

    @GetMapping
    public List<String> getStatusList() {
        return Arrays.stream(StatusProduto.values())
                .map(StatusProduto::getStatus)
                .collect(Collectors.toList());
    }

}
