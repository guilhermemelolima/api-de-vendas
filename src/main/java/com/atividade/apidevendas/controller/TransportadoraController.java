package com.atividade.apidevendas.controller;

import com.atividade.apidevendas.domain.transportadora.TransportadoraDto;
import com.atividade.apidevendas.domain.transportadora.TransportadoraMapper;
import com.atividade.apidevendas.domain.transportadora.TransportadoraService;
import com.atividade.apidevendas.entities.Transportadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transportadora")
public class TransportadoraController {

    @Autowired
    TransportadoraService transportadoraService;

    @GetMapping
    public ResponseEntity<List<TransportadoraDto>> listar() {
        List<TransportadoraDto> dtoList = TransportadoraMapper.toDTOList(transportadoraService.listarTransportadoras());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<TransportadoraDto> buscarPorId(@PathVariable Long id) {
        TransportadoraDto dto = TransportadoraMapper.toDto(transportadoraService.buscarTransportadoraPorId(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TransportadoraDto> cadastrar(@RequestBody Transportadora transportadora) {
        TransportadoraDto dto = TransportadoraMapper.toDto(transportadoraService.salvarTransportadora(transportadora));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportadoraDto> atualizar(@RequestBody Transportadora transportadora){
        TransportadoraDto dto = TransportadoraMapper.toDto(transportadoraService.atualizarTransportadora(transportadora));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        transportadoraService.excluirTransportadora(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
