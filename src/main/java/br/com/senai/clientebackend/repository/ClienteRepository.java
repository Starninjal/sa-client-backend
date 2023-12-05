package br.com.senai.clientebackend.repository;

import br.com.senai.clientebackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Boolean existsByCpfClienteAndNomeCliente(String CpfCliente, String NomeCliente);

    Optional<Cliente> findClienteByCpfCliente(String cpfCliente);
}
