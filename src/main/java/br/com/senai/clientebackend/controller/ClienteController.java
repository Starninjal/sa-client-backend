package br.com.senai.clientebackend.controller;

import br.com.senai.clientebackend.dto.ClienteDTO;
import br.com.senai.clientebackend.model.Cliente;
import br.com.senai.clientebackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.Serial;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
//    @Autowired
//    private SecurityClient securityClient;
    @PostMapping("/cliente")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
//        long idUsuario = securityClient.criarUsuario(clienteDTO.getUsuarioDto());
//        clienteDTO.setIdUsuario(idUsuario);
        Cliente cliente = clienteService.salvarCliente(clienteDTO, null);
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
    @PostMapping("/get/cliente")
    public ResponseEntity<Boolean> getClienteBy(@RequestBody ClienteDTO clienteDto) {
        Boolean isLogado = clienteService.isClienteLogado(clienteDto);
        return ResponseEntity.ok(isLogado);
    }

    @GetMapping("/get/cliente/{cpfCliente}")
    public ResponseEntity<Cliente> getClienteBy(@PathVariable("cpfCliente") String cpfCliente) {
        Cliente cliente = clienteService.getClienteBy(cpfCliente);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/cliente/save")
    public ResponseEntity<ClienteDTO> saveCliente(@RequestParam MultipartFile file, @RequestParam String cpfCliente) throws IOException, SQLException {
        Cliente cliente = clienteService.getClienteBy(cpfCliente);
        Blob blob = new SerialBlob(file.getBytes());
        cliente.setImage(blob);
        clienteService.salvarCliente(new ClienteDTO(cliente), blob);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }
}

