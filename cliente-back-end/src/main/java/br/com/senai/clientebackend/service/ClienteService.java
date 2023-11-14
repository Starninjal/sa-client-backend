package br.com.senai.clientebackend.service;

import br.com.senai.clientebackend.dto.ClienteDTO;
import br.com.senai.clientebackend.model.Cliente;
import br.com.senai.clientebackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public void excluirCliente(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


}
