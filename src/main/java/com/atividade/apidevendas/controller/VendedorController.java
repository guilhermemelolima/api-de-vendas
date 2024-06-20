package com.atividade.apidevendas.controller;

import com.atividade.apidevendas.domain.vendedor.VendedorDto;
import com.atividade.apidevendas.domain.vendedor.VendedorMapper;
import com.atividade.apidevendas.domain.vendedor.VendedorService;
import com.atividade.apidevendas.entities.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<List<VendedorDto>>  listarProdutos(){
        List<VendedorDto> dtoList = VendedorMapper.toDtoList(service.listarTodos());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/buscarPorNome/{nome}")
    public ResponseEntity<List<VendedorDto>> buscarVendedorPorNome(@PathVariable String nome){
        List<VendedorDto> dtoList = VendedorMapper.toDtoList(service.buscarVendedorPorNome(nome));
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

   @GetMapping("/buscarPorId/{id}")
   public ResponseEntity<VendedorDto> buscarPorId(@PathVariable Long id){
        VendedorDto dto = VendedorMapper.toDto(service.buscarPorId(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
   }

   @PostMapping
    public ResponseEntity<VendedorDto> salvar(Vendedor vendedor){
        VendedorDto dto = VendedorMapper.toDto(service.salvar(vendedor));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
   }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDto> atualizar(Vendedor vendedor){
        VendedorDto dto = VendedorMapper.toDto(service.atualizar(vendedor));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(Vendedor vendedor){
        service.deletar(vendedor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
