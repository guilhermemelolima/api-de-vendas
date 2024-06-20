package com.atividade.apidevendas.controller;

import com.atividade.apidevendas.domain.pedido.PedidoDto;
import com.atividade.apidevendas.domain.pedido.PedidoMapper;
import com.atividade.apidevendas.domain.pedido.PedidoService;
import com.atividade.apidevendas.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listarPedidos() {
        List<PedidoDto> dtoList = PedidoMapper.toDtoList(service.listarTodos());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoDto>> buscarPedidosPorData(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<PedidoDto> dtoList =  PedidoMapper.toDtoList(service.listarPorData(startDate, endDate));
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<PedidoDto> buscarPedidoPorId(@PathVariable long id) {
        PedidoDto dtoList = PedidoMapper.toDto(service.buscarPorId(id));
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> salvarPedido(@RequestBody Pedido pedido) {
        PedidoDto dtoSalvar = PedidoMapper.toDto(service.salvar(pedido));
        return new ResponseEntity<>(dtoSalvar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizarPedido(@PathVariable long id, @RequestBody Pedido pedido) {
        PedidoDto dtoAtualizar = PedidoMapper.toDto(service.atualizar(pedido));
        return new ResponseEntity<>(dtoAtualizar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
