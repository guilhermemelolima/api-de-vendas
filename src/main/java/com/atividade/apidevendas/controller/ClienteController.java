package com.atividade.apidevendas.controller;

import java.util.List;

import com.atividade.apidevendas.domain.pedido.PedidoDto;
import com.atividade.apidevendas.domain.pedido.PedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.apidevendas.domain.cliente.ClienteDto;
import com.atividade.apidevendas.domain.cliente.ClienteMapper;
import com.atividade.apidevendas.domain.cliente.ClienteService;
import com.atividade.apidevendas.entities.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarClientes() {
        List<ClienteDto> clientes = ClienteMapper.toDTOList(clienteService.listarClientes());
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable long id) {
        ClienteDto cliente = ClienteMapper.toDto(clienteService.buscarClientePorId(id));
        return  new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    
    @GetMapping("/buscarPorNome/{nome}")
    public ResponseEntity<List<ClienteDto>> buscarClientesPorNome(@PathVariable String nome) {
        List<ClienteDto> clientes = ClienteMapper.toDTOList(clienteService.buscarClientesPorNome(nome));
        return clientes != null ? new ResponseEntity<>(clientes, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/pedidos")
    public ResponseEntity<List<PedidoDto>> buscarPedidosPeloClienteId(@PathVariable Long id){
        List<PedidoDto> pedidosDto = PedidoMapper.toDtoList(clienteService.buscarPedidosPeloClienteId(id));
        return new ResponseEntity<>(pedidosDto, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ClienteDto> adicionarCliente(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        ClienteDto clienteSalvo = ClienteMapper.toDto(clienteService.salvarCliente(cliente));
        return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable long id, @RequestBody ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        ClienteDto clienteAtualizado = ClienteMapper.toDto(clienteService.atualizarCliente(id, cliente));
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable long id) {
        clienteService.excluirCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
