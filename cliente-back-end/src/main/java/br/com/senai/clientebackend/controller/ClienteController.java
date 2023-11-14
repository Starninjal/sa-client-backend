package br.com.senai.clientebackend.controller;

import br.com.senai.clientebackend.client.SecurityClient;
import br.com.senai.clientebackend.dto.ClienteDTO;
import br.com.senai.clientebackend.model.Cliente;
import br.com.senai.clientebackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private SecurityClient securityClient;
    @PostMapping("/cliente")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        long idUsuario = securityClient.criarUsuario(clienteDTO.getUsuarioDto());
        clienteDTO.setIdUsuario(idUsuario);
        Cliente cliente = clienteService.salvarCliente(clienteDTO);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes.stream().map(ClienteDTO::new).toList());
    }

    @PutMapping("/cliente")
    public ResponseEntity<ClienteDTO> alterarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }
    @DeleteMapping("/cliente/{idCliente}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Integer idCliente) {
        clienteService.excluirCliente(idCliente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

