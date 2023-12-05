package br.com.senai.clientebackend.service;

import br.com.senai.clientebackend.dto.ClienteDTO;
import br.com.senai.clientebackend.model.Cliente;
import br.com.senai.clientebackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvarCliente(ClienteDTO clienteDTO, Blob blob) {
        Cliente cliente = new Cliente(clienteDTO);
        cliente.setImage(blob);
        return clienteRepository.save(cliente);
    }

    public void excluirCliente(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Boolean isClienteLogado(ClienteDTO clienteDto) {
        return clienteRepository.existsByCpfClienteAndNomeCliente(clienteDto.getCpfCliente(), clienteDto.getNomeCliente());
    }

    public Cliente getClienteBy(String cpfCliente) {
        return clienteRepository.findClienteByCpfCliente(cpfCliente).orElseThrow();
    }


}
